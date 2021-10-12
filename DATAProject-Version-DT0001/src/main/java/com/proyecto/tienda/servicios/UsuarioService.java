package com.proyecto.tienda.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tienda.modelos.UsuarioModel;
import com.proyecto.tienda.repositorios.BuscarRepository;
import com.proyecto.tienda.repositorios.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private BuscarRepository buscarRepository;

    public Optional<UsuarioModel> login(String usuario,String password){
        return usuarioRepository.login(usuario,password);        
    }
    
    public Optional<UsuarioModel> buscar(String cedula){
        return buscarRepository.buscar(cedula);        
    }
    
    

    public ArrayList<UsuarioModel> listarUsuarios(){
        return (ArrayList<UsuarioModel>)usuarioRepository.findAll();
    }
    
    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }
    
    public UsuarioModel InsertarUsuario(UsuarioModel user){
        return usuarioRepository.save(user);
    }

    public UsuarioModel editarUsuario(UsuarioModel user){
        return usuarioRepository.save(user);
    }   
    
    public boolean eliminarUsuario(Long id) {
    	try{    
            usuarioRepository.deleteById(id);            
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
