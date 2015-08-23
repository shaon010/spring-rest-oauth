package org.springrestoauth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springrestoauth.domain.Student;

import java.util.List;

/**
 * Created by Shaon on 8/15/2015.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Student findByNameEquals(@Param("name")String name);
}
