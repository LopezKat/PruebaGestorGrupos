package co.edu.uniremington.gestorgrupos.dto;

import java.util.Date;

public class PeriodoAcademicoDTO {

	private int codigo;
	private Date fecha_inicio;
	private Date fecha_fin;
	private Date fecha_baja;
	private String estado;
	private TipoPeriodoAcademicoDTO tipoPeriodoAcademico;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
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

	public TipoPeriodoAcademicoDTO getTipoPeriodoAcademico() {
		return tipoPeriodoAcademico;
	}

	public void setTipoPeriodoAcademico(TipoPeriodoAcademicoDTO tipoPeriodoAcademico) {
		this.tipoPeriodoAcademico = tipoPeriodoAcademico;
	}

}
