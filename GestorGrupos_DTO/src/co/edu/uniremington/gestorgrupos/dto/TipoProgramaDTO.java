package co.edu.uniremington.gestorgrupos.dto;

import java.util.Date;

public class TipoProgramaDTO {
	private int codigo;
	private String nombre;

	// Agregar estos dos campos en todas las clases y aplicar el GET y el SET;
	// ademas hacer la tabla Grupos
	private Date fecha_baja;
	private String estado;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
