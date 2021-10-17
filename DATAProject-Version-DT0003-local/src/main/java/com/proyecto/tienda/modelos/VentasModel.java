package com.proyecto.tienda.modelos;
import javax.persistence.*;


@Entity
@Table(name="ventas")
public class VentasModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long N_factura;
	private String fechaVenta;
	private String nombreCompleto;
	private String cedula;
	private String correo;
	private String direccion;
	private String telefono;
	private String producto;
	private String cantidadv;
	private String vUnitario;
	private String impuesto;
	private String vTotalv;
	private String estadov;
	
	
	public Long getN_factura() {
		return N_factura;
	}
	public void setN_factura(Long n_factura) {
		N_factura = n_factura;
	}
	public String getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getCantidadv() {
		return cantidadv;
	}
	public void setCantidadv(String cantidadv) {
		this.cantidadv = cantidadv;
	}
	public String getvUnitario() {
		return vUnitario;
	}
	public void setvUnitario(String vUnitario) {
		this.vUnitario = vUnitario;
	}
	public String getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}
	public String getvTotalv() {
		return vTotalv;
	}
	public void setvTotalv(String vTotalv) {
		this.vTotalv = vTotalv;
	}
	public String getEstadov() {
		return estadov;
	}
	public void setEstadov(String estadov) {
		this.estadov = estadov;
	}
	
	
}
