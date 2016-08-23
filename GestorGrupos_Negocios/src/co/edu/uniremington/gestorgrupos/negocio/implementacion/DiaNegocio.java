package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IDiaDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.DiaDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IDiaNegocio;

public class DiaNegocio implements IDiaNegocio{

	private DAOFactory daoFactory;
	
	public DiaNegocio(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	
	} 
	
	@Override
	public void crear(DiaDTO diaDTO) {
		IDiaDAO diaDAO= daoFactory.obtenerDiaDAO();
		diaDAO.crear(diaDTO);
		
	}

	@Override
	public void modificar(DiaDTO diaDTO) {
		IDiaDAO diaDAO= daoFactory.obtenerDiaDAO();
		diaDAO.modificar(diaDTO);
		
	}

	@Override
	public void cambiarFechaBaja(DiaDTO diaDTO) {
		IDiaDAO diaDAO= daoFactory.obtenerDiaDAO();
		diaDAO.cambiarFechaBaja(diaDTO);
		
	}

	@Override
	public List<DiaDTO> consultar(DiaDTO diaDTO) {
		IDiaDAO diaDAO= daoFactory.obtenerDiaDAO();
		return diaDAO.consultar(diaDTO);
		
	}

}
