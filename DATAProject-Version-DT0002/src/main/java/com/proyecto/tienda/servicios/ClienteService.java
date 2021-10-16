package com.proyecto.tienda.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tienda.modelos.ClienteModel;
import com.proyecto.tienda.repositorios.BuscarRepositoryC;
import com.proyecto.tienda.repositorios.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
		private ClienteRepository clienteRepository;
	
	@Autowired
	    private BuscarRepositoryC buscarRepositoryC;
	
	
	public Optional<ClienteModel> loginC (String usuarioc, String passwordc){
		return clienteRepository.loginCl(usuarioc,passwordc);
	}
	
	public Optional<ClienteModel> buscarc(String cedula){
        return buscarRepositoryC.buscarc(cedula);        
    }
	
	public ArrayList<ClienteModel> listarClientes(){
		return(ArrayList<ClienteModel>)clienteRepository.findAll();
	}
	
	public Optional<ClienteModel> obtenerPorIdc(Long id){
		return clienteRepository.findById(id);
	}
	
	public ClienteModel insertarCliente (ClienteModel cliente) {
		
		return clienteRepository.save(cliente);
		
	}
	
	public ClienteModel editarCliente (ClienteModel cliente) {
		return clienteRepository.save(cliente);
		
	}
	
	public boolean eliminarCliente (Long id) {
		try {
			clienteRepository.deleteById(id);
			return true;
		}catch(Exception e){
            return false;
		}
	}
}
