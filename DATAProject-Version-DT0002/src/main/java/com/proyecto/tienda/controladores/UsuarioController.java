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

import com.proyecto.tienda.modelos.ClienteModel;
import com.proyecto.tienda.modelos.ProveedorModel;
import com.proyecto.tienda.modelos.UsuarioModel;
import com.proyecto.tienda.servicios.ClienteService;
import com.proyecto.tienda.servicios.ProveedorService;
import com.proyecto.tienda.servicios.UsuarioService;

// Controlador general

@Controller
public class UsuarioController {

//Conectamos a los diferentes servicios
	
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private ProveedorService proveedorService;
    
//Login inicial
    
    @GetMapping({ "/login", "/" })
    public String login(Model model) {

        return "login";
    }
    
//Servicios de validación

    //Validación del usuario administrativo
    
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

    //Validacion de la busqueda de usuario administrativo

    @PostMapping("/validarB")
    public String validarB(@RequestParam(value = "cedula", required = true) String cedula, Model model){
        Optional<UsuarioModel> usuarioB = usuarioService.buscar(cedula);
        if (usuarioB.isPresent()) {
            model.addAttribute("usuarioB", usuarioB.get());
           
            return "usuarioB";
        }
        return "Home";
    }
    
    //Validación de la busqueda de cliente
    
    @PostMapping("/validarBC")
    public String validarBC(@RequestParam(value = "cedula", required = true) String cedula, Model model){
        Optional<ClienteModel> clienteB = clienteService.buscarc(cedula);
        if (clienteB.isPresent()) {
            model.addAttribute("clienteB", clienteB.get());
           
            return "clienteB";
        }
        return "Home";
    }
    
//Validación de la busqueda de proveedor
    
    @PostMapping("/validarBP")
    public String validarBP(@RequestParam(value = "nit", required = true) String nit, Model model){
        Optional<ProveedorModel> proveedorB = proveedorService.buscarp(nit);
        if (proveedorB.isPresent()) {
            model.addAttribute("proveedorB", proveedorB.get());
           
            return "proveedorB";
        }
        return "Home";
    }
    
//Zona de busqueda, ingreso y salida    
    
    //Servicio buscar usuario administrativo
    
    @GetMapping("/buscar")
    public String buscar(Model model) {

        return "buscar";
    }
    
    //Servicio buscar cliente
    
    @GetMapping("/buscarC")
    public String buscarC(Model model) {

        return "buscarC";
    }
    
    //Servicio buscar proveedor
    
    @GetMapping("/buscarP")
    public String buscarP(Model model) {

        return "buscarP";
    }
    
    //Servicio de salida general    

    @GetMapping("/salir")
    public String salir(Model model) {

        return "redirect:/";

    }
    
    //Servicio de ingreso al Home de administración    
    
    @GetMapping("/home")
    public String home(Model model) {

        return "Home";
    }
    
//Zona de listados
    
    //Servicio de listado de usuarios administrativos
    
    @GetMapping("/listarUsuarios")
    public String listarUsuarios(UsuarioModel usuarioDto, Model model) {
        if (usuarioDto.getId() != null) {
        	usuarioService.listarUsuarios();
        }
        ArrayList<UsuarioModel> listaUsuarios = usuarioService.listarUsuarios();
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "usuariosLista";
    }
    
  //Servicio de listado de clientes
    
    @GetMapping("/listarClientes")
    public String listarClientes(ClienteModel clienteDto, Model model) {
        if (clienteDto.getId() != null) {
        	clienteService.listarClientes();
        }
        ArrayList<ClienteModel> listaClientes = clienteService.listarClientes();
        model.addAttribute("listaClientes", listaClientes);
        return "clientesLista";
    }
    
    //Servicio de listado de proveedores
    
    @GetMapping("/listarProveedores")
    public String listarProveedores(ProveedorModel proveedorDto, Model model) {
        if (proveedorDto.getId() != null) {
        	proveedorService.listarProveedores();
        }
        ArrayList<ProveedorModel> listaProveedores = proveedorService.listarProveedores();
        model.addAttribute("listaProveedores", listaProveedores);
        return "proveedoresLista";
    }
    
//Zona de gestión CRUD1
    
  //Servicios de gestión de usuarios administrativos
    
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
    
  //Servicios de gestión de clientes
    
    @GetMapping("/gestionC")
    public String gestionClientes(ClienteModel clienteDto, Model model) {
        if (clienteDto.getId() != null) {
        	clienteService.listarClientes();
        }
        ArrayList<ClienteModel> listaClientes = clienteService.listarClientes();
        model.addAttribute("listaClientes", listaClientes);
        return "gestionClientes";
    }

    @PostMapping("/administracionC")
    public String agregarC(ClienteModel clienteDto, Model model) {
        if (clienteDto.getId() == null) {
            clienteService.insertarCliente(clienteDto);
        } else {
            clienteService.editarCliente(clienteDto);
        }
        ArrayList<ClienteModel> listaClientes = clienteService.listarClientes();
        model.addAttribute("listaClientes", listaClientes);
        return "gestionClientes";
    }
    
 //Servicios de gestión de proveedores
    
    @GetMapping("/gestionP")
    public String gestionProveedores(ProveedorModel proveedorDto, Model model) {
        if (proveedorDto.getId() != null) {
        	proveedorService.listarProveedores();
        }
        ArrayList<ProveedorModel> listaProveedores = proveedorService.listarProveedores();
        model.addAttribute("listaProveedores", listaProveedores);
        return "gestionProveedores";
    }

    @PostMapping("/administracionP")
    public String agregarP(ProveedorModel proveedorDto, Model model) {
        if (proveedorDto.getId() == null) {
            proveedorService.insertarProveedor(proveedorDto);
        } else {
            proveedorService.editarProveedor(proveedorDto);
        }
        ArrayList<ProveedorModel> listaProveedores = proveedorService.listarProveedores();
        model.addAttribute("listaProveedores", listaProveedores);
        return "gestionProveedores";
    }
    
//Zona de gestión CRUD2
    
  //Servicio para agregar usuario administrativo
    
    @GetMapping("/agregar/{id}")
    public String agregar(@PathVariable("id") Long id, Model model) {
        if (id != null && id != 0) {
            model.addAttribute("usuario", usuarioService.obtenerPorId(id));
        } else {
            model.addAttribute("usuario", new UsuarioModel());
        }
        return "agregar";
    }
    
    //Servicio para editar usuario administrativo

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        if (id != null && id != 0) {
            model.addAttribute("usuario", usuarioService.obtenerPorId(id));
        } else {
            model.addAttribute("usuario", new UsuarioModel());
        }
        return "edicion";
    }
    
    //Servicio para eliminar usuario administrativo

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, Model model) {
        usuarioService.eliminarUsuario(id);
        ArrayList<UsuarioModel> listaUsuarios = usuarioService.listarUsuarios();
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "gestionUsuarios";
    }
    
  //Servicio para agregar cliente
    
    @GetMapping("/agregarC/{id}")
    public String agregarC(@PathVariable("id") Long id, Model model) {
        if (id != null && id != 0) {
            model.addAttribute("cliente", clienteService.obtenerPorIdc(id));
        } else {
            model.addAttribute("cliente", new ClienteModel());
        }
        return "agregarC";
    }
    
  //Servicio para editar cliente

    @GetMapping("/editarC/{id}")
    public String editarC(@PathVariable("id") Long id, Model model) {
        if (id != null && id != 0) {
            model.addAttribute("cliente", clienteService.obtenerPorIdc(id));
        } else {
            model.addAttribute("cliente", new ClienteModel());
        }
        return "edicionC";
    }
    
  //Servicio para eliminar cliente

    @GetMapping("/eliminarC/{id}")
    public String eliminarC(@PathVariable Long id, Model model) {
        clienteService.eliminarCliente(id);
        ArrayList<ClienteModel> listaClientes = clienteService.listarClientes();
        model.addAttribute("listaClientes", listaClientes);
        return "gestionClientes";
    }
    
//Servicio para agregar proveedor
    
    @GetMapping("/agregarP/{id}")
    public String agregarP(@PathVariable("id") Long id, Model model) {
        if (id != null && id != 0) {
            model.addAttribute("proveedor", proveedorService.obtenerPorIdc(id));
        } else {
            model.addAttribute("proveedor", new ProveedorModel());
        }
        return "agregarP";
    }
    
  //Servicio para editar proveedor

    @GetMapping("/editarP/{id}")
    public String editarP(@PathVariable("id") Long id, Model model) {
        if (id != null && id != 0) {
            model.addAttribute("proveedor", proveedorService.obtenerPorIdc(id));
        } else {
            model.addAttribute("proveedor", new ProveedorModel());
        }
        return "edicionP";
    }
    
  //Servicio para eliminar proveedor

    @GetMapping("/eliminarP/{id}")
    public String eliminarP(@PathVariable Long id, Model model) {
        proveedorService.eliminarProveedor(id);
        ArrayList<ProveedorModel> listaProveedores = proveedorService.listarProveedores();
        model.addAttribute("listaProveedores", listaProveedores);
        return "gestionProveedores";
    }

}
