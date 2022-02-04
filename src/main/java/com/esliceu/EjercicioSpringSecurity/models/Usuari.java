package com.esliceu.EjercicioSpringSecurity.models;

import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuari")
public class Usuari extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String cognom;
    private String username;
    private String passwd;
    private int edat;
    private byte[] photo;
    @Nullable
    private String correu;

    public enum Rol{
        ROLE_ADMIN,
        ROLE_USER,
        ROLE_GUEST,
    };

    public Usuari(String username, String passwd, Rol rol){

        super(username,passwd,toList(rol));
    }

    private static Collection<? extends GrantedAuthority> toList(Rol rol) {
        List <GrantedAuthority> roles = new ArrayList <>();
        roles.add(new SimpleGrantedAuthority(rol.toString()));
        return roles;
    }
}
