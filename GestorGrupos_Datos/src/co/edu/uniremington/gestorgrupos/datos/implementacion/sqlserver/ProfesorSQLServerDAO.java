package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IProfesorDAO;
import co.edu.uniremington.gestorgrupos.dto.ProfesorDTO;

public class ProfesorSQLServerDAO implements IProfesorDAO{

	private Connection conexion;
	private final static String NOMBRE_CLASE= "ProfesorSQLServerDAO";	

	public ProfesorSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}
	
	@Override
	public void crear(ProfesorDTO profesorDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(ProfesorDTO profesorDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProfesorDTO> consultar(ProfesorDTO profesorDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cambiarFechaBaja(ProfesorDTO profesorDTO) {
		// TODO Auto-generated method stub
		
	}

}
