package co.edu.uniremington.gestorgrupos.fachada.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.NotaGrupoDTO;
import co.edu.uniremington.gestorgrupos.fachada.contrato.INotaGrupoFachada;
import co.edu.uniremington.gestorgrupos.negocio.contrato.INotaGrupoNegocio;
import co.edu.uniremington.gestorgrupos.negocio.implementacion.NotaGrupoNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class NotaGrupoFachada implements INotaGrupoFachada {

	@Override
	public void crear(NotaGrupoDTO notaGrupoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			INotaGrupoNegocio notaGrupoNegocio = new NotaGrupoNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			notaGrupoNegocio.crear(notaGrupoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de registrar una nota grupo con el nombre: " + notaGrupoDTO.getTipoNota().getNombre() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! La nota grupo  que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void modificar(NotaGrupoDTO notaGrupoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			INotaGrupoNegocio notaGrupoNegocio = new NotaGrupoNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			notaGrupoNegocio.modificar(notaGrupoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de modificar una nota grupo con el codigo: " + notaGrupoDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! La nota grupo  que intentas actualizar con el nombre" + notaGrupoDTO.getTipoNota().getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void cambiarFechaBaja(NotaGrupoDTO notaGrupoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			INotaGrupoNegocio notaGrupoNegocio = new NotaGrupoNegocio(factoriaDAOs);
			
			factoriaDAOs.iniciarTransaccion();
			notaGrupoNegocio.cambiarFechaBaja(notaGrupoDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar la fecha de baja de nota grupo con el codigo: " + notaGrupoDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! La nota grupo  que intentas cambiar la fecha de baja con el nombre" + notaGrupoDTO.getTipoNota().getNombre()+ ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public List<NotaGrupoDTO> consultar(NotaGrupoDTO notaGrupoDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		List<NotaGrupoDTO> listaRetorno = null;

		try {
			INotaGrupoNegocio notaGrupoNegocio = new NotaGrupoNegocio(factoriaDAOs);

			
			listaRetorno = notaGrupoNegocio.consultar(notaGrupoDTO);
			return notaGrupoNegocio.consultar(notaGrupoDTO);

		} catch (GestorGruposException exception) {
			throw exception;
		} catch (Exception e) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de las nota grupo";
			String mensajeUsuario = "Upps!!! No hemos podido consultar la información de las nota grupo. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}
		return null;
	}

}
