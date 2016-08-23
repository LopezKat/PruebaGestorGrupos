package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.ITipoNotaDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.TipoNotaDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.ITipoNotaNegocio;

public class TipoNotaNegocio implements ITipoNotaNegocio{

	private DAOFactory daoFactory;
	
	public TipoNotaNegocio(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	
	} 
	
	@Override
	public void crear(TipoNotaDTO tipoNotaDTO) {
		ITipoNotaDAO tipoNotaDAO= daoFactory.obtenerTipoNotaDAO();
		tipoNotaDAO.crear(tipoNotaDTO);
		
	}

	@Override
	public void modificar(TipoNotaDTO tipoNotaDTO) {
		ITipoNotaDAO tipoNotaDAO= daoFactory.obtenerTipoNotaDAO();
		tipoNotaDAO.modificar(tipoNotaDTO);
		
	}

	@Override
	public void cambiarFechaBaja(TipoNotaDTO tipoNotaDTO) {
		ITipoNotaDAO tipoNotaDAO= daoFactory.obtenerTipoNotaDAO();
		tipoNotaDAO.cambiarFechaBaja(tipoNotaDTO);
		
	}

	@Override
	public List<TipoNotaDTO> consultar(TipoNotaDTO tipoNotaDTO) {
		ITipoNotaDAO tipoNotaDAO= daoFactory.obtenerTipoNotaDAO();
		return tipoNotaDAO.consultar(tipoNotaDTO);
		
	}

}
