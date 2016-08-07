package co.edu.uniremington.gestorgrupos.dto;

import java.util.Date;

public class ProgramaDTO {
	private int codigo;
	private String nombre;
	private TipoProgramaDTO tipoPrograma;
	private Date fechaBaja;
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
	
	public TipoProgramaDTO getTipoPrograma() {
		return tipoPrograma;
	}

	public void setTipoPrograma(TipoProgramaDTO tipoPrograma) {
		this.tipoPrograma = tipoPrograma;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
