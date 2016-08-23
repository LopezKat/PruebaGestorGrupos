package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IPersonaDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.PersonaDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.IPersonaNegocio;

public class PersonaNegocio implements IPersonaNegocio{

	private DAOFactory daoFactory;
	
	public PersonaNegocio(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	
	} 
	
	@Override
	public void crear(PersonaDTO personaDTO) {
		IPersonaDAO personaDAO= daoFactory.obtenerPersonaDAO();
		personaDAO.crear(personaDTO);
		
	}

	@Override
	public void modificar(PersonaDTO personaDTO) {
		IPersonaDAO personaDAO= daoFactory.obtenerPersonaDAO();
		personaDAO.modificar(personaDTO);
		
	}

	@Override
	public void cambiarFechaBaja(PersonaDTO personaDTO) {
		IPersonaDAO personaDAO= daoFactory.obtenerPersonaDAO();
		personaDAO.cambiarFechaBaja(personaDTO);
		
	}

	@Override
	public List<PersonaDTO> consultar(PersonaDTO personaDTO) {
		IPersonaDAO personaDAO= daoFactory.obtenerPersonaDAO();
		return personaDAO.consultar(personaDTO);
		
	}

}
