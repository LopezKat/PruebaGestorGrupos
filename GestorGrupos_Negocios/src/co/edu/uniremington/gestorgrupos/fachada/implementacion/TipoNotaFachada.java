package co.edu.uniremington.gestorgrupos.fachada.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.TipoNotaDTO;
import co.edu.uniremington.gestorgrupos.fachada.contrato.ITipoNotaFachada;
import co.edu.uniremington.gestorgrupos.negocio.contrato.ITipoNotaNegocio;
import co.edu.uniremington.gestorgrupos.negocio.implementacion.TipoNotaNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class TipoNotaFachada implements ITipoNotaFachada {

	@Override
	public void crear(TipoNotaDTO tipoNotaDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			ITipoNotaNegocio tipoNotaNegocio = new TipoNotaNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();

			tipoNotaNegocio.crear(tipoNotaDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de registrar tipo de nota con el nombre: " + tipoNotaDTO.getNombre() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El tipo de nota  que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void modificar(TipoNotaDTO tipoNotaDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			ITipoNotaNegocio tipoNotaNegocio = new TipoNotaNegocio(factoriaDAOs);

			factoriaDAOs.iniciarTransaccion();
			tipoNotaNegocio.modificar(tipoNotaDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de modificar tipo de nota con el codigo: " + tipoNotaDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El tipo de nota  que intentas actualizar con el nombre" + tipoNotaDTO.getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void cambiarFechaBaja(TipoNotaDTO tipoNotaDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			ITipoNotaNegocio tipoNotaNegocio = new TipoNotaNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			tipoNotaNegocio.cambiarFechaBaja(tipoNotaDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar de fecha de baja tipo de nota con el codigo: " + tipoNotaDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El tipo de nota  que intentas cambiar la fecha de baja con el nombre" + tipoNotaDTO.getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public List<TipoNotaDTO> consultar(TipoNotaDTO tipoNotaDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		List<TipoNotaDTO> listaRetorno = null;

		try {
			ITipoNotaNegocio tipoNotaNegocio = new TipoNotaNegocio(factoriaDAOs);

			
			listaRetorno = tipoNotaNegocio.consultar(tipoNotaDTO);
			return tipoNotaNegocio.consultar(tipoNotaDTO);

		} catch (GestorGruposException exception) {
			throw exception;
		} catch (Exception e) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de los tipos nota";
			String mensajeUsuario = "Upps!!! No hemos podido consultar la información de los tipos de nota. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}
		return null;
	}

}
