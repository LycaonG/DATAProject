package com.proyecto.tienda.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tienda.modelos.ComprasModel;
import com.proyecto.tienda.repositorios.ComprasRepository;

@Service
public class ComprasService {
	
	@Autowired
	private ComprasRepository comprasRepository;
	
	public Optional<ComprasModel> buscarcompra(Long N_cuentadecobro){
        return comprasRepository.buscarcompra(N_cuentadecobro);        
    }
	
	public ArrayList<ComprasModel> listarCompras(){
		return(ArrayList<ComprasModel>)comprasRepository.findAll();
	}
	
	public Optional<ComprasModel> obtenerPorIdc(Long N_cuentadecobro){
		return comprasRepository.findById(N_cuentadecobro);
	}
	
	public ComprasModel insertarCompra (ComprasModel compra) {
		
		return comprasRepository.save(compra);
		
	}
	
	public ComprasModel editarCompra (ComprasModel compra) {
		return comprasRepository.save(compra);
		
	}

}
