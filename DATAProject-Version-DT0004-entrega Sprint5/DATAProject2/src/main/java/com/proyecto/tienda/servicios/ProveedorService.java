package com.proyecto.tienda.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tienda.modelos.ProveedorModel;
import com.proyecto.tienda.repositorios.BuscarRepositoryP;
import com.proyecto.tienda.repositorios.ProveedorRepository;

@Service
public class ProveedorService {
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Autowired
    private BuscarRepositoryP buscarRepositoryP;
	
	public Optional<ProveedorModel> loginP (String usuariop, String passwordp){
		return proveedorRepository.loginPr(usuariop,passwordp);
	}
	
	public Optional<ProveedorModel> buscarp(String nit){
        return buscarRepositoryP.buscarp(nit);        
    }
	
	public ArrayList<ProveedorModel> listarProveedores(){
		return(ArrayList<ProveedorModel>)proveedorRepository.findAll();
	}
	
	public Optional<ProveedorModel> obtenerPorIdc(Long id){
		return proveedorRepository.findById(id);
	}
	
	public ProveedorModel insertarProveedor (ProveedorModel proveedor) {
		
		return proveedorRepository.save(proveedor);
		
	}
	
	public ProveedorModel editarProveedor (ProveedorModel proveedor) {
		return proveedorRepository.save(proveedor);
		
	}
	
	public boolean eliminarProveedor (Long id) {
		try {
			proveedorRepository.deleteById(id);
			return true;
		}catch(Exception e){
            return false;
		}
	}

}
