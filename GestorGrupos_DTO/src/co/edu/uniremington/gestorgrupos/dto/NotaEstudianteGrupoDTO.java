package co.edu.uniremington.gestorgrupos.dto;

import java.util.Date;

public class NotaEstudianteGrupoDTO {

	private int codigo;
	private String nota;
	private Date fecha_registro;
	private NotaGrupoDTO notaGrupo;
	private EstudianteGrupoDTO estudianteGrupo;
	private Date fecha_baja;
	private String estado;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public NotaGrupoDTO getNotaGrupo() {
		return notaGrupo;
	}

	public void setNotaGrupo(NotaGrupoDTO notaGrupo) {
		this.notaGrupo = notaGrupo;
	}

	public EstudianteGrupoDTO getEstudianteGrupo() {
		return estudianteGrupo;
	}

	public void setEstudianteGrupo(EstudianteGrupoDTO estudianteGrupo) {
		this.estudianteGrupo = estudianteGrupo;
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
