package co.edu.uniremington.gestorgrupos.fachada.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.TipoIdentificacionDTO;
import co.edu.uniremington.gestorgrupos.fachada.contrato.ITipoIdentificacionFachada;
import co.edu.uniremington.gestorgrupos.negocio.contrato.ITipoIdentificacionNegocio;
import co.edu.uniremington.gestorgrupos.negocio.implementacion.TipoIdentificacionNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class TipoIdentificacionFachada implements ITipoIdentificacionFachada {

	@Override
	public void crear(TipoIdentificacionDTO tipoIdentificacionDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			ITipoIdentificacionNegocio tipoIdentificacionNegocio = new TipoIdentificacionNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();

			tipoIdentificacionNegocio.crear(tipoIdentificacionDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();
			String mensajeTecnico = "Se ha presentado un problema tratando de registrar tipo de identificación con el nombre: " + tipoIdentificacionDTO.getNombre() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El tipo de identificación  que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void modificar(TipoIdentificacionDTO tipoIdentificacionDTO) {
		
		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");		

		try {
			ITipoIdentificacionNegocio tipoIdentificacionNegocio = new TipoIdentificacionNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();

			tipoIdentificacionNegocio.modificar(tipoIdentificacionDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();
			String mensajeTecnico = "Se ha presentado un problema tratando de modificar tipo de identificación con el codigo: " + tipoIdentificacionDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El tipo de identificación  que intentas actualizar con el nombre" + tipoIdentificacionDTO.getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void cambiarFechaBaja(TipoIdentificacionDTO tipoIdentificacionDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			ITipoIdentificacionNegocio tipoIdentificacionNegocio = new TipoIdentificacionNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			tipoIdentificacionNegocio.cambiarFechaBaja(tipoIdentificacionDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar de fecha de baja tipo de identificación con el codigo: " + tipoIdentificacionDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El tipo de identificación  que intentas cambiar la fecha de baja con el nombre" + tipoIdentificacionDTO.getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public List<TipoIdentificacionDTO> consultar(TipoIdentificacionDTO tipoIdentificacionDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");
		
		List<TipoIdentificacionDTO> listaRetorno = null;

		try {
			ITipoIdentificacionNegocio tipoIdentificacionNegocio = new TipoIdentificacionNegocio(factoriaDAOs);

			
			listaRetorno = tipoIdentificacionNegocio.consultar(tipoIdentificacionDTO);
			return tipoIdentificacionNegocio.consultar(tipoIdentificacionDTO);

		} catch (GestorGruposException exception) {
			throw exception;
		} catch (Exception e) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de los tipos de identificación";
			String mensajeUsuario = "Upps!!! No hemos podido consultar la información de los tipos de identificación. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}
		return null;
	}

}
