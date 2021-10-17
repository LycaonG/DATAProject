package com.proyecto.tienda.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyecto.tienda.modelos.ProveedorModel;

public interface ProveedorRepository extends CrudRepository<ProveedorModel, Long>{
	
	@Query (nativeQuery = true, value="SELECT * FROM proveedores WHERE usuariop=? and passwordp=?")
	public abstract Optional<ProveedorModel> loginPr(String usuariop,String passwordp);

}
