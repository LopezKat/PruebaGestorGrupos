package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IPensumSemestreDAO;
import co.edu.uniremington.gestorgrupos.dto.PensumSemestreDTO;

public class PensumSemestreSQLServerDAO implements IPensumSemestreDAO{
	
	private Connection conexion;
	private final static String NOMBRE_CLASE= "PensumSemestreSQLServerDAO";	

	public PensumSemestreSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}
	
	@Override
	public void crear(PensumSemestreDTO pensumSemestreDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(PensumSemestreDTO pensumSemestreDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cambiarFechaBaja(PensumSemestreDTO pensumSemestreDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PensumSemestreDTO> consultar(PensumSemestreDTO pensumSemestreDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
