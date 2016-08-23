package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.ISemestreDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.SemestreDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.ISemestreNegocio;

public class SemestreNegocio implements ISemestreNegocio{

	private DAOFactory daoFactory;
	
	public SemestreNegocio(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	
	} 
	
	@Override
	public void crear(SemestreDTO semestreDTO) {
		ISemestreDAO semestreDAO= daoFactory.obtenerSemestreDAO();
		semestreDAO.crear(semestreDTO);
		
	}

	@Override
	public void modificar(SemestreDTO semestreDTO) {
		ISemestreDAO semestreDAO= daoFactory.obtenerSemestreDAO();
		semestreDAO.modificar(semestreDTO);
		
	}

	@Override
	public void cambiarFechaBaja(SemestreDTO semestreDTO) {
		ISemestreDAO semestreDAO= daoFactory.obtenerSemestreDAO();
		semestreDAO.cambiarFechaBaja(semestreDTO);
		
	}

	@Override
	public List<SemestreDTO> consultar(SemestreDTO semestreDTO) {
		ISemestreDAO semestreDAO= daoFactory.obtenerSemestreDAO();
		return semestreDAO.consultar(semestreDTO);
		
	}

}
