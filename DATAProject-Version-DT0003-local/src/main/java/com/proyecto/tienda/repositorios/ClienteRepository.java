package com.proyecto.tienda.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyecto.tienda.modelos.ClienteModel;

public interface ClienteRepository extends CrudRepository<ClienteModel, Long>{
	
	@Query (nativeQuery = true, value="SELECT * FROM clientes WHERE usuarioc=? and passwordc=?")
	public abstract Optional<ClienteModel> loginCl(String usuarioc,String passwordc);

}
