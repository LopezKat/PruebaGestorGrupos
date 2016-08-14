package co.edu.uniremington.gestorgrupos.dto;

import java.util.Date;

public class GrupoDTO {

	private int codigo;
	private Date hora_inicio;
	private Date hora_fin;
	private int cantidad_minima;
	private int cantidad_maxima;
	private Date fecha_baja;
	private int cupos_disponibles;
	private int porcentaje_programado;
	private String estado;
	private MateriaPensumDTO materiaPensum;
	private ProfesorDTO profesor;
	private DiaDTO dia;
	private PeriodoAcademicoDTO periodoAcademico;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(Date hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public Date getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(Date hora_fin) {
		this.hora_fin = hora_fin;
	}

	public int getCantidad_minima() {
		return cantidad_minima;
	}

	public void setCantidad_minima(int cantidad_minima) {
		this.cantidad_minima = cantidad_minima;
	}

	public int getCantidad_maxima() {
		return cantidad_maxima;
	}

	public void setCantidad_maxima(int cantidad_maxima) {
		this.cantidad_maxima = cantidad_maxima;
	}

	public Date getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public int getCupos_disponibles() {
		return cupos_disponibles;
	}

	public void setCupos_disponibles(int cupos_disponibles) {
		this.cupos_disponibles = cupos_disponibles;
	}

	public int getPorcentaje_programado() {
		return porcentaje_programado;
	}

	public void setPorcentaje_programado(int porcentaje_programado) {
		this.porcentaje_programado = porcentaje_programado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public MateriaPensumDTO getMateriaPensum() {
		return materiaPensum;
	}

	public void setMateriaPensum(MateriaPensumDTO materiaPensum) {
		this.materiaPensum = materiaPensum;
	}

	public ProfesorDTO getProfesor() {
		return profesor;
	}

	public void setProfesor(ProfesorDTO profesor) {
		this.profesor = profesor;
	}

	public DiaDTO getDia() {
		return dia;
	}

	public void setDia(DiaDTO dia) {
		this.dia = dia;
	}

	public PeriodoAcademicoDTO getPeriodoAcademico() {
		return periodoAcademico;
	}

	public void setPeriodoAcademico(PeriodoAcademicoDTO periodoAcademico) {
		this.periodoAcademico = periodoAcademico;
	}

}
