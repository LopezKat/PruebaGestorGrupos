package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.INotaEstudianteGrupoDAO;
import co.edu.uniremington.gestorgrupos.dto.NotaEstudianteGrupoDTO;

public class NotaEstudianteGrupoSQLServerDAO implements INotaEstudianteGrupoDAO{

	private Connection conexion;
	private final static String NOMBRE_CLASE= "NotaEstudianteGrupoSQLServerDAO";	

	public NotaEstudianteGrupoSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}
	
	@Override
	public void crear(NotaEstudianteGrupoDTO notaEstudianteGrupoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(NotaEstudianteGrupoDTO notaEstudianteGrupoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cambiarFechaBaja(NotaEstudianteGrupoDTO notaEstudianteGrupoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NotaEstudianteGrupoDTO> consultar(NotaEstudianteGrupoDTO notaEstudianteGrupoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
