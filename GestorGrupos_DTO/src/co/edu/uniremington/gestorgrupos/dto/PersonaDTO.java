package co.edu.uniremington.gestorgrupos.dto;

public class PersonaDTO {
	
	private int codigo;
	private TipoIdentificacionDTO tipodeIdentificacion;
	private String PrimerNombre;
	private String SegundoNomre;
	private String PrimerApellido;
	private String SegundoApellido;
	private GeneroDTO genero;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public TipoIdentificacionDTO getTipodeIdentificacion() {
		return tipodeIdentificacion;
	}
	public void setTipodeIdentificacion(TipoIdentificacionDTO tipodeIdentificacion) {
		this.tipodeIdentificacion = tipodeIdentificacion;
	}
	public String getPrimerNombre() {
		return PrimerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		PrimerNombre = primerNombre;
	}
	public String getSegundoNomre() {
		return SegundoNomre;
	}
	public void setSegundoNomre(String segundoNomre) {
		SegundoNomre = segundoNomre;
	}
	public String getPrimerApellido() {
		return PrimerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		PrimerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return SegundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		SegundoApellido = segundoApellido;
	}
	public GeneroDTO getGenero() {
		return genero;
	}
	public void setGenero(GeneroDTO genero) {
		this.genero = genero;
	}

	
	
}
