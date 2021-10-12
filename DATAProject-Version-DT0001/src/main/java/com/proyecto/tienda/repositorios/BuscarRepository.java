package com.proyecto.tienda.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.tienda.modelos.UsuarioModel;

@Repository
public interface BuscarRepository extends CrudRepository<UsuarioModel, Long> {
    
    @Query (nativeQuery = true, value ="SELECT * FROM usuarios WHERE cedula=?")
    public abstract Optional<UsuarioModel> buscar(String cedula);
}

