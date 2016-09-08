package co.edu.uniremington.gestorgrupos.fachada.implementacion;

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

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SqlServerBDGrupos");

		try {
			ITipoProgramaNegocio tipoProgramaNegocio = new TipoProgramaNegocio(factoriaDAOs);
			factoriaDAOs.iniciarTransaccion();

			tipoProgramaNegocio.crear(tipoProgramaDTO);

			factoriaDAOs.confirmarTransaccion();
		} catch (GestorGruposException excepcion) {
			factoriaDAOs.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de registrar un nuevo tipo de programa con el nombre: " + tipoProgramaDTO.getNombre();
			String mensajeUsuario = "Upps!!! No hemos logrado registrar el tipo de programa con el nombre: " + tipoProgramaDTO.getNombre() + ". Por favor intenta de nuevo!!!!";

			GestorGruposException.crearExcepcion("FACHADA", excepcion, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();
		}

	}

	@Override
	public void modificar(TipoProgramaDTO tipoProgramaDTO) {
		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SqlServerBDGrupos");
		try {
			ITipoProgramaNegocio tipoProgramaNegocio = new TipoProgramaNegocio(factoriaDAOs);

			factoriaDAOs.iniciarTransaccion();

			tipoProgramaNegocio.modificar(tipoProgramaDTO);

			factoriaDAOs.confirmarTransaccion();
		} catch (GestorGruposException excepcion) {
			factoriaDAOs.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de modificar el tipo de programa con el código: " + tipoProgramaDTO.getCodigo();
			String mensajeUsuario = "Upps!!! No hemos logrado actualizar el tipo de programa con el nombre: " + tipoProgramaDTO.getNombre() + ". Por favor intenta de nuevo!!!!";

			GestorGruposException.crearExcepcion("FACHADA", excepcion, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();
		}

	}

	@Override
	public void cambiarFechaBaja(TipoProgramaDTO tipoProgramaDTO) {
		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SqlServerBDGrupos");
		try {
			ITipoProgramaNegocio tipoProgramaNegocio = new TipoProgramaNegocio(factoriaDAOs);

			factoriaDAOs.iniciarTransaccion();

			tipoProgramaNegocio.cambiarFechaBaja(tipoProgramaDTO);

			factoriaDAOs.confirmarTransaccion();
		} catch (GestorGruposException excepcion) {
			factoriaDAOs.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar la fecha de baja del tipo de programa con el código: " + tipoProgramaDTO.getCodigo();
			String mensajeUsuario = "Upps!!! No hemos logrado cambiar el estado del tipo de programa con el nombre: " + tipoProgramaDTO.getNombre() + ". Por favor intenta de nuevo!!!!";

			GestorGruposException.crearExcepcion("FACHADA", excepcion, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();
		}

	}

	@Override
	public List<TipoProgramaDTO> consultar(TipoProgramaDTO tipoProgramaDTO) {
		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SqlServerBDGrupos");
		List<TipoProgramaDTO> listaRetorno = null;

		try {
			ITipoProgramaNegocio tipoProgramaNegocio = new TipoProgramaNegocio(factoriaDAOs);
			listaRetorno = tipoProgramaNegocio.consultar(tipoProgramaDTO);
		} catch (GestorGruposException excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de los tipos de programa.";
			String mensajeUsuario = "Upps!!! No hemos consultar la información de los tipos de programa. Por favor intenta de nuevo!!!!";

			GestorGruposException.crearExcepcion("FACHADA", excepcion, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "consultar");
		} finally {
			factoriaDAOs.cerrarConexion();
		}

		return listaRetorno;
	}

}

