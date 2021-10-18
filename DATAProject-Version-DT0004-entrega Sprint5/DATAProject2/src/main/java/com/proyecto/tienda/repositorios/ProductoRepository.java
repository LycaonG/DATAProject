package com.proyecto.tienda.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyecto.tienda.modelos.ProductoModel;

public interface ProductoRepository extends CrudRepository<ProductoModel, Long>{
	
	@Query (nativeQuery = true, value="SELECT * FROM productos WHERE codigo=?")
	public abstract Optional<ProductoModel> buscarprod (Long codigo);

}
