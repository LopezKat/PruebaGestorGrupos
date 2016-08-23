package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IEstudianteDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.EstudianteDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IEstudianteNegocio;

public class EstudianteNegocio implements IEstudianteNegocio {

	private DAOFactory daoFactory;

	public EstudianteNegocio(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;

	}

	@Override
	public void crear(EstudianteDTO estudianteDTO) {
		IEstudianteDAO estudianteDAO = daoFactory.obtenerEstudianteDAO();
		estudianteDAO.crear(estudianteDTO);

	}

	@Override
	public void modificar(EstudianteDTO estudianteDTO) {
		IEstudianteDAO estudianteDAO = daoFactory.obtenerEstudianteDAO();
		estudianteDAO.modificar(estudianteDTO);

	}

	@Override
	public void cambiarFechaBaja(EstudianteDTO estudianteDTO) {
		IEstudianteDAO estudianteDAO = daoFactory.obtenerEstudianteDAO();
		estudianteDAO.cambiarFechaBaja(estudianteDTO);
	}

	@Override
	public List<EstudianteDTO> consultar(EstudianteDTO estudianteDTO) {
		IEstudianteDAO estudianteDAO = daoFactory.obtenerEstudianteDAO();
		return estudianteDAO.consultar(estudianteDTO);

	}

}
