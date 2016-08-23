package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IMateriaDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.MateriaDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IMateriaNegocio;

public class MateriaNegocio implements IMateriaNegocio{

	private DAOFactory daoFactory;
	
	public MateriaNegocio(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	
	} 
	
	@Override
	public void crear(MateriaDTO materiaDTO) {
		IMateriaDAO materiaDAO= daoFactory.obtenerMateriaDAO();
		materiaDAO.crear(materiaDTO);
		
	}

	@Override
	public void modificar(MateriaDTO materiaDTO) {
		IMateriaDAO materiaDAO= daoFactory.obtenerMateriaDAO();
		materiaDAO.modificar(materiaDTO);
		
	}

	@Override
	public void cambiarFechaBaja(MateriaDTO materiaDTO) {
		IMateriaDAO materiaDAO= daoFactory.obtenerMateriaDAO();
		materiaDAO.cambiarFechaBaja(materiaDTO);
		
	}

	@Override
	public List<MateriaDTO> consultar(MateriaDTO materiaDTO) {
		IMateriaDAO materiaDAO= daoFactory.obtenerMateriaDAO();
		return materiaDAO.consultar(materiaDTO);
		
	}

}
