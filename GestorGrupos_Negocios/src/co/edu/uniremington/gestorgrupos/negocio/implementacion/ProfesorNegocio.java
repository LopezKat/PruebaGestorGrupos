package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IProfesorDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.ProfesorDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IProfesorNegocio;

public class ProfesorNegocio implements IProfesorNegocio{

	private DAOFactory daoFactory;
	
	public ProfesorNegocio(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	
	} 
	
	@Override
	public void crear(ProfesorDTO profesorDTO) {
		IProfesorDAO profesorDAO= daoFactory.obtenerProfesorDAO();
		profesorDAO.crear(profesorDTO);
		
	}

	@Override
	public void modificar(ProfesorDTO profesorDTO) {
		IProfesorDAO profesorDAO= daoFactory.obtenerProfesorDAO();
		profesorDAO.modificar(profesorDTO);
		
	}

	@Override
	public void cambiarFechaBaja(ProfesorDTO profesorDTO) {
		IProfesorDAO profesorDAO= daoFactory.obtenerProfesorDAO();
		profesorDAO.cambiarFechaBaja(profesorDTO);
		
	}

	@Override
	public List<ProfesorDTO> consultar(ProfesorDTO profesorDTO) {
		IProfesorDAO profesorDAO= daoFactory.obtenerProfesorDAO();
		return profesorDAO.consultar(profesorDTO);
		
	}

}
