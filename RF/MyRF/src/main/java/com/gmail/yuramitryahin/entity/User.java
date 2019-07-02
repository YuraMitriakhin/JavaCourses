package com.gmail.yuramitryahin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table( name="user",
            uniqueConstraints={@UniqueConstraint(columnNames={"username"})})
    public class User implements UserDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "id", nullable = false)
        private long id;
        @Column
        private String username;
        @Column
        private String email;
        @Column(name = "role")
        @Enumerated(EnumType.STRING)
        private Role authorities;
        @Column
        private String password;
        @Column
        private boolean accountNonExpired=true;
        @Column
        private boolean accountNonLocked=true;
        @Column
        private boolean credentialsNonExpired=true;
        @Column
        private boolean enabled=true;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            Collection<Role> collection = new ArrayList<>();
            ((ArrayList<Role>) collection).add(authorities);
            return collection;
        }
    }
