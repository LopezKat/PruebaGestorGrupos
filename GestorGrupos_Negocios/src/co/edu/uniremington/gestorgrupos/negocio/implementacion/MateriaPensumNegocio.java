package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IMateriaPensumDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.MateriaPensumDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IMateriaPensumNegocio;

public class MateriaPensumNegocio implements IMateriaPensumNegocio{

	private DAOFactory daoFactory;
	
	public MateriaPensumNegocio(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	
	} 
	
	@Override
	public void crear(MateriaPensumDTO materiaPensumDTO) {
		IMateriaPensumDAO materiaPensumDAO= daoFactory.obtenerMateriaPensumDAO();
		materiaPensumDAO.crear(materiaPensumDTO);
		
	}

	@Override
	public void modificar(MateriaPensumDTO materiaPensumDTO) {
		IMateriaPensumDAO materiaPensumDAO= daoFactory.obtenerMateriaPensumDAO();
		materiaPensumDAO.modificar(materiaPensumDTO);
		
	}

	@Override
	public void cambiarFechaBaja(MateriaPensumDTO materiaPensumDTO) {
		IMateriaPensumDAO materiaPensumDAO= daoFactory.obtenerMateriaPensumDAO();
		materiaPensumDAO.cambiarFechaBaja(materiaPensumDTO);
		
	}

	@Override
	public List<MateriaPensumDTO> consultar(MateriaPensumDTO materiaPensumDTO) {
		IMateriaPensumDAO materiaPensumDAO= daoFactory.obtenerMateriaPensumDAO();
		return materiaPensumDAO.consultar(materiaPensumDTO);
		
	}

}
