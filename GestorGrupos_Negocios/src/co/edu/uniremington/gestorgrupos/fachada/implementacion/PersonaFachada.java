package co.edu.uniremington.gestorgrupos.fachada.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.PersonaDTO;
import co.edu.uniremington.gestorgrupos.fachada.contrato.IPersonaFachada;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IPersonaNegocio;
import co.edu.uniremington.gestorgrupos.negocio.implementacion.PersonaNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class PersonaFachada implements IPersonaFachada {

	@Override
	public void crear(PersonaDTO personaDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IPersonaNegocio personaNegocio = new PersonaNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			personaNegocio.crear(personaDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de registrar la persona con el nombre: " + personaDTO.getPrimerNombre()+ "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! La persona que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void modificar(PersonaDTO personaDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IPersonaNegocio personaNegocio = new PersonaNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			personaNegocio.modificar(personaDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de modificar la persona con el codigo: " + personaDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! La persona que intentas actualizar con el nombre" + personaDTO.getPrimerNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void cambiarFechaBaja(PersonaDTO personaDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IPersonaNegocio personaNegocio = new PersonaNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			personaNegocio.cambiarFechaBaja(personaDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar de fecha de baja a la persona con el codigo: " + personaDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! La persona que intentas cambiar la fecha de baja con el nombre" + personaDTO.getPrimerNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public List<PersonaDTO> consultar(PersonaDTO personaDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		List<PersonaDTO> listaRetorno = null;

		try {
			IPersonaNegocio personaNegocio = new PersonaNegocio(factoriaDAOs);

			
			listaRetorno = personaNegocio.consultar(personaDTO);
			return personaNegocio.consultar(personaDTO);

		} catch (GestorGruposException exception) {
			throw exception;
		} catch (Exception e) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de las personas";
			String mensajeUsuario = "Upps!!! No hemos podido consultar la información de las personas. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}
		return null;
	}

}
