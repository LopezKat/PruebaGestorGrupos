package co.edu.uniremington.gestorgrupos.fachada.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.EstudianteDTO;
import co.edu.uniremington.gestorgrupos.fachada.contrato.IEstudianteFachada;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IEstudianteNegocio;
import co.edu.uniremington.gestorgrupos.negocio.implementacion.EstudianteNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class EstudianteFachada implements IEstudianteFachada {

	@Override
	public void crear(EstudianteDTO estudianteDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");
		
		try {
			IEstudianteNegocio estudianteNegocio = new EstudianteNegocio(factoriaDAOs);

			factoriaDAOs.iniciarTransaccion();
			estudianteNegocio.crear(estudianteDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();
			// TODO FALTA CAMBIAR NOMBRE DE MENSAJES
			String mensajeTecnico = "Se ha presentado un problema tratando de registrar el estudiante con el nombre: " + estudianteDTO.getPersona().getPrimerNombre()+ "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El estudiante  que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void modificar(EstudianteDTO estudianteDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IEstudianteNegocio estudianteNegocio = new EstudianteNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();

			estudianteNegocio.modificar(estudianteDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de modificar el estudiante con el codigo: " + estudianteDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El estudiante  que intentas actualizar con el nombre" + estudianteDTO.getPersona().getPrimerNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void cambiarFechaBaja(EstudianteDTO estudianteDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IEstudianteNegocio estudianteNegocio = new EstudianteNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();

			estudianteNegocio.cambiarFechaBaja(estudianteDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar de fecha de baja el estudiante con el código: " + estudianteDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El estudiante  que intentas cambiar la fecha de baja con el nombre" + estudianteDTO.getPersona().getPrimerNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public List<EstudianteDTO> consultar(EstudianteDTO estudianteDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		List<EstudianteDTO> listaRetorno = null;

		try {
			IEstudianteNegocio estudianteNegocio = new EstudianteNegocio(factoriaDAOs);

			listaRetorno = estudianteNegocio.consultar(estudianteDTO);
			return estudianteNegocio.consultar(estudianteDTO);

		} catch (GestorGruposException exception) {
			throw exception;
		} catch (Exception e) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de los estudiantes";
			String mensajeUsuario = "Upps!!! No hemos podido consultar la información de los estudiantes. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}
		return null;
	}

}
