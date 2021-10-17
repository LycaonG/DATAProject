package com.proyecto.tienda.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.tienda.modelos.ProveedorModel;

@Repository
public interface BuscarRepositoryP extends CrudRepository <ProveedorModel, Long> {
    
    @Query (nativeQuery = true, value ="SELECT * FROM proveedores WHERE nit=?")
    public abstract Optional<ProveedorModel> buscarp(String nit);
}

