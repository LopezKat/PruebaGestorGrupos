package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.ITipoProgramaDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.TipoProgramaDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.ITipoProgramaNegocio;

public class TipoProgramaNegocio implements ITipoProgramaNegocio{

	private DAOFactory daoFactory;
	
	public TipoProgramaNegocio(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	
	} 
	
	@Override
	public void crear(TipoProgramaDTO tipoProgramaDTO) {
		ITipoProgramaDAO tipoProgramaDAO= daoFactory.obtenerTipoProgramaDAO();
		tipoProgramaDAO.crear(tipoProgramaDTO);
		
	}

	@Override
	public void modificar(TipoProgramaDTO tipoProgramaDTO) {
		ITipoProgramaDAO tipoProgramaDAO= daoFactory.obtenerTipoProgramaDAO();
		tipoProgramaDAO.modificar(tipoProgramaDTO);
		
	}

	@Override
	public void cambiarFechaBaja(TipoProgramaDTO tipoProgramaDTO) {
		ITipoProgramaDAO tipoProgramaDAO= daoFactory.obtenerTipoProgramaDAO();
		tipoProgramaDAO.cambiarFechaBaja(tipoProgramaDTO);
		
	}

	@Override
	public List<TipoProgramaDTO> consultar(TipoProgramaDTO tipoProgramaDTO) {
		ITipoProgramaDAO tipoProgramaDAO= daoFactory.obtenerTipoProgramaDAO();
		return tipoProgramaDAO.consultar(tipoProgramaDTO);
		
	}

}
