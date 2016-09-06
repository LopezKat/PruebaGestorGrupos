package co.edu.uniremington.gestorgrupos.fachada.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.PeriodoAcademicoDTO;
import co.edu.uniremington.gestorgrupos.fachada.contrato.IPeriodoAcademicoFachada;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IPeriodoAcademicoNegocio;
import co.edu.uniremington.gestorgrupos.negocio.implementacion.PeriodoAcademicoNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class PeriodoAcademicoFachada implements IPeriodoAcademicoFachada {

	@Override
	public void crear(PeriodoAcademicoDTO periodoAcademicoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IPeriodoAcademicoNegocio periodoAcademicoNegocio = new PeriodoAcademicoNegocio(factoriaDAOs);
			
			factoriaDAOs.iniciarTransaccion();
			periodoAcademicoNegocio.crear(periodoAcademicoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de registrar periodo acádemico con el nombre: " + periodoAcademicoDTO.getTipoPeriodoAcademico().getNombre() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El periodo acádemico  que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void modificar(PeriodoAcademicoDTO periodoAcademicoDTO) {
		
		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");
		
		try {
			IPeriodoAcademicoNegocio periodoAcademicoNegocio = new PeriodoAcademicoNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			periodoAcademicoNegocio.modificar(periodoAcademicoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();
			String mensajeTecnico = "Se ha presentado un problema tratando de modificar periodo acádemico con el codigo: " + periodoAcademicoDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El periodo acádemico  que intentas actualizar con el nombre" + periodoAcademicoDTO.getTipoPeriodoAcademico().getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void cambiarFechaBaja(PeriodoAcademicoDTO periodoAcademicoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IPeriodoAcademicoNegocio periodoAcademicoNegocio = new PeriodoAcademicoNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			periodoAcademicoNegocio.cambiarFechaBaja(periodoAcademicoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar la fecha de baja de periodo acádemico con el codigo: " + periodoAcademicoDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El periodo acádemico que intentas cambiar la fecha de baja con el nombre" + periodoAcademicoDTO.getTipoPeriodoAcademico().getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public List<PeriodoAcademicoDTO> consultar(PeriodoAcademicoDTO periodoAcademicoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		List<PeriodoAcademicoDTO> listaRetorno = null;

		try {
			IPeriodoAcademicoNegocio periodoAcademicoNegocio = new PeriodoAcademicoNegocio(factoriaDAOs);

			
			listaRetorno = periodoAcademicoNegocio.consultar(periodoAcademicoDTO);
			return periodoAcademicoNegocio.consultar(periodoAcademicoDTO);

		} catch (GestorGruposException exception) {
			throw exception;
		} catch (Exception e) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de los periodos acádemicos";
			String mensajeUsuario = "Upps!!! No hemos podido consultar la información de los periodos acádemicos. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}
		return null;
	}

}
