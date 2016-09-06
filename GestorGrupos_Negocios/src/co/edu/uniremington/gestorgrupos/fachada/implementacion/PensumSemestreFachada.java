package co.edu.uniremington.gestorgrupos.fachada.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.PensumSemestreDTO;
import co.edu.uniremington.gestorgrupos.fachada.contrato.IPensumSemestreFachada;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IPensumSemestreNegocio;
import co.edu.uniremington.gestorgrupos.negocio.implementacion.PensumSemestreNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class PensumSemestreFachada implements IPensumSemestreFachada {

	@Override
	public void crear(PensumSemestreDTO pensumSemestreDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IPensumSemestreNegocio pensumSemestreNegocio = new PensumSemestreNegocio(factoriaDAOs);

			factoriaDAOs.iniciarTransaccion();
			pensumSemestreNegocio.crear(pensumSemestreDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de registrar pensum Semestre con el nombre: " + pensumSemestreDTO.getPensum().getNombre() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El pensum semestre  que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void modificar(PensumSemestreDTO pensumSemestreDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IPensumSemestreNegocio pensumSemestreNegocio = new PensumSemestreNegocio(factoriaDAOs);

			factoriaDAOs.iniciarTransaccion();
			pensumSemestreNegocio.modificar(pensumSemestreDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de modificar pensum semestre con el codigo: " + pensumSemestreDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El pensum semestre  que intentas actualizar con el nombre" + pensumSemestreDTO.getPensum().getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void cambiarFechaBaja(PensumSemestreDTO pensumSemestreDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IPensumSemestreNegocio pensumSemestreNegocio = new PensumSemestreNegocio(factoriaDAOs);

			factoriaDAOs.iniciarTransaccion();
			pensumSemestreNegocio.cambiarFechaBaja(pensumSemestreDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar de fecha de baja Pensum Semestre con el codigo: " + pensumSemestreDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El Pensum Semestre  que intentas cambiar la fecha de baja con el nombre" + pensumSemestreDTO.getPensum().getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public List<PensumSemestreDTO> consultar(PensumSemestreDTO pensumSemestreDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		List<PensumSemestreDTO> listaRetorno = null;

		try {
			IPensumSemestreNegocio pensumSemestreNegocio = new PensumSemestreNegocio(factoriaDAOs);

			listaRetorno = pensumSemestreNegocio.consultar(pensumSemestreDTO);
			return pensumSemestreNegocio.consultar(pensumSemestreDTO);

		} catch (GestorGruposException exception) {
			throw exception;
		} catch (Exception e) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de los Pensum Semestre";
			String mensajeUsuario = "Upps!!! No hemos podido consultar la información de los Pensum Semestre. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}
		return null;
	}

}
