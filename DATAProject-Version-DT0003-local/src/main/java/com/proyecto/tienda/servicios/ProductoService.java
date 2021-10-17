package com.proyecto.tienda.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tienda.modelos.ProductoModel;
import com.proyecto.tienda.repositorios.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	public Optional<ProductoModel> buscarprod(Long codigo){
        return productoRepository.buscarprod(codigo);        
    }
	
	public ArrayList<ProductoModel> listarProductos(){
		return(ArrayList<ProductoModel>)productoRepository.findAll();
	}
	
	public Optional<ProductoModel> obtenerPorIdc(Long codigo){
		return productoRepository.findById(codigo);
	}
	
	public ProductoModel insertarProducto (ProductoModel producto) {
		
		return productoRepository.save(producto);
		
	}
	
	public ProductoModel editarProducto (ProductoModel producto) {
		return productoRepository.save(producto);
		
	}
	
	public boolean eliminarProducto (Long codigo) {
		try {
			productoRepository.deleteById(codigo);
			return true;
		}catch(Exception e){
            return false;
		}
	}

}
