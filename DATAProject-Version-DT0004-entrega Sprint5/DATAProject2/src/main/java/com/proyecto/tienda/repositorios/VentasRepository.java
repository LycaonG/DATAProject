package com.proyecto.tienda.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyecto.tienda.modelos.VentasModel;

public interface VentasRepository extends CrudRepository <VentasModel, Long>{

	@Query (nativeQuery = true, value="SELECT * FROM ventas WHERE N_factura=?")
	public abstract Optional<VentasModel> buscarventa(Long N_factura);
}
