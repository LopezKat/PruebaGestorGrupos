package co.edu.uniremington.gestorgrupos.fachada.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.SemestreDTO;
import co.edu.uniremington.gestorgrupos.fachada.contrato.ISemestreFachada;
import co.edu.uniremington.gestorgrupos.negocio.contrato.ISemestreNegocio;
import co.edu.uniremington.gestorgrupos.negocio.implementacion.SemestreNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class SemestreFachada implements ISemestreFachada {

	@Override
	public void crear(SemestreDTO semestreDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			ISemestreNegocio semestreNegocio = new SemestreNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			semestreNegocio.crear(semestreDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de registrar semestre con el nombre: " + semestreDTO.getNombre() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El semestre  que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void modificar(SemestreDTO semestreDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			ISemestreNegocio semestreNegocio = new SemestreNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			semestreNegocio.modificar(semestreDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de modificar semestre con el codigo: " + semestreDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El semestre  que intentas actualizar con el nombre" + semestreDTO.getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void cambiarFechaBaja(SemestreDTO semestreDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			ISemestreNegocio semestreNegocio = new SemestreNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();
			semestreNegocio.cambiarFechaBaja(semestreDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar de fecha de baja semestre con el codigo: " + semestreDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El semestre  que intentas cambiar la fecha de baja con el nombre" + semestreDTO.getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public List<SemestreDTO> consultar(SemestreDTO semestreDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		List<SemestreDTO> listaRetorno = null;

		try {
			ISemestreNegocio semestreNegocio = new SemestreNegocio(factoriaDAOs);

			
			listaRetorno = semestreNegocio.consultar(semestreDTO);
			return semestreNegocio.consultar(semestreDTO);

		} catch (GestorGruposException exception) {
			throw exception;
		} catch (Exception e) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de semestres";
			String mensajeUsuario = "Upps!!! No hemos podido consultar la información de semestres. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}
		return null;
	}

}
