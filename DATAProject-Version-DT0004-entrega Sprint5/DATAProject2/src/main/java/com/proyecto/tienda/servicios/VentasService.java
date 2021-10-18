package com.proyecto.tienda.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tienda.modelos.VentasModel;
import com.proyecto.tienda.repositorios.VentasRepository;

@Service
public class VentasService {
	
	@Autowired
	private VentasRepository ventasRepository;
	
	public Optional<VentasModel> buscarventa(Long N_factura){
        return ventasRepository.buscarventa(N_factura);        
    }
	
	public ArrayList<VentasModel> listarVentas(){
		return(ArrayList<VentasModel>)ventasRepository.findAll();
	}
	
	public Optional<VentasModel> obtenerPorIdc(Long N_factura){
		return ventasRepository.findById(N_factura);
	}
	
	public VentasModel insertarVenta (VentasModel venta) {
		
		return ventasRepository.save(venta);
		
	}
	
	public VentasModel editarVenta (VentasModel venta) {
		return ventasRepository.save(venta);
		
	}

}
