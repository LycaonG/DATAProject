package com.proyecto.tienda.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.tienda.modelos.ClienteModel;

@Repository
public interface BuscarRepositoryC extends CrudRepository <ClienteModel, Long> {
    
    @Query (nativeQuery = true, value ="SELECT * FROM clientes WHERE cedula=?")
    public abstract Optional<ClienteModel> buscarc(String cedulac);
}

