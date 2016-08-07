package co.edu.uniremington.gestorgrupos.dto;

public class PensumDTO {
	
	private int codigo;
	private String nombre;
	private ProgramaDTO programa;
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
	public ProgramaDTO getPrograma() {
		return programa;
	}
	public void setPrograma(ProgramaDTO programa) {
		this.programa = programa;
	}
	
	

}
