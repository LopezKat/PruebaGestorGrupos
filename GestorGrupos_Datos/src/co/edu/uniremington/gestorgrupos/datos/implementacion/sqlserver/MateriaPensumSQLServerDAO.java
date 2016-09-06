package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IMateriaPensumDAO;
import co.edu.uniremington.gestorgrupos.dto.MateriaPensumDTO;

public class MateriaPensumSQLServerDAO implements IMateriaPensumDAO{
	
	private Connection conexion;
	private final static String NOMBRE_CLASE= "MateriaPensumSQLServerDAO";	

	public MateriaPensumSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(MateriaPensumDTO materiaPensumDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(MateriaPensumDTO materiaPensumDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cambiarFechaBaja(MateriaPensumDTO materiaPensumDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MateriaPensumDTO> consultar(MateriaPensumDTO materiaPensumDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
