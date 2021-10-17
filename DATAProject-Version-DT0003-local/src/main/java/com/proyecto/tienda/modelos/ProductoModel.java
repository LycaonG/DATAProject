package com.proyecto.tienda.modelos;
import javax.persistence.*;

@Entity
@Table(name="productos")
public class ProductoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String producto;
	private String vUnitario;
	private String cantidad;
	private String razonSocial;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getvUnitario() {
		return vUnitario;
	}
	public void setvUnitario(String vUnitario) {
		this.vUnitario = vUnitario;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

}
