package com.proyecto.tienda.controladores;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.tienda.modelos.ClienteModel;
import com.proyecto.tienda.servicios.ClienteService;

//Controlador Clientes

@Controller
public class ClienteController {
	
	//Conectamos al respectivo servicio
	
	@Autowired
	private ClienteService clienteService;
	
	//Validación del ingreso del cliente
	
	@PostMapping("/validarC")
	public String validarc(@RequestParam(value = "usernamec", required = true) String usernamec,
						   @RequestParam(value = "passwordc", required = true) String passwordc,
						   Model model) {
		Optional<ClienteModel> clientesAll = clienteService.loginC(usernamec, passwordc);
		if (clientesAll.isPresent()){
			model.addAttribute("cliente", clientesAll.get());
			ArrayList<ClienteModel> listaClientes = clienteService.listarClientes();
			model.addAttribute("listaClientes", listaClientes);
			
		return "HomeClientes";
		}
	return "redirect:/login";
	}
	
}
