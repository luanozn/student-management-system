package com.example.studentmanagementsystem.entities;

import static com.example.studentmanagementsystem.entities.enums.UserRole.ADMIN;
import static com.example.studentmanagementsystem.entities.enums.UserRole.PROFESSOR;

import com.example.studentmanagementsystem.entities.enums.UserRole;
import java.util.Collection;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public class User implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column (nullable = false, unique = true, length = 16)
    private Long registration;

    @Column (nullable = false, length = 50)
    private String name;

    @Column (nullable = false, unique = true, length = 255)
    private Long email;

    @Column (nullable = false, unique = true)
    private String login;

    @Column (nullable = false, unique = true, length = 30)
    private String password;

    private UserRole role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_PROFESSOR"), new SimpleGrantedAuthority("ROLE_STUDENT"));
        else if (this.role == PROFESSOR) return List.of(new SimpleGrantedAuthority("ROLE_PROFESSOR"), new SimpleGrantedAuthority("ROLE_STUDENT"));
        else return List.of(new SimpleGrantedAuthority("ROLE_STUDENT"));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
