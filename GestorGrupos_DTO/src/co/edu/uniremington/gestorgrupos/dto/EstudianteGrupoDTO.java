package co.edu.uniremington.gestorgrupos.dto;

import java.util.Date;

public class EstudianteGrupoDTO {
	
	private int codigo;
	private EstudianteDTO estudiante;
	private String notaDefinitiva;
	private String estadoCurso;
	private Date fecha_baja;
	private String estado;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public EstudianteDTO getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(EstudianteDTO estudiante) {
		this.estudiante = estudiante;
	}
	public String getNotaDefinitiva() {
		return notaDefinitiva;
	}
	public void setNotaDefinitiva(String notaDefinitiva) {
		this.notaDefinitiva = notaDefinitiva;
	}
	public String getEstadoCurso() {
		return estadoCurso;
	}
	public void setEstadoCurso(String estadoCurso) {
		this.estadoCurso = estadoCurso;
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
