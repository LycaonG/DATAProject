package com.proyecto.tienda.controladores;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

import com.proyecto.tienda.modelos.UsuarioModel;
import com.proyecto.tienda.servicios.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping({ "/login", "/" })
    public String login(Model model) {

        return "login";
    }

    @PostMapping("/validar")
    public String validar(@RequestParam(value = "username", required = true) String username,
            			  @RequestParam(value = "password", required = true) String password,
            			  Model model) {

        Optional<UsuarioModel> usuariosAll = usuarioService.login(username, password);
        if (usuariosAll.isPresent()) {
            model.addAttribute("usuario", usuariosAll.get());
            ArrayList<UsuarioModel> listaUsuarios = usuarioService.listarUsuarios();
            model.addAttribute("listaUsuarios", listaUsuarios);

            return "Home";
        }
        return "redirect:/";
    }
    

    @PostMapping("/validarB")
    public String validarB(@RequestParam(value = "cedula", required = true) String cedula, Model model){
        Optional<UsuarioModel> usuarioB = usuarioService.buscar(cedula);
        if (usuarioB.isPresent()) {
            model.addAttribute("usuarioB", usuarioB.get());
           
            return "usuarioB";
        }
        return "Home";
    }
    
    @GetMapping("/buscar")
    public String buscar(Model model) {

        return "buscar";
    }

    @GetMapping("/salir")
    public String salir(Model model) {

        return "redirect:/";

    }
    
    @GetMapping("/home")
    public String home(Model model) {

        return "Home";
    }
    
    @GetMapping("/listarUsuarios")
    public String listarUsuarios(UsuarioModel usuarioDto, Model model) {
        if (usuarioDto.getId() != null) {
        	usuarioService.listarUsuarios();
        }
        ArrayList<UsuarioModel> listaUsuarios = usuarioService.listarUsuarios();
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "usuariosLista";
    }
    
    
    @GetMapping("/gestionU")
    public String gestionUsuarios(UsuarioModel usuarioDto, Model model) {
        if (usuarioDto.getId() != null) {
        	usuarioService.listarUsuarios();
        }
        ArrayList<UsuarioModel> listaUsuarios = usuarioService.listarUsuarios();
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "gestionUsuarios";
    }

    @PostMapping("/administracion")
    public String agregar(UsuarioModel usuarioDto, Model model) {
        if (usuarioDto.getId() == null) {
            usuarioService.InsertarUsuario(usuarioDto);
        } else {
            usuarioService.editarUsuario(usuarioDto);
        }
        ArrayList<UsuarioModel> listaUsuarios = usuarioService.listarUsuarios();
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "gestionUsuarios";
    }
    
    @GetMapping("/agregar/{id}")
    public String agregar(@PathVariable("id") Long id, Model model) {
        if (id != null && id != 0) {
            model.addAttribute("usuario", usuarioService.obtenerPorId(id));
        } else {
            model.addAttribute("usuario", new UsuarioModel());
        }
        return "agregar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        if (id != null && id != 0) {
            model.addAttribute("usuario", usuarioService.obtenerPorId(id));
        } else {
            model.addAttribute("usuario", new UsuarioModel());
        }
        return "edicion";
    }
    

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, Model model) {
        usuarioService.eliminarUsuario(id);
        ArrayList<UsuarioModel> listaUsuarios = usuarioService.listarUsuarios();
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "gestionUsuarios";
    }

}
