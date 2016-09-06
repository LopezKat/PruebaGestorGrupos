package co.edu.uniremington.gestorgrupos.fachada.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.GrupoDTO;
import co.edu.uniremington.gestorgrupos.fachada.contrato.IGrupoFachada;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IGrupoNegocio;
import co.edu.uniremington.gestorgrupos.negocio.implementacion.GrupoNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class GrupoFachada implements IGrupoFachada {

	@Override
	public void crear(GrupoDTO grupoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IGrupoNegocio grupoNegocio = new GrupoNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();

			grupoNegocio.crear(grupoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de registrar grupo con el código: " + grupoDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El grupo  que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void modificar(GrupoDTO grupoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IGrupoNegocio GrupoNegocio = new GrupoNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();

			GrupoNegocio.modificar(grupoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de modificar grupo con el codigo: " + grupoDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El grupo  que intentas actualizar con el código" + grupoDTO.getCodigo() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void cambiarFechaBaja(GrupoDTO grupoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IGrupoNegocio grupoNegocio = new GrupoNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();

			grupoNegocio.cambiarFechaBaja(grupoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar de fecha de baja grupo con el codigo: " + grupoDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El grupo  que intentas cambiar la fecha de baja con el nombre" + grupoDTO.getCodigo() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public List<GrupoDTO> consultar(GrupoDTO grupoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		List<GrupoDTO> listaRetorno = null;

		try {
			IGrupoNegocio grupoNegocio = new GrupoNegocio(factoriaDAOs);

			
			listaRetorno = grupoNegocio.consultar(grupoDTO);
			return grupoNegocio.consultar(grupoDTO);

		} catch (GestorGruposException exception) {
			throw exception;
		} catch (Exception e) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de los grupos";
			String mensajeUsuario = "Upps!!! No hemos podido consultar la información de los grupos. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}
		return null;
	}

}
