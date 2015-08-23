package org.springrestoauth.service;

import org.hibernate.loader.custom.Return;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springrestoauth.Repository.RoleRepository;
import org.springrestoauth.Repository.StudentRepository;
import org.springrestoauth.domain.Role;
import org.springrestoauth.domain.Student;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shaon on 8/15/2015.
 */
@Service
public class BootstrapDataPopulator implements InitializingBean {

    private final Logger LOG = LoggerFactory.getLogger(BootstrapDataPopulator.class);

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional()
    public void afterPropertiesSet() throws Exception {
        LOG.info("Bootstrapping data...");
        createUserRole();
        createSystemUser();
        LOG.info("...Bootstrapping completed");
    }

    private void createSystemUser() {
        if (studentRepository.findAll().size() > 0) {
            return;
        }
        LOG.info("... creating system user");
        Student student = new Student();
        student.setName("shaon");
        student.setPassword("admin");
        Set<Role> roleSet = new HashSet<Role>();
        roleSet.add(roleRepository.findByNameEquals("ROLE_ADMIN"));
        roleSet.add(roleRepository.findByNameEquals("ROLE_BASIC"));
        student.setRoles(roleSet);
        studentRepository.saveAndFlush(student);


        student = new Student();
        student.setName("sabbir");
        student.setPassword("123456");
        roleSet = new HashSet<Role>();
        roleSet.add(roleRepository.findByNameEquals("ROLE_BASIC"));
        student.setRoles(roleSet);
        studentRepository.saveAndFlush(student);
        //My first java 8  lambda
        studentRepository.findAll().forEach(student1 -> LOG.info(student1.getName()+student1.getRoles().size()));
    }
    private void createUserRole() {
        if (studentRepository.findAll().size() > 0) {
            return;
        }
        LOG.info("... creating system role");
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        roleRepository.saveAndFlush(role);

        role = new Role();
        role.setName("ROLE_BASIC");
        roleRepository.saveAndFlush(role);

        roleRepository.findAll().forEach(role1 -> LOG.info(role1.getName()));

    }
}