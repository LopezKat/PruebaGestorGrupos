package co.edu.uniremington.gestorgrupos.transversal.excepciones;

public class GestorGruposException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String capa;
	private Exception excepcionRaiz;
	private String mensajeTecnico;
	private String mensajeUsuario;
	private String nombreClase;
	private String metodo;

	private GestorGruposException(String capa, Exception excepcionRaiz, String mensajeTecnico, String mensajeUsuario, 
			String nombreClase, String metodo) {		
		this.capa=capa;
		this.excepcionRaiz=excepcionRaiz;
		this.mensajeTecnico=mensajeTecnico;
		this.mensajeUsuario=mensajeUsuario;
		this.nombreClase=nombreClase;
		this.metodo=metodo;
	}
	
	public static void crearExcepcion(String capa, Exception excepcionRaiz, String mensajeTecnico, String mensajeUsuario, 
			String nombreClase, String metodo){
		throw new GestorGruposException(capa, excepcionRaiz, mensajeTecnico, mensajeUsuario, nombreClase, metodo);
	}

	public String getcapa() {
		return capa;
	}

	public Exception getExcepcionRaiz() {
		return excepcionRaiz;
	}

	public String getMensajeTecnico() {
		return mensajeTecnico;
	}

	public String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public String getNombreClase() {
		return nombreClase;
	}

	public String getMetodo() {
		return metodo;
	}

}
