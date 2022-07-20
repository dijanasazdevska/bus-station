package com.example.station.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@Table(name = "patnik", schema = "stanica")
public class User implements UserDetails {
    @Id
    @Column(name = "embg", length = 13)
    private String embg;

    @Column(name="korisnichko_ime")
    private String username;

    @Column(name="ime")
    private String name;

    @Column(name = "prezime")
    private String surname;

    @Column(name="lozinka")
    private String password;

    public User() {


    }

    public User(String embg,String username, String password, String name, String surname) {
        this.embg = embg;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(Role.ROLE_USER);
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
