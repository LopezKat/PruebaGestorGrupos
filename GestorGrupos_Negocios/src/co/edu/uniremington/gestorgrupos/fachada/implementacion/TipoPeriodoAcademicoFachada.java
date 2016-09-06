package co.edu.uniremington.gestorgrupos.fachada.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.TipoPeriodoAcademicoDTO;
import co.edu.uniremington.gestorgrupos.fachada.contrato.ITipoPeriodoAcademicoFachada;
import co.edu.uniremington.gestorgrupos.negocio.contrato.ITipoPeriodoAcademicoNegocio;
import co.edu.uniremington.gestorgrupos.negocio.implementacion.TipoPeriodoAcademicoNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class TipoPeriodoAcademicoFachada implements ITipoPeriodoAcademicoFachada {

	@Override
	public void crear(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			ITipoPeriodoAcademicoNegocio tipoPeriodoAcademicoNegocio = new TipoPeriodoAcademicoNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			tipoPeriodoAcademicoNegocio.crear(tipoPeriodoAcademicoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de registrar tipo periodo academico con el nombre: " + tipoPeriodoAcademicoDTO.getNombre() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El tipo periodo academico  que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void modificar(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			ITipoPeriodoAcademicoNegocio tipoPeriodoAcademicoNegocio = new TipoPeriodoAcademicoNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			tipoPeriodoAcademicoNegocio.modificar(tipoPeriodoAcademicoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de modificar tipo periodo academico con el codigo: " + tipoPeriodoAcademicoDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El tipo periodo academico que intentas actualizar con el nombre" + tipoPeriodoAcademicoDTO.getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void cambiarFechaBaja(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			ITipoPeriodoAcademicoNegocio tipoPeriodoAcademicoNegocio = new TipoPeriodoAcademicoNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			tipoPeriodoAcademicoNegocio.cambiarFechaBaja(tipoPeriodoAcademicoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar de fecha de baja tipo periodo academico con el codigo: " + tipoPeriodoAcademicoDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El tipo periodo academico  que intentas cambiar la fecha de baja con el nombre" + tipoPeriodoAcademicoDTO.getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public List<TipoPeriodoAcademicoDTO> consultar(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		List<TipoPeriodoAcademicoDTO> listaRetorno = null;

		try {
			ITipoPeriodoAcademicoNegocio tipoPeriodoAcademicoNegocio = new TipoPeriodoAcademicoNegocio(factoriaDAOs);

			
			listaRetorno = tipoPeriodoAcademicoNegocio.consultar(tipoPeriodoAcademicoDTO);
			return tipoPeriodoAcademicoNegocio.consultar(tipoPeriodoAcademicoDTO);

		} catch (GestorGruposException exception) {
			throw exception;
		} catch (Exception e) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de los tipos periodos academicos";
			String mensajeUsuario = "Upps!!! No hemos podido consultar la información de los tipos periodos academicos. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}
		return null;
	}

}
