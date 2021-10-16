package com.proyecto.tienda.controladores;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.tienda.modelos.ProveedorModel;
import com.proyecto.tienda.servicios.ProveedorService;

//Controlador proveedores

@Controller
public class ProveedorController {
	
	//Conectamos al respectivo servicio
	
	@Autowired
	private ProveedorService proveedorService;
	
	//Validación del ingreso del proveedor
	
	@PostMapping ("/validarP")
	public String validarp (@RequestParam(value = "usernamep", required = true) String usernamep,
			   @RequestParam(value = "passwordp", required = true) String passwordp,
			   Model model) {
		Optional<ProveedorModel> proveedoresAll = proveedorService.loginP(usernamep, passwordp);
		if (proveedoresAll.isPresent()){
			model.addAttribute("proveedor", proveedoresAll.get());
			ArrayList<ProveedorModel> listaProveedores = proveedorService.listarProveedores();
			model.addAttribute("listaProveedores", listaProveedores);
			
		return "HomeProveedores";
		}
	return "redirect:/";
	}

}
