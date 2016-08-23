package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IPeriodoAcademicoDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.PeriodoAcademicoDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IPeriodoAcademicoNegocio;

public class PeriodoAcademicoNegocio implements IPeriodoAcademicoNegocio{

	private DAOFactory daoFactory;
	
	public PeriodoAcademicoNegocio(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	
	} 
	
	@Override
	public void crear(PeriodoAcademicoDTO periodoAcademicoDTO) {
		IPeriodoAcademicoDAO periodoAcademicoDAO= daoFactory.obtenerPeriodoAcademicoDAO();
		periodoAcademicoDAO.crear(periodoAcademicoDTO);
		
	}

	@Override
	public void modificar(PeriodoAcademicoDTO periodoAcademicoDTO) {
		IPeriodoAcademicoDAO periodoAcademicoDAO= daoFactory.obtenerPeriodoAcademicoDAO();
		periodoAcademicoDAO.modificar(periodoAcademicoDTO);
		
	}

	@Override
	public void cambiarFechaBaja(PeriodoAcademicoDTO periodoAcademicoDTO) {
		IPeriodoAcademicoDAO periodoAcademicoDAO= daoFactory.obtenerPeriodoAcademicoDAO();
		periodoAcademicoDAO.cambiarFechaBaja(periodoAcademicoDTO);
		
	}

	@Override
	public List<PeriodoAcademicoDTO> consultar(PeriodoAcademicoDTO periodoAcademicoDTO) {
		IPeriodoAcademicoDAO periodoAcademicoDAO= daoFactory.obtenerPeriodoAcademicoDAO();
		return periodoAcademicoDAO.consultar(periodoAcademicoDTO);
		
	}

}
