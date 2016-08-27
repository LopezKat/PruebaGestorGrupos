package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.ITipoProgramaDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.TipoProgramaDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.ITipoProgramaNegocio;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class TipoProgramaNegocio implements ITipoProgramaNegocio {

	private DAOFactory daoFactory;

	public TipoProgramaNegocio(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;

	}

	@Override
	public void crear(TipoProgramaDTO tipoProgramaDTO) {
		ITipoProgramaDAO tipoProgramaDAO = daoFactory.obtenerTipoProgramaDAO();

		TipoProgramaDTO tipoProgramaConsulta = new TipoProgramaDTO();

		tipoProgramaConsulta.setNombre(tipoProgramaDTO.getNombre());

		List<TipoProgramaDTO> listaConsulta = tipoProgramaDAO.consultar(tipoProgramaConsulta);

		if (!listaConsulta.isEmpty()) {
			String mensajeTecnico = "Se ha presentado un problema tratando de registrar un nuevo tipo de programa con el nombre: " + tipoProgramaDTO.getNombre() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El tipo de programa  que intentas registrar ya existe.Puedes actualizarlo si deseas";

			GestorGruposException.crearExcepcion("NEGOCIO", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");

		}

		tipoProgramaDAO.crear(tipoProgramaDTO);

	}

	@Override
	public void modificar(TipoProgramaDTO tipoProgramaDTO) {
		ITipoProgramaDAO tipoProgramaDAO = daoFactory.obtenerTipoProgramaDAO();

		// Consultar por el codigo
		TipoProgramaDTO tipoProgramaConsulta = new TipoProgramaDTO();

		tipoProgramaConsulta.setCodigo(tipoProgramaDTO.getCodigo());

		List<TipoProgramaDTO> listaConsultada = tipoProgramaDAO.consultar(tipoProgramaConsulta);

		if (!listaConsultada.isEmpty()) {
			String mensajeTecnico = "Se ha presentado un problema tratar de actualizar los datos tipo programa con el código: " + tipoProgramaDTO.getCodigo() + "debido a que no existe";
			String mensajeUsuario = "Upps!!! El tipo de programa  que intentas registrar ya existe.Puedes actualizarlo si deseas";

			GestorGruposException.crearExcepcion("NEGOCIO", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		}

		// Consultar por el nombre
		tipoProgramaConsulta = new TipoProgramaDTO();

		tipoProgramaConsulta.setNombre(tipoProgramaDTO.getNombre());

		listaConsultada = tipoProgramaDAO.consultar(tipoProgramaConsulta);

		if (listaConsultada.isEmpty() && listaConsultada.get(0).getCodigo() != tipoProgramaDTO.getCodigo()) {
			String mensajeTecnico = "Se ha presentado un problema tratar de actualizar los datos tipo programa con el código: " + tipoProgramaDTO.getCodigo() + "debido a que no existe otro tipo de programa con el nombre que deseas actualizar";
			String mensajeUsuario = "Upps!!! El nombre que deseas colocar al tipo de programa ya que está asignado a otro.";

			GestorGruposException.crearExcepcion("NEGOCIO", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "modificar");
		}

		tipoProgramaDAO.modificar(tipoProgramaDTO);

	}

	@Override
	public void cambiarFechaBaja(TipoProgramaDTO tipoProgramaDTO) {
		ITipoProgramaDAO tipoProgramaDAO = daoFactory.obtenerTipoProgramaDAO();
		
		TipoProgramaDTO tipoProgramaConsulta = new TipoProgramaDTO();

		tipoProgramaConsulta.setCodigo(tipoProgramaDTO.getCodigo());

		List<TipoProgramaDTO> listaConsulta = tipoProgramaDAO.consultar(tipoProgramaConsulta);

		if (!listaConsulta.isEmpty()) {
			String mensajeTecnico = "Se ha presentado un problema tratando de cambiar una fecha de baja de tipo de programa con el nombre: " + tipoProgramaDTO.getNombre() + "debido a que la fuente de información ya existe";
			String mensajeUsuario = "Upps!!! El tipo de programa  que intentas modificar el estado no existe.";

			GestorGruposException.crearExcepcion("NEGOCIO", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "crear");

		}

		tipoProgramaDAO.cambiarFechaBaja(tipoProgramaDTO);

	}

	@Override
	public List<TipoProgramaDTO> consultar(TipoProgramaDTO tipoProgramaDTO) {
		ITipoProgramaDAO tipoProgramaDAO = daoFactory.obtenerTipoProgramaDAO();
		return tipoProgramaDAO.consultar(tipoProgramaDTO);

	}

}
