package com.esliceu.EjercicioSpringSecurity.services;

import com.esliceu.EjercicioSpringSecurity.models.Usuari;
import com.esliceu.EjercicioSpringSecurity.repositories.UsuariRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UsuariRepo usuariRepo;

    public void newUser(String username, String password,String fullname){
        Usuari us = new Usuari(username, passwordEncoder.encode(password),Usuari.Rol.ROLE_USER);
        us.setFullname(fullname);
        usuariRepo.save(us);
    }

}
