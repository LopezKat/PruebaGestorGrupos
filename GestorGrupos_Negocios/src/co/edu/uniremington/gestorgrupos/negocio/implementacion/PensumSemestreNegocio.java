package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IPensumSemestreDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.PensumSemestreDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IPensumSemestreNegocio;

public class PensumSemestreNegocio implements IPensumSemestreNegocio{

	private DAOFactory daoFactory;
	
	public PensumSemestreNegocio(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	
	} 
	
	@Override
	public void crear(PensumSemestreDTO pensumSemestreDTO) {
		IPensumSemestreDAO pensumSemestreDAO= daoFactory.obtenerPensumSemestreDAO();
		pensumSemestreDAO.crear(pensumSemestreDTO);
		
	}

	@Override
	public void modificar(PensumSemestreDTO pensumSemestreDTO) {
		IPensumSemestreDAO pensumSemestreDAO= daoFactory.obtenerPensumSemestreDAO();
		pensumSemestreDAO.modificar(pensumSemestreDTO);
		
	}

	@Override
	public void cambiarFechaBaja(PensumSemestreDTO pensumSemestreDTO) {
		IPensumSemestreDAO pensumSemestreDAO= daoFactory.obtenerPensumSemestreDAO();
		pensumSemestreDAO.cambiarFechaBaja(pensumSemestreDTO);
		
	}

	@Override
	public List<PensumSemestreDTO> consultar(PensumSemestreDTO pensumSemestreDTO) {
		IPensumSemestreDAO pensumSemestreDAO= daoFactory.obtenerPensumSemestreDAO();
		return pensumSemestreDAO.consultar(pensumSemestreDTO);
		
	}

}
