package co.edu.uniremington.gestorgrupos.dto;

import java.util.Date;

public class PensumSemestreDTO {

	private int codigo;
	private SemestreDTO semestre;
	private PensumDTO pensum;
	private Date fecha_baja;
	private String estado;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public SemestreDTO getSemestre() {
		return semestre;
	}

	public void setSemestre(SemestreDTO semestre) {
		this.semestre = semestre;
	}

	public PensumDTO getPensum() {
		return pensum;
	}

	public void setPensum(PensumDTO pensum) {
		this.pensum = pensum;
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
