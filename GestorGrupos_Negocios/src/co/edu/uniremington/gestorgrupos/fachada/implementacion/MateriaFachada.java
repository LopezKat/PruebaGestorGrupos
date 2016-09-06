package co.edu.uniremington.gestorgrupos.fachada.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.MateriaDTO;
import co.edu.uniremington.gestorgrupos.fachada.contrato.IMateriaFachada;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IMateriaNegocio;
import co.edu.uniremington.gestorgrupos.negocio.implementacion.MateriaNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class MateriaFachada implements IMateriaFachada {

	@Override
	public void crear(MateriaDTO materiaDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IMateriaNegocio materiaNegocio = new MateriaNegocio(factoriaDAOs);

			factoriaDAOs.iniciarTransaccion();
			materiaNegocio.crear(materiaDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de registrar la materia con el nombre: " + materiaDTO.getNombre() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! La materia  que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void modificar(MateriaDTO materiaDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IMateriaNegocio materiaNegocio = new MateriaNegocio(factoriaDAOs);

			factoriaDAOs.iniciarTransaccion();
			materiaNegocio.modificar(materiaDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de modificar la materia con el código: " + materiaDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!!La materia que intentas actualizar con el nombre" + materiaDTO.getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public void cambiarFechaBaja(MateriaDTO materiaDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		try {
			IMateriaNegocio materiaNegocio = new MateriaNegocio(factoriaDAOs);

			
			factoriaDAOs.iniciarTransaccion();

			materiaNegocio.cambiarFechaBaja(materiaDTO);
			factoriaDAOs.confirmarTransaccion();

		} catch (GestorGruposException exception) {
			factoriaDAOs.cancelarTransaccion();
			throw exception;
		} catch (Exception e) {

			factoriaDAOs.cancelarTransaccion();

			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar de fecha de baja la materia con el código: " + materiaDTO.getCodigo() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! La materia  que intentas cambiar la fecha de baja con el nombre" + materiaDTO.getNombre() + ".Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}

	}

	@Override
	public List<MateriaDTO> consultar(MateriaDTO materiaDTO) {

		DAOFactory factoriaDAOs = DAOFactory.obtenerFactoria("SQLServerBDGrupos");

		List<MateriaDTO> listaRetorno = null;

		try {
			IMateriaNegocio materiaNegocio = new MateriaNegocio(factoriaDAOs);

			
			listaRetorno = materiaNegocio.consultar(materiaDTO);
			return materiaNegocio.consultar(materiaDTO);

		} catch (GestorGruposException exception) {
			throw exception;
		} catch (Exception e) {

			String mensajeTecnico = "Se ha presentado un problema realizando la consulta de las materias";
			String mensajeUsuario = "Upps!!! No hemos podido consultar la información de las materias. Por favor intentelo de nuevo";

			GestorGruposException.crearExcepcion("FACHADA", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cambiarFechaBaja");
		} finally {
			factoriaDAOs.cerrarConexion();

		}
		return null;
	}

}
