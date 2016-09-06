package co.edu.uniremington.gestorgrupos.fachada.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.GeneroDTO;
import co.edu.uniremington.gestorgrupos.fachada.contrato.IGeneroFachada;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IGeneroNegocio;
import co.edu.uniremington.gestorgrupos.negocio.implementacion.GeneroNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class GeneroFachada implements IGeneroFachada {

	@Override
	public void crear(GeneroDTO generoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");
		
		try {
			IGeneroNegocio generoNegocio = new GeneroNegocio(factoriaDAOs);

			factoriaDAOs.iniciarTransaccion();
			generoNegocio.crear(generoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de registrar genero con el nombre: " + generoDTO.getNombre() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El genero  que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void modificar(GeneroDTO generoDTO) {
		// Honwer
		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IGeneroNegocio generoNegocio = new GeneroNegocio(factoriaDAOs);

			factoriaDAOs.iniciarTransaccion();
			generoNegocio.modificar(generoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de modificar genero con el codigo: " + generoDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El genero  que intentas actualizar con el nombre" + generoDTO.getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void cambiarFechaBaja(GeneroDTO generoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IGeneroNegocio generoNegocio = new GeneroNegocio(factoriaDAOs);

			factoriaDAOs.iniciarTransaccion();
			generoNegocio.cambiarFechaBaja(generoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar de fecha de baja genero con el codigo: " + generoDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El genero  que intentas cambiar la fecha de baja con el nombre" + generoDTO.getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public List<GeneroDTO> consultar(GeneroDTO generoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		List<GeneroDTO> listaRetorno = null;

		try {
			IGeneroNegocio generoNegocio = new GeneroNegocio(factoriaDAOs);

			listaRetorno = generoNegocio.consultar(generoDTO);
			return generoNegocio.consultar(generoDTO);

		} catch (GestorGruposException exception) {
			throw exception;
		} catch (Exception e) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de los generos";
			String mensajeUsuario = "Upps!!! No hemos podido consultar la información de los generos. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}
		return null;
	}

}
