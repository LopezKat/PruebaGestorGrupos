package co.edu.uniremington.gestorgrupos.dto;

public class SemestreDTO {

	private int codigo;
	private String nombre;
	private TipoProgramaDTO tipoPrograma;
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
	public TipoProgramaDTO getTipoPrograma() {
		return tipoPrograma;
	}
	public void setTipoPrograma(TipoProgramaDTO tipoPrograma) {
		this.tipoPrograma = tipoPrograma;
	}
	
	
}
