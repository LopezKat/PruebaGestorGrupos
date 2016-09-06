package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IPeriodoAcademicoDAO;
import co.edu.uniremington.gestorgrupos.dto.PeriodoAcademicoDTO;

public class PeriodoAcademicoSQLServerDAO implements IPeriodoAcademicoDAO{

	private Connection conexion;
	private final static String NOMBRE_CLASE= "PeriodoAcademicoSQLServerDAO";	

	public PeriodoAcademicoSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}
	
	@Override
	public void crear(PeriodoAcademicoDTO periodoAcademicoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(PeriodoAcademicoDTO periodoAcademicoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cambiarFechaBaja(PeriodoAcademicoDTO periodoAcademicoDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PeriodoAcademicoDTO> consultar(PeriodoAcademicoDTO periodoAcademicoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
