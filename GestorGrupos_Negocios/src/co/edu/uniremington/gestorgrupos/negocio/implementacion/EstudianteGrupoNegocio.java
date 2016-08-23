package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IEstudianteGrupoDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.EstudianteGrupoDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IEstudianteGrupoNegocio;

public class EstudianteGrupoNegocio implements IEstudianteGrupoNegocio {

	private DAOFactory daoFactory;

	public EstudianteGrupoNegocio(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;

	}

	@Override
	public void crear(EstudianteGrupoDTO estudianteGrupoDTO) {
		IEstudianteGrupoDAO estudianteGrupoDAO = daoFactory.obtenerEstudianteGrupoDAO();
		estudianteGrupoDAO.crear(estudianteGrupoDTO);

	}

	@Override
	public void modificar(EstudianteGrupoDTO estudianteGrupoDTO) {
		IEstudianteGrupoDAO estudianteGrupoDAO = daoFactory.obtenerEstudianteGrupoDAO();
		estudianteGrupoDAO.modificar(estudianteGrupoDTO);

	}

	@Override
	public void cambiarFechaBaja(EstudianteGrupoDTO estudianteGrupoDTO) {
		IEstudianteGrupoDAO estudianteGrupoDAO = daoFactory.obtenerEstudianteGrupoDAO();
		estudianteGrupoDAO.cambiarFechaBaja(estudianteGrupoDTO);

	}

	@Override
	public List<EstudianteGrupoDTO> consultar(EstudianteGrupoDTO estudianteGrupoDTO) {
		IEstudianteGrupoDAO estudianteGrupoDAO = daoFactory.obtenerEstudianteGrupoDAO();
		return estudianteGrupoDAO.consultar(estudianteGrupoDTO);
	}

}
