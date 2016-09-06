package co.edu.uniremington.gestorgrupos.fachada.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.NotaEstudianteGrupoDTO;
import co.edu.uniremington.gestorgrupos.fachada.contrato.INotaEstudianteGrupoFachada;
import co.edu.uniremington.gestorgrupos.negocio.contrato.INotaEstudianteGrupoNegocio;
import co.edu.uniremington.gestorgrupos.negocio.implementacion.NotaEstudianteGrupoNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class NotaEstudianteGrupoFachada implements INotaEstudianteGrupoFachada {

	@Override
	public void crear(NotaEstudianteGrupoDTO notaEstudianteGrupoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			INotaEstudianteGrupoNegocio notaEstudianteGrupoNegocio = new NotaEstudianteGrupoNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			notaEstudianteGrupoNegocio.crear(notaEstudianteGrupoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();
			String mensajeTecnico = "Se ha presentado un problema tratando de registrar la nota del estudiante del grupo con el nombre: " + notaEstudianteGrupoDTO.getEstudianteGrupo().getEstudiante().getPersona().getPrimerNombre() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! La nota del estudiante grupo  que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void modificar(NotaEstudianteGrupoDTO notaEstudianteGrupoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");
		
		try {
			INotaEstudianteGrupoNegocio notaEstudianteGrupoNegocio = new NotaEstudianteGrupoNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			notaEstudianteGrupoNegocio.modificar(notaEstudianteGrupoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de modificar la nota del estudiante del grupo con el nombre: " + notaEstudianteGrupoDTO.getEstudianteGrupo().getEstudiante().getPersona().getPrimerNombre() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! La nota del estudiante grupo  que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void cambiarFechaBaja(NotaEstudianteGrupoDTO notaEstudianteGrupoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			INotaEstudianteGrupoNegocio notaEstudianteGrupoNegocio = new NotaEstudianteGrupoNegocio(factoriaDAOs);
			
			factoriaDAOs.iniciarTransaccion();
			notaEstudianteGrupoNegocio.cambiarFechaBaja(notaEstudianteGrupoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar de fecha de baja de las notas de los estudiantes grupo con el codigo: " + notaEstudianteGrupoDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! Las notas de los estudiantes grupo  que intentas cambiar la fecha de baja con el nombre" + notaEstudianteGrupoDTO.getEstudianteGrupo().getEstudiante().getPersona().getPrimerNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public List<NotaEstudianteGrupoDTO> consultar(NotaEstudianteGrupoDTO NotaEstudianteGrupoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		List<NotaEstudianteGrupoDTO> listaRetorno = null;

		try {
			INotaEstudianteGrupoNegocio NotaEstudianteGrupoNegocio = new NotaEstudianteGrupoNegocio(factoriaDAOs);
			
			listaRetorno = NotaEstudianteGrupoNegocio.consultar(NotaEstudianteGrupoDTO);
			return NotaEstudianteGrupoNegocio.consultar(NotaEstudianteGrupoDTO);

		} catch (GestorGruposException exception) {
			throw exception;
		} catch (Exception e) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de las notas de los estudiantes grupo";
			String mensajeUsuario = "Upps!!! No hemos podido consultar la información de las notas de los estudiantes grupo. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}
		return null;
	}

}
