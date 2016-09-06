package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IEstudianteGrupoDAO;
import co.edu.uniremington.gestorgrupos.dto.EstudianteGrupoDTO;

public class EstudianteGrupoSQLServerDAO implements IEstudianteGrupoDAO{
	
	private Connection conexion;
	private final static String NOMBRE_CLASE= "EstudianteGrupoSQLServerDAO";	

	public EstudianteGrupoSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(EstudianteGrupoDTO estudianteGrupoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(EstudianteGrupoDTO estudianteGrupoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cambiarFechaBaja(EstudianteGrupoDTO estudianteGrupoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EstudianteGrupoDTO> consultar(EstudianteGrupoDTO estudianteGrupoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
