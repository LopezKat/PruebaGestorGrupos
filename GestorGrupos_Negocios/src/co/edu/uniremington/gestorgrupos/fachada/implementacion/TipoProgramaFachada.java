package co.edu.uniremington.gestorgrupos.fachada.implementacion;

import java.net.FileNameMap;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.TipoProgramaDTO;
import co.edu.uniremington.gestorgrupos.fachada.contrato.ITipoProgramaFachada;
import co.edu.uniremington.gestorgrupos.negocio.contrato.ITipoProgramaNegocio;
import co.edu.uniremington.gestorgrupos.negocio.implementacion.TipoProgramaNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class TipoProgramaFachada implements ITipoProgramaFachada {

	@Override
	public void crear(TipoProgramaDTO tipoProgramaDTO) {

		// Honwer
		DAOFactory factoriaDAOs = null;

		try {
			ITipoProgramaNegocio tipoProgramaNegocio = new TipoProgramaNegocio(factoriaDAOs);

			factoriaDAOs.abrirConexion();
			factoriaDAOs.iniciarTransaccion();

			tipoProgramaNegocio.crear(tipoProgramaDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de registrar tipo de programa con el nombre: " + tipoProgramaDTO.getNombre() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El tipo de programa  que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void modificar(TipoProgramaDTO tipoProgramaDTO) {
		// Honwer
		DAOFactory factoriaDAOs = null;

		try {
			ITipoProgramaNegocio tipoProgramaNegocio = new TipoProgramaNegocio(factoriaDAOs);

			factoriaDAOs.abrirConexion();
			factoriaDAOs.iniciarTransaccion();

			tipoProgramaNegocio.modificar(tipoProgramaDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de modificar tipo de programa con el codigo: " + tipoProgramaDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El tipo de programa  que intentas actualizar con el nombre" + tipoProgramaDTO.getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void cambiarFechaBaja(TipoProgramaDTO tipoProgramaDTO) {

		DAOFactory factoriaDAOs = null;

		try {
			ITipoProgramaNegocio tipoProgramaNegocio = new TipoProgramaNegocio(factoriaDAOs);

			factoriaDAOs.abrirConexion();
			factoriaDAOs.iniciarTransaccion();

			tipoProgramaNegocio.cambiarFechaBaja(tipoProgramaDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar de fecha de baja tipo de programa con el codigo: " + tipoProgramaDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El tipo de programa  que intentas cambiar la fecha de baja con el nombre" + tipoProgramaDTO.getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public List<TipoProgramaDTO> consultar(TipoProgramaDTO tipoProgramaDTO) {

		DAOFactory factoriaDAOs = null;

		List<TipoProgramaDTO> listaRetorno = null;

		try {
			ITipoProgramaNegocio tipoProgramaNegocio = new TipoProgramaNegocio(factoriaDAOs);

			factoriaDAOs.abrirConexion();
			listaRetorno = tipoProgramaNegocio.consultar(tipoProgramaDTO);
			return tipoProgramaNegocio.consultar(tipoProgramaDTO);

		} catch (GestorGruposException exception) {
			throw exception;
		} catch (Exception e) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de los tipos programa";
			String mensajeUsuario = "Upps!!! No hemos podido consultar la información de los tipos de programa. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}
		return null;
	}

}
