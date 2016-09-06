package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IPersonaDAO;
import co.edu.uniremington.gestorgrupos.dto.PersonaDTO;

public class PersonaSQLServerDAO implements IPersonaDAO{

	private Connection conexion;
	private final static String NOMBRE_CLASE= "PersonaSQLServerDAO";	

	public PersonaSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}
	
	@Override
	public void crear(PersonaDTO personaDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(PersonaDTO personaDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PersonaDTO> consultar(PersonaDTO personaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cambiarFechaBaja(PersonaDTO personaDTO) {
		// TODO Auto-generated method stub
		
	}

}
