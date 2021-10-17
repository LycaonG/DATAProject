package com.proyecto.tienda.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyecto.tienda.modelos.ComprasModel;

public interface ComprasRepository extends CrudRepository <ComprasModel, Long>{

	@Query (nativeQuery = true, value="SELECT * FROM compras WHERE N_cuentadecobro=?")
	public abstract Optional<ComprasModel> buscarcompra(Long N_cuentadecobro);
}
