package org.springrestoauth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springrestoauth.domain.Role;
import org.springrestoauth.domain.Student;

/**
 * Created by Shaon on 8/15/2015.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByNameEquals(String name);
}
