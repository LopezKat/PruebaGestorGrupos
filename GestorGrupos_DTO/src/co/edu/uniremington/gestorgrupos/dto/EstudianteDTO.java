package co.edu.uniremington.gestorgrupos.dto;

import java.util.Date;

public class EstudianteDTO {
	
	private int codigo;
	private PersonaDTO persona;
	private Date fecha_baja;
	private String estado;
	private PensumDTO pensum;
		
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public PersonaDTO getPersona() {
		return persona;
	}
	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
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
	public PensumDTO getPensum() {
		return pensum;
	}
	public void setPensum(PensumDTO pensum) {
		this.pensum = pensum;
	}
}
