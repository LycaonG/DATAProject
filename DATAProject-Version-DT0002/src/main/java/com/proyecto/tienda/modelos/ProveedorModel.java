package com.proyecto.tienda.modelos;
import javax.persistence.*;



@Entity
@Table(name="proveedores", uniqueConstraints=@UniqueConstraint(columnNames={"nit","usuariop"}))
public class ProveedorModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String razonSocial;
	private String nit;
	private String correo;
	private String direccion;
	private String telefono;
	private String usuariop;
	private String passwordp;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
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
	public String getUsuariop() {
		return usuariop;
	}
	public void setUsuariop(String usuariop) {
		this.usuariop = usuariop;
	}
	public String getPasswordp() {
		return passwordp;
	}
	public void setPasswordp(String passwordp) {
		this.passwordp = passwordp;
	}
	
	

}
