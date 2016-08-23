package co.edu.uniremington.gestorgrupos.dto;

import java.util.Date;

public class ProgramaDTO {

	private int codigo;
	private String nombre;
	private TipoProgramaDTO tipoPrograma;
	private Date fecha_Baja;
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

	public Date getFecha_Baja() {
		return fecha_Baja;
	}

	public void setFecha_Baja(Date fecha_Baja) {
		this.fecha_Baja = fecha_Baja;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
