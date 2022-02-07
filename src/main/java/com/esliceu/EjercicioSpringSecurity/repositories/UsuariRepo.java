package com.esliceu.EjercicioSpringSecurity.repositories;

import com.esliceu.EjercicioSpringSecurity.models.Usuari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuariRepo extends JpaRepository<Usuari, Integer> {
@Query(nativeQuery = true, value = "Select * from usuari where username = :username")
    Usuari getUser(@Param("username")String username);
}
