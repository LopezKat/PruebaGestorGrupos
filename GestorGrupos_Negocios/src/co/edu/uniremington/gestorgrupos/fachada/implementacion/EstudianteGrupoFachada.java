package co.edu.uniremington.gestorgrupos.fachada.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.EstudianteGrupoDTO;
import co.edu.uniremington.gestorgrupos.fachada.contrato.IEstudianteGrupoFachada;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IEstudianteGrupoNegocio;
import co.edu.uniremington.gestorgrupos.negocio.implementacion.EstudianteGrupoNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class EstudianteGrupoFachada implements IEstudianteGrupoFachada {

	@Override
	public void crear(EstudianteGrupoDTO estudianteGrupoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IEstudianteGrupoNegocio estudianteGrupoNegocio = new EstudianteGrupoNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();

			estudianteGrupoNegocio.crear(estudianteGrupoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();
			// TODO FALTA CAMBIAR NOMBRE DE MENSAJES
			String mensajeTecnico = "Se ha presentado un problema tratando de registrar estudiante grupo con el nombre:"+estudianteGrupoDTO.getEstudiante().getPersona().getPrimerNombre()+"debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El estudiante grupo que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void modificar(EstudianteGrupoDTO estudianteGrupoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IEstudianteGrupoNegocio estudianteGrupoNegocio = new EstudianteGrupoNegocio(factoriaDAOs);

			factoriaDAOs.iniciarTransaccion();

			estudianteGrupoNegocio.modificar(estudianteGrupoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar la fecha de baja estudiantes de grupo con el codigo: " + estudianteGrupoDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El estudiante grupo que intentas cambiar la fecha de baja con el nombre. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void cambiarFechaBaja(EstudianteGrupoDTO estudianteGrupoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IEstudianteGrupoNegocio estudianteGrupoNegocio = new EstudianteGrupoNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();

			estudianteGrupoNegocio.cambiarFechaBaja(estudianteGrupoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar la fecha de baja estudiantes de grupo con el codigo: " + estudianteGrupoDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El estudiante grupo que intentas cambiar la fecha de baja con el nombre. Por favor intentelo de nuevo";
			 //TODO Verificar el nombre de esta clase

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public List<EstudianteGrupoDTO> consultar(EstudianteGrupoDTO estudianteGrupoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		List<EstudianteGrupoDTO> listaRetorno = null;

		try {
			IEstudianteGrupoNegocio estudianteGrupoNegocio = new EstudianteGrupoNegocio(factoriaDAOs);

			listaRetorno = estudianteGrupoNegocio.consultar(estudianteGrupoDTO);
			return estudianteGrupoNegocio.consultar(estudianteGrupoDTO);

		} catch (GestorGruposException exception) {
			throw exception;
		} catch (Exception e) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de los estudiantes grupos";
			String mensajeUsuario = "Upps!!! No hemos podido consultar la información de los estudiantes grupos. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}
		return null;
	}

}
