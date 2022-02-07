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
    private String username;
    private String passwd;
    private String fullname;
    @Nullable
    private byte[] photo;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Nullable
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(@Nullable byte[] photo) {
        this.photo = photo;
    }
}
