package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IPensumDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.PensumDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IPensumNegocio;

public class PensumNegocio implements IPensumNegocio{

	private DAOFactory daoFactory;
	
	public PensumNegocio(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	
	} 
	
	@Override
	public void crear(PensumDTO pensumDTO) {
		IPensumDAO pensumDAO= daoFactory.obtenerPensumDAO();
		pensumDAO.crear(pensumDTO);
		
	}

	@Override
	public void modificar(PensumDTO pensumDTO) {
		IPensumDAO pensumDAO= daoFactory.obtenerPensumDAO();
		pensumDAO.modificar(pensumDTO);
		
	}

	@Override
	public void cambiarFechaBaja(PensumDTO pensumDTO) {
		IPensumDAO pensumDAO= daoFactory.obtenerPensumDAO();
		pensumDAO.cambiarFechaBaja(pensumDTO);
		
	}

	@Override
	public List<PensumDTO> consultar(PensumDTO pensumDTO) {
		IPensumDAO pensumDAO= daoFactory.obtenerPensumDAO();
		return pensumDAO.consultar(pensumDTO);
		
	}

}
