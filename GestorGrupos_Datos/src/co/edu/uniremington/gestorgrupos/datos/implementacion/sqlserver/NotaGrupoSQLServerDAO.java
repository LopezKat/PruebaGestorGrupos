package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.INotaGrupoDAO;
import co.edu.uniremington.gestorgrupos.dto.NotaGrupoDTO;

public class NotaGrupoSQLServerDAO implements INotaGrupoDAO{

	private Connection conexion;
	private final static String NOMBRE_CLASE= "NotaGrupoSQLServerDAO";	

	public NotaGrupoSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}
	
	@Override
	public void crear(NotaGrupoDTO notaGrupoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(NotaGrupoDTO notaGrupoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cambiarFechaBaja(NotaGrupoDTO notaGrupoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NotaGrupoDTO> consultar(NotaGrupoDTO notaGrupoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
