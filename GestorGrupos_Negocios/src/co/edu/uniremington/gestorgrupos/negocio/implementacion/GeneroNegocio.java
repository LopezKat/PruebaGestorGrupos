package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IGeneroDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.GeneroDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IGeneroNegocio;

public class GeneroNegocio implements IGeneroNegocio{

	private DAOFactory daoFactory;
	
	public GeneroNegocio(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	
	} 
	
	@Override
	public void crear(GeneroDTO generoDTO) {
		IGeneroDAO generoDAO= daoFactory.obtenerGeneroDAO();
		generoDAO.crear(generoDTO);
		
	}

	@Override
	public void modificar(GeneroDTO generoDTO) {
		IGeneroDAO generoDAO= daoFactory.obtenerGeneroDAO();
		generoDAO.modificar(generoDTO);
		
	}

	@Override
	public void cambiarFechaBaja(GeneroDTO generoDTO) {
		IGeneroDAO generoDAO= daoFactory.obtenerGeneroDAO();
		generoDAO.cambiarFechaBaja(generoDTO);
		
	}

	@Override
	public List<GeneroDTO> consultar(GeneroDTO generoDTO) {
		IGeneroDAO generoDAO= daoFactory.obtenerGeneroDAO();
		return generoDAO.consultar(generoDTO);
		
	}

}
