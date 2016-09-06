package co.edu.uniremington.gestorgrupos.fachada.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.MateriaPensumDTO;
import co.edu.uniremington.gestorgrupos.fachada.contrato.IMateriaPensumFachada;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IMateriaPensumNegocio;
import co.edu.uniremington.gestorgrupos.negocio.implementacion.MateriaPensumNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class MateriaPensumFachada implements IMateriaPensumFachada {

	@Override
	public void crear(MateriaPensumDTO materiaPensumDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IMateriaPensumNegocio materiaPensumNegocio = new MateriaPensumNegocio(factoriaDAOs);

			factoriaDAOs.iniciarTransaccion();
			materiaPensumNegocio.crear(materiaPensumDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de registrar la materia pensum con el nombre: "
					+ materiaPensumDTO.getMateria().getNombre() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! La materia pensum que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void modificar(MateriaPensumDTO materiaPensumDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IMateriaPensumNegocio materiaPensumNegocio = new MateriaPensumNegocio(factoriaDAOs);

			factoriaDAOs.iniciarTransaccion();
			materiaPensumNegocio.modificar(materiaPensumDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de modificar materia pensum con el codigo: "
					+ materiaPensumDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! La materia pensum  que intentas actualizar con el nombre"
					+ materiaPensumDTO.getMateria().getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void cambiarFechaBaja(MateriaPensumDTO materiaPensumDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IMateriaPensumNegocio materiaPensumNegocio = new MateriaPensumNegocio(factoriaDAOs);

			factoriaDAOs.iniciarTransaccion();
			materiaPensumNegocio.cambiarFechaBaja(materiaPensumDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar la fecha de baja de la materia pensum con el codigo: "
					+ materiaPensumDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! La materia pensum  que intentas cambiar la fecha de baja con el nombre"
					+ materiaPensumDTO.getMateria().getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public List<MateriaPensumDTO> consultar(MateriaPensumDTO materiaPensumDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		List<MateriaPensumDTO> listaRetorno = null;

		try {
			IMateriaPensumNegocio materiaPensumNegocio = new MateriaPensumNegocio(factoriaDAOs);

			listaRetorno = materiaPensumNegocio.consultar(materiaPensumDTO);
			return materiaPensumNegocio.consultar(materiaPensumDTO);

		} catch (GestorGruposException exception) {
			throw exception;
		} catch (Exception e) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de las materias pensum";
			String mensajeUsuario = "Upps!!! No hemos podido consultar la información de las materias pensum. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}
		return null;
	}

}
