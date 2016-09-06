package co.edu.uniremington.gestorgrupos.fachada.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.ProgramaDTO;
import co.edu.uniremington.gestorgrupos.fachada.contrato.IProgramaFachada;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IProgramaNegocio;
import co.edu.uniremington.gestorgrupos.negocio.implementacion.ProgramaNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class ProgramaFachada implements IProgramaFachada {

	@Override
	public void crear(ProgramaDTO programaDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IProgramaNegocio programaNegocio = new ProgramaNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			programaNegocio.crear(programaDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de registrar el programa con el nombre: " + programaDTO.getNombre() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El programa  que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void modificar(ProgramaDTO programaDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");;

		try {
			IProgramaNegocio programaNegocio = new ProgramaNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();

			programaNegocio.modificar(programaDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de modificar el programa con el codigo: " + programaDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El programa  que intentas actualizar con el nombre" + programaDTO.getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void cambiarFechaBaja(ProgramaDTO programaDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IProgramaNegocio programaNegocio = new ProgramaNegocio(factoriaDAOs);

			factoriaDAOs.iniciarTransaccion();
			programaNegocio.cambiarFechaBaja(programaDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar de fecha de baja de programa con el codigo: " + programaDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El programa  que intentas cambiar la fecha de baja con el nombre" + programaDTO.getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public List<ProgramaDTO> consultar(ProgramaDTO programaDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		List<ProgramaDTO> listaRetorno = null;

		try {
			IProgramaNegocio programaNegocio = new ProgramaNegocio(factoriaDAOs);

			
			listaRetorno = programaNegocio.consultar(programaDTO);
			return programaNegocio.consultar(programaDTO);

		} catch (GestorGruposException exception) {
			throw exception;
		} catch (Exception e) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de los programa";
			String mensajeUsuario = "Upps!!! No hemos podido consultar la información de los de programa. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}
		return null;
	}

}
