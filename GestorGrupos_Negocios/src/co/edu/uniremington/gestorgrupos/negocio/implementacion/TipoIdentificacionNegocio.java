package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.ITipoIdentificacionDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.TipoIdentificacionDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.ITipoIdentificacionNegocio;

public class TipoIdentificacionNegocio implements ITipoIdentificacionNegocio{

	private DAOFactory daoFactory;
	
	public TipoIdentificacionNegocio(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	
	} 
	
	@Override
	public void crear(TipoIdentificacionDTO tipoIdentificacionDTO) {
		ITipoIdentificacionDAO tipoIdentificacionDAO= daoFactory.obtenerTipoIdentificacionDAO();
		tipoIdentificacionDAO.crear(tipoIdentificacionDTO);
		
	}

	@Override
	public void modificar(TipoIdentificacionDTO tipoIdentificacionDTO) {
		ITipoIdentificacionDAO tipoIdentificacionDAO= daoFactory.obtenerTipoIdentificacionDAO();
		tipoIdentificacionDAO.modificar(tipoIdentificacionDTO);
		
	}

	@Override
	public void cambiarFechaBaja(TipoIdentificacionDTO tipoIdentificacionDTO) {
		ITipoIdentificacionDAO tipoIdentificacionDAO= daoFactory.obtenerTipoIdentificacionDAO();
		tipoIdentificacionDAO.cambiarFechaBaja(tipoIdentificacionDTO);
		
	}

	@Override
	public List<TipoIdentificacionDTO> consultar(TipoIdentificacionDTO tipoIdentificacionDTO) {
		ITipoIdentificacionDAO tipoIdentificacionDAO= daoFactory.obtenerTipoIdentificacionDAO();
		return tipoIdentificacionDAO.consultar(tipoIdentificacionDTO);
		
	}

}
