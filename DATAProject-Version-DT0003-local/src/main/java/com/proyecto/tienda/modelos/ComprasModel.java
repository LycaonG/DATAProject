package com.proyecto.tienda.modelos;
import javax.persistence.*;


@Entity
@Table(name="compras")
public class ComprasModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long N_cuentadecobro;
	private String fechaCompra;
	private String producto;
	private String razonSocial;
	private String nit;
	private String vUnitario;
	private String cantidadc;
	private String vTotal;
	private String estado;
	
	
	public Long getN_cuentadecobro() {
		return N_cuentadecobro;
	}
	public void setN_cuentadecobro(Long n_cuentadecobro) {
		N_cuentadecobro = n_cuentadecobro;
	}
	public String getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
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
	public String getvUnitario() {
		return vUnitario;
	}
	public void setvUnitario(String vUnitario) {
		this.vUnitario = vUnitario;
	}
	public String getCantidadc() {
		return cantidadc;
	}
	public void setCantidadc(String cantidadc) {
		this.cantidadc = cantidadc;
	}
	public String getvTotal() {
		return vTotal;
	}
	public void setvTotal(String vTotal) {
		this.vTotal = vTotal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
