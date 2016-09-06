package co.edu.uniremington.gestorgrupos.fachada.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.PensumDTO;
import co.edu.uniremington.gestorgrupos.fachada.contrato.IPensumFachada;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IPensumNegocio;
import co.edu.uniremington.gestorgrupos.negocio.implementacion.PensumNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class PensumFachada implements IPensumFachada {

	@Override
	public void crear(PensumDTO pensumDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IPensumNegocio pensumNegocio = new PensumNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			pensumNegocio.crear(pensumDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de registrar el pensum con el nombre: " + pensumDTO.getNombre() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El pensum  que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void modificar(PensumDTO pensumDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IPensumNegocio pensumNegocio = new PensumNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			pensumNegocio.modificar(pensumDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de modificar el pensum con el codigo: " + pensumDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El pensum que intentas actualizar con el nombre" + pensumDTO.getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void cambiarFechaBaja(PensumDTO pensumDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IPensumNegocio pensumNegocio = new PensumNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			pensumNegocio.cambiarFechaBaja(pensumDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar de fecha de baja pensum con el codigo: " + pensumDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El pensum  que intentas cambiar la fecha de baja con el nombre" + pensumDTO.getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public List<PensumDTO> consultar(PensumDTO pensumDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		List<PensumDTO> listaRetorno = null;

		try {
			IPensumNegocio pensumNegocio = new PensumNegocio(factoriaDAOs);

			
			listaRetorno = pensumNegocio.consultar(pensumDTO);
			return pensumNegocio.consultar(pensumDTO);

		} catch (GestorGruposException exception) {
			throw exception;
		} catch (Exception e) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de los pensum";
			String mensajeUsuario = "Upps!!! No hemos podido consultar la información de los pensum. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}
		return null;
	}

}
