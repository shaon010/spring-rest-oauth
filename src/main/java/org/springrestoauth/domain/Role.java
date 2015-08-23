package org.springrestoauth.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shaon on 8/14/2015.
 */
@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue
    Long id;

    @NotEmpty
    String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<Student> users = new HashSet<Student>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getAuthority(){
        return name;
    }
    public Set<Student> getUsers() {
        return users;
    }
    public void setUsers(Set<Student> users) {
        this.users = users;
    }


}
