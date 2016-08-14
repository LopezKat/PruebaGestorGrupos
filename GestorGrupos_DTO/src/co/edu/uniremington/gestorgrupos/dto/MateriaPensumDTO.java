package co.edu.uniremington.gestorgrupos.dto;

import java.util.Date;

public class MateriaPensumDTO {

	private int codigo;
	private int numeroCreditos;
	private PensumSemestreDTO pensumSemestre;
	private MateriaDTO materia;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNumeroCreditos() {
		return numeroCreditos;
	}

	public void setNumeroCreditos(int numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}

	public PensumSemestreDTO getPensumSemestre() {
		return pensumSemestre;
	}

	public void setPensumSemestre(PensumSemestreDTO pensumSemestre) {
		this.pensumSemestre = pensumSemestre;
	}

	public MateriaDTO getMateria() {
		return materia;
	}

	public void setMateria(MateriaDTO materia) {
		this.materia = materia;
	}

}
