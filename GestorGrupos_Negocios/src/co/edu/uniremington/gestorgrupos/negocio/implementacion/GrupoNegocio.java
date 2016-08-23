package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IGrupoDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.GrupoDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IGrupoNegocio;

public class GrupoNegocio implements IGrupoNegocio{

	private DAOFactory daoFactory;
	
	public GrupoNegocio(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	
	} 
	
	@Override
	public void crear(GrupoDTO grupoDTO) {
		IGrupoDAO grupoDAO= daoFactory.obtenerGrupoDAO();
		grupoDAO.crear(grupoDTO);
		
	}

	@Override
	public void modificar(GrupoDTO grupoDTO) {
		IGrupoDAO grupoDAO= daoFactory.obtenerGrupoDAO();
		grupoDAO.modificar(grupoDTO);
		
	}

	@Override
	public void cambiarFechaBaja(GrupoDTO grupoDTO) {
		IGrupoDAO grupoDAO= daoFactory.obtenerGrupoDAO();
		grupoDAO.cambiarFechaBaja(grupoDTO);
		
	}

	@Override
	public List<GrupoDTO> consultar(GrupoDTO grupoDTO) {
		IGrupoDAO grupoDAO= daoFactory.obtenerGrupoDAO();
		return grupoDAO.consultar(grupoDTO);
		
	}

}
