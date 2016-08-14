package co.edu.uniremington.gestorgrupos.dto;

import java.util.Date;

public class NotaGrupoDTO {

	private int codigo;
	private String descripcion;
	private int porcentaje;
	private Date fecha_registro;
	private Date fecha_limite_registro;
	private TipoNotaDTO tipoNota;
	private GrupoDTO grupo;
	private Date fecha_baja;
	private String estado;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	public Date getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public Date getFecha_limite_registro() {
		return fecha_limite_registro;
	}
	public void setFecha_limite_registro(Date fecha_limite_registro) {
		this.fecha_limite_registro = fecha_limite_registro;
	}
	public TipoNotaDTO getTipoNota() {
		return tipoNota;
	}
	public void setTipoNota(TipoNotaDTO tipoNota) {
		this.tipoNota = tipoNota;
	}
	public GrupoDTO getGrupo() {
		return grupo;
	}
	public void setGrupo(GrupoDTO grupo) {
		this.grupo = grupo;
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
