package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IProgramaDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.ProgramaDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IProgramaNegocio;

public class ProgramaNegocio implements IProgramaNegocio{

	private DAOFactory daoFactory;
	
	public ProgramaNegocio(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	
	} 
	
	@Override
	public void crear(ProgramaDTO programaDTO) {
		IProgramaDAO programaDAO= daoFactory.obtenerProgramaDAO();
		programaDAO.crear(programaDTO);
		
	}

	@Override
	public void modificar(ProgramaDTO programaDTO) {
		IProgramaDAO programaDAO= daoFactory.obtenerProgramaDAO();
		programaDAO.modificar(programaDTO);
		
	}

	@Override
	public void cambiarFechaBaja(ProgramaDTO programaDTO) {
		IProgramaDAO programaDAO= daoFactory.obtenerProgramaDAO();
		programaDAO.cambiarFechaBaja(programaDTO);
		
	}

	@Override
	public List<ProgramaDTO> consultar(ProgramaDTO programaDTO) {
		IProgramaDAO programaDAO= daoFactory.obtenerProgramaDAO();
		return programaDAO.consultar(programaDTO);
		
	}

}
