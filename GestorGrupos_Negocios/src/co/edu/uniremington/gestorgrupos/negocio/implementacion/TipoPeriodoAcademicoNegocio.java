package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.ITipoPeriodoAcademicoDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.TipoPeriodoAcademicoDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.ITipoPeriodoAcademicoNegocio;

public class TipoPeriodoAcademicoNegocio implements ITipoPeriodoAcademicoNegocio{

	private DAOFactory daoFactory;
	
	public TipoPeriodoAcademicoNegocio(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	
	} 
	
	@Override
	public void crear(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO) {
		ITipoPeriodoAcademicoDAO tipoPeriodoAcademicoDAO= daoFactory.obtenerTipoPeriodoAcademicoDAO();
		tipoPeriodoAcademicoDAO.crear(tipoPeriodoAcademicoDTO);
		
	}

	@Override
	public void modificar(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO) {
		ITipoPeriodoAcademicoDAO tipoPeriodoAcademicoDAO= daoFactory.obtenerTipoPeriodoAcademicoDAO();
		tipoPeriodoAcademicoDAO.modificar(tipoPeriodoAcademicoDTO);
		
	}

	@Override
	public void cambiarFechaBaja(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO) {
		ITipoPeriodoAcademicoDAO tipoPeriodoAcademicoDAO= daoFactory.obtenerTipoPeriodoAcademicoDAO();
		tipoPeriodoAcademicoDAO.cambiarFechaBaja(tipoPeriodoAcademicoDTO);
		
	}

	@Override
	public List<TipoPeriodoAcademicoDTO> consultar(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO) {
		ITipoPeriodoAcademicoDAO tipoPeriodoAcademicoDAO= daoFactory.obtenerTipoPeriodoAcademicoDAO();
		return tipoPeriodoAcademicoDAO.consultar(tipoPeriodoAcademicoDTO);
		
	}

}
