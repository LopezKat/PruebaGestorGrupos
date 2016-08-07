package co.edu.uniremington.gestorgrupos.dto;

public class PensumSemestre {
	
	private int codigo;
	private SemestreDTO semestre;
	private PensumDTO pensum;
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
	

}
