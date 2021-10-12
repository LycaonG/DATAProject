package com.proyecto.tienda.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.tienda.modelos.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    
    @Query (nativeQuery = true, value ="select * from usuarios where usuario=:usuario and password=:password")
    public abstract Optional<UsuarioModel> login(String usuario,String password);

    
}