package co.edu.uniremington.gestorgrupos.fachada.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.ProfesorDTO;
import co.edu.uniremington.gestorgrupos.fachada.contrato.IProfesorFachada;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IProfesorNegocio;
import co.edu.uniremington.gestorgrupos.negocio.implementacion.ProfesorNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class ProfesorFachada implements IProfesorFachada {

	@Override
	public void crear(ProfesorDTO profesorDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IProfesorNegocio profesorNegocio = new ProfesorNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();

			profesorNegocio.crear(profesorDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();
			String mensajeTecnico = "Se ha presentado un problema tratando de registrar el profesor con el nombre: " + profesorDTO.getPersona().getPrimerNombre()+ "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El profesor  que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void modificar(ProfesorDTO profesorDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IProfesorNegocio profesorNegocio = new ProfesorNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			profesorNegocio.modificar(profesorDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de modificar el profesor con el codigo: " + profesorDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El profesor  que intentas actualizar con el nombre" + profesorDTO.getPersona().getPrimerNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void cambiarFechaBaja(ProfesorDTO profesorDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IProfesorNegocio profesorNegocio = new ProfesorNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();

			profesorNegocio.cambiarFechaBaja(profesorDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar la fecha de baja del profesor con el codigo: " + profesorDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El profesor que intentas cambiar la fecha de baja con el nombre" + profesorDTO.getPersona().getPrimerNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public List<ProfesorDTO> consultar(ProfesorDTO profesorDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		List<ProfesorDTO> listaRetorno = null;

		try {
			IProfesorNegocio profesorNegocio = new ProfesorNegocio(factoriaDAOs);

			
			listaRetorno = profesorNegocio.consultar(profesorDTO);
			return profesorNegocio.consultar(profesorDTO);

		} catch (GestorGruposException exception) {
			throw exception;
		} catch (Exception e) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de los profesores";
			String mensajeUsuario = "Upps!!! No hemos podido consultar la información de los profesores. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}
		return null;
	}

}
