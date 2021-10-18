package com.proyecto.tienda.modelos;
import javax.persistence.*;



@Entity
@Table(name="clientes")
public class ClienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreCompleto;
	private String cedula;
	private String correo;
	private String direccion;
	private String telefono;
	private String usuarioc;
	private String passwordc;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getUsuarioc() {
		return usuarioc;
	}
	public void setUsuarioc(String usuarioc) {
		this.usuarioc = usuarioc;
	}
	public String getPasswordc() {
		return passwordc;
	}
	public void setPasswordc(String passwordc) {
		this.passwordc = passwordc;
	}
	
	
	
	
}
