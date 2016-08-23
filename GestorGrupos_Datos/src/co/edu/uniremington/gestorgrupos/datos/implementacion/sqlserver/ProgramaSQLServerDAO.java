package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IProgramaDAO;
import co.edu.uniremington.gestorgrupos.dto.ProgramaDTO;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class ProgramaSQLServerDAO implements IProgramaDAO{

	private Connection conexion;
	private final static String NOMBRE_CLASE= "ProgramaSQLServerDAO";	

	public ProgramaSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(ProgramaDTO programaDTO) {

		StringBuffer sentenciaSQL = new StringBuffer("insert into TBL_PROGRAMA (NV_NOMBRE) select ?");
		try (PreparedStatement preparacionSentencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSentencia.setString(1, programaDTO.getNombre());

			// Ejecución de setencia
			preparacionSentencia.executeUpdate();

		} catch (SQLException e) {
			
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo programa con el nombre: "+programaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el programa con el nombre: "+ programaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un nuevo programa con el nombre: "+programaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el programa con el nombre: "+ programaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		}
	}

	@Override
	public void modificar(ProgramaDTO programaDTO) {
		StringBuffer sentenciaSQL = new StringBuffer("update TBL_PROGRAMA set (NV_NOMBRE) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setInt(2, programaDTO.getCodigo());

			// Ejecución de setencia
			preparacionSetencia.executeUpdate();

		} catch (SQLException e) {
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo programa con el nombre: "+programaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el programa con el nombre: "+ programaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un nuevo programa con el nombre: "+programaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el programa con el nombre: "+ programaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			e.printStackTrace();
		}

	}

	@Override
	public void cambiarFechaBaja(ProgramaDTO programaDTO) {

		StringBuffer setenciaSQL = new StringBuffer("update TBL_PROGRAMA set (DA_FECHA_BAJA) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(setenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setDate(1, new Date(programaDTO.getFecha_Baja().getTime()));

			// Ejecución de setencia
			preparacionSetencia.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<ProgramaDTO> consultar(ProgramaDTO programaDTO) {

		List<Object> listaParametrosConsulta = new ArrayList<Object>();

		List<ProgramaDTO> listaRetorno = new ArrayList<ProgramaDTO>();

		StringBuffer setenciaSQL = new StringBuffer("SELECT IN_CODIGO, NV_NOMBRE, DA_FECHA_BAJA, NV_ESTADO FORM TBL_PROGRAMA");
		boolean colocarwhere = true;

		if (programaDTO != null) {
			if (programaDTO.getCodigo() != 0) {
				setenciaSQL.append("WHERE IN_CODIGO=?");
				colocarwhere = false;
				listaParametrosConsulta.add(programaDTO.getCodigo());
			}
			if (programaDTO.getNombre() != null && !"".equals(programaDTO.getNombre().trim())) {
				setenciaSQL.append(colocarwhere ? "WHERE" : "AND").append("NV_NOMBRE=?");
			}

		}
		setenciaSQL.append("ORDER BY NV_NOMBRE ASC");

		try (PreparedStatement preparacionSentencia = conexion.prepareStatement(setenciaSQL.toString())) {

			// Mapeo de parametros
			for (int indice = 0; indice < listaParametrosConsulta.size(); indice++) {
				preparacionSentencia.setObject(indice + 1, listaParametrosConsulta.get(indice));
			}

			try (ResultSet cursorResultados = preparacionSentencia.executeQuery()) {

				while (cursorResultados.next()) {
					ProgramaDTO programaDTOTemporal = new ProgramaDTO();
					programaDTOTemporal.setCodigo(cursorResultados.getInt("IN_CODIGO"));
					programaDTOTemporal.setNombre(cursorResultados.getString("NV_NOMBRE"));
					programaDTOTemporal.setFecha_Baja(new java.util.Date(cursorResultados.getDate("DA_FECHA_BAJA").getTime()));
					programaDTOTemporal.setEstado(cursorResultados.getString("NV_ESTADO"));

					listaRetorno.add(programaDTOTemporal);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
