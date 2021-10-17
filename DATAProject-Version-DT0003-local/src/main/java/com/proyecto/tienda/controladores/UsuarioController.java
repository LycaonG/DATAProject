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
import com.proyecto.tienda.modelos.ComprasModel;
import com.proyecto.tienda.modelos.ProductoModel;
import com.proyecto.tienda.modelos.ProveedorModel;
import com.proyecto.tienda.modelos.UsuarioModel;
import com.proyecto.tienda.modelos.VentasModel;
import com.proyecto.tienda.servicios.ClienteService;
import com.proyecto.tienda.servicios.ComprasService;
import com.proyecto.tienda.servicios.ProductoService;
import com.proyecto.tienda.servicios.ProveedorService;
import com.proyecto.tienda.servicios.UsuarioService;
import com.proyecto.tienda.servicios.VentasService;

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
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private ComprasService comprasService;
    
    @Autowired
    private VentasService ventasService;
    
//Login inicial
    
   @GetMapping("/login")
   //@GetMapping({ "/login", "/" }) //Servicio para iniciar desde el login
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
        return "redirect:/login";
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
    
    //Validación de la busqueda de producto
    
    @PostMapping("/validarBProd")
    public String validarBProd(@RequestParam(value = "codigo", required = true) Long codigo, Model model){
        Optional<ProductoModel> productoB = productoService.buscarprod(codigo);
        if (productoB.isPresent()) {
            model.addAttribute("productoB", productoB.get());
           
            return "productoB";
        }
        return "Home";
    }
    
    //Validación de la busqueda de compra
    
    @PostMapping("/validarBCompra")
    public String validarBCompra(@RequestParam(value = "N_cuentadecobro", required = true) Long N_cuentadecobro, Model model){
        Optional<ComprasModel> compraB = comprasService.buscarcompra(N_cuentadecobro);
        if (compraB.isPresent()) {
            model.addAttribute("compraB", compraB.get());
           
            return "compraB";
        }
        return "Home";
    }
    
    //Validación de la busqueda de venta
    
    @PostMapping("/validarBVenta")
    public String validarBVenta(@RequestParam(value = "N_factura", required = true) Long N_factura, Model model){
        Optional<VentasModel> ventaB = ventasService.buscarventa(N_factura);
        if (ventaB.isPresent()) {
            model.addAttribute("ventaB", ventaB.get());
           
            return "ventaB";
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
    
    //Servicio buscar producto
    
    @GetMapping("/buscarProd")
    public String buscarProd(Model model) {

        return "buscarProd";
    }
    
    //Servicio buscar compra
    
    @GetMapping("/buscarcompra")
    public String buscarcompra(Model model) {

        return "buscarCompra";
    }
    
    //Servicio buscar venta
    
    @GetMapping("/buscarventa")
    public String buscarventa(Model model) {

        return "buscarVenta";
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
    
//Servicio de listado de productos
    
    @GetMapping("/listarProductos")
    public String listarProductos(ProductoModel productoDto, Model model) {
        if (productoDto.getCodigo() != null) {
        	productoService.listarProductos();
        }
        ArrayList<ProductoModel> listaProductos = productoService.listarProductos();
        model.addAttribute("listaProductos", listaProductos);
        return "productosLista";
    }
    
//Servicio de listado de compras
    
    @GetMapping("/listarCompras")
    public String listarCompras(ComprasModel comprasDto, Model model) {
        if (comprasDto.getN_cuentadecobro() != null) {
        	comprasService.listarCompras();
        }
        ArrayList<ComprasModel> listaCompras = comprasService.listarCompras();
        model.addAttribute("listaCompras", listaCompras);
        return "comprasLista";
    }
    
//Servicio de listado de ventas
    
    @GetMapping("/listarVentas")
    public String listarVentas(VentasModel ventasDto, Model model) {
        if (ventasDto.getN_factura() != null) {
        	ventasService.listarVentas();
        }
        ArrayList<VentasModel> listaVentas = ventasService.listarVentas();
        model.addAttribute("listaVentas", listaVentas);
        return "ventasLista";
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
    
//Servicios de gestión de productos
    
    @GetMapping("/gestionProd")
    public String gestionProductos(ProductoModel productoDto, Model model) {
        if (productoDto.getCodigo() != null) {
        	productoService.listarProductos();
        }
        ArrayList<ProductoModel> listaProductos = productoService.listarProductos();
        model.addAttribute("listaProductos", listaProductos);
        return "gestionProductos";
    }

    @PostMapping("/administracionProd")
    public String agregarProd(ProductoModel productoDto, Model model) {
        if (productoDto.getCodigo() == null) {
            productoService.insertarProducto(productoDto);
        } else {
            productoService.editarProducto(productoDto);
        }
        ArrayList<ProductoModel> listaProductos = productoService.listarProductos();
        model.addAttribute("listaProductos", listaProductos);
        return "gestionProductos";
    }
    
//Servicios de gestión de compras
    
    @GetMapping("/gestionCompras")
    public String gestionCompras(ComprasModel comprasDto, Model model) {
        if (comprasDto.getN_cuentadecobro() != null) {
        	comprasService.listarCompras();
        }
        ArrayList<ComprasModel> listaCompras = comprasService.listarCompras();
        model.addAttribute("listaCompras", listaCompras);
        return "gestionCompras";
    }

    @PostMapping("/administracionCompras")
    public String agregarCompra(ComprasModel compraDto, Model model) {
        if (compraDto.getN_cuentadecobro() == null) {
            comprasService.insertarCompra(compraDto);
        } else {
            comprasService.editarCompra(compraDto);
        }
        ArrayList<ComprasModel> listaCompras = comprasService.listarCompras();
        model.addAttribute("listaCompras", listaCompras);
        return "gestionCompras";
    }
    
//Servicios de gestión de ventas
    
    @GetMapping("/gestionVentas")
    public String gestionVentas(VentasModel ventasDto, Model model) {
        if (ventasDto.getN_factura() != null) {
        	ventasService.listarVentas();
        }
        ArrayList<VentasModel> listaVentas = ventasService.listarVentas();
        model.addAttribute("listaVentas", listaVentas);
        return "gestionVentas";
    }

    @PostMapping("/administracionVentas")
    public String agregarVenta(VentasModel ventaDto, Model model) {
        if (ventaDto.getN_factura() == null) {
            ventasService.insertarVenta(ventaDto);
        } else {
            ventasService.editarVenta(ventaDto);
        }
        ArrayList<VentasModel> listaVentas = ventasService.listarVentas();
        model.addAttribute("listaVentas", listaVentas);
        return "gestionVentas";
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
    
//Servicio para agregar producto
    
    @GetMapping("/agregarProd/{codigo}")
    public String agregarProd(@PathVariable("codigo") Long codigo, Model model) {
        if (codigo != null && codigo != 0) {
            model.addAttribute("producto", productoService.obtenerPorIdc(codigo));
        } else {
            model.addAttribute("producto", new ProductoModel());
        }
        return "agregarProd";
    }
    
  //Servicio para editar producto

    @GetMapping("/editarProd/{codigo}")
    public String editarProd(@PathVariable("codigo") Long codigo, Model model) {
        if (codigo != null && codigo != 0) {
            model.addAttribute("producto", productoService.obtenerPorIdc(codigo));
        } else {
            model.addAttribute("producto", new ProductoModel());
        }
        return "edicionProd";
    }
    
  //Servicio para eliminar producto

    @GetMapping("/eliminarProd/{codigo}")
    public String eliminarProd(@PathVariable Long codigo, Model model) {
        productoService.eliminarProducto(codigo);
        ArrayList<ProductoModel> listaProductos = productoService.listarProductos();
        model.addAttribute("listaProductos", listaProductos);
        return "gestionProductos";
    }   
    
    
//Servicio para agregar compra
    
    @GetMapping("/agregarCompra/{N_cuentadecobro}")
    public String agregarCompra(@PathVariable("N_cuentadecobro") Long N_cuentadecobro, Model model) {
        if (N_cuentadecobro != null && N_cuentadecobro != 0) {
            model.addAttribute("compra", comprasService.obtenerPorIdc(N_cuentadecobro));
        } else {
            model.addAttribute("compra", new ComprasModel());
        }
        return "agregarCompra";
    }
    
  //Servicio para editar compra

    @GetMapping("/editarCompra/{N_cuentadecobro}")
    public String editarCompra(@PathVariable("N_cuentadecobro") Long N_cuentadecobro, Model model) {
        if (N_cuentadecobro != null && N_cuentadecobro != 0) {
            model.addAttribute("compra", comprasService.obtenerPorIdc(N_cuentadecobro));
        } else {
            model.addAttribute("compra", new ComprasModel());
        }
        return "edicionCompra";
    }
    
//Servicio para agregar venta
    
    @GetMapping("/agregarVenta/{N_factura}")
    public String agregarVenta(@PathVariable("N_factura") Long N_factura, Model model) {
        if (N_factura != null && N_factura != 0) {
            model.addAttribute("venta", ventasService.obtenerPorIdc(N_factura));
        } else {
            model.addAttribute("venta", new VentasModel());
        }
        return "agregarVenta";
    }
    
  //Servicio para editar venta

    @GetMapping("/editarVenta/{N_factura}")
    public String editarVenta(@PathVariable("N_factura") Long N_factura, Model model) {
        if (N_factura != null && N_factura != 0) {
            model.addAttribute("venta", ventasService.obtenerPorIdc(N_factura));
        } else {
            model.addAttribute("venta", new VentasModel());
        }
        return "edicionVenta";
    }

}
