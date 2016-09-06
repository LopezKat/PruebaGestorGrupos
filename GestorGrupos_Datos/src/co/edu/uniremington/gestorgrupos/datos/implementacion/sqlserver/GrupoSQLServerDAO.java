package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IGrupoDAO;
import co.edu.uniremington.gestorgrupos.dto.GrupoDTO;

public class GrupoSQLServerDAO implements IGrupoDAO{

	private Connection conexion;
	private final static String NOMBRE_CLASE= "GrupoSQLServerDAO";	

	public GrupoSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}
	
	@Override
	public void crear(GrupoDTO grupoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(GrupoDTO grupoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cambiarFechaBaja(GrupoDTO grupoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GrupoDTO> consultar(GrupoDTO grupoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
