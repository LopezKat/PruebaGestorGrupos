package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IGeneroDAO;
import co.edu.uniremington.gestorgrupos.dto.GeneroDTO;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class GeneroSQLServerDAO implements IGeneroDAO{
	
	private Connection conexion;
	private final static String NOMBRE_CLASE= "GeneroSQLServerDAO";	
	
	public GeneroSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(GeneroDTO generoDTO) {

		StringBuffer sentenciaSQL = new StringBuffer("insert into TBL_GENERO (NV_NOMBRE) select ?");
		try (PreparedStatement preparacionSentencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSentencia.setString(1, generoDTO.getNombre());

			// Ejecución de setencia
			preparacionSentencia.executeUpdate();

		} catch (SQLException e) {
			
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo genero con el nombre: "+generoDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el genero con el nombre: "+ generoDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un nuevo genero con el nombre: "+generoDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el genero con el nombre: "+ generoDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		}
	}

	@Override
	public void modificar(GeneroDTO generoDTO) {
		StringBuffer sentenciaSQL = new StringBuffer("update TBL_GENERO set (NV_NOMBRE) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setInt(2, generoDTO.getCodigo());

			// Ejecución de setencia
			preparacionSetencia.executeUpdate();

		} catch (SQLException e) {
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo genero con el nombre: "+generoDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el genero con el nombre: "+ generoDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un nuevo genero con el nombre: "+generoDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el genero con el nombre: "+ generoDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			e.printStackTrace();
		}

	}

	@Override
	public void cambiarFechaBaja(GeneroDTO generoDTO) {

		StringBuffer setenciaSQL = new StringBuffer("update TBL_GENERO set (DA_FECHA_BAJA) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(setenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setDate(1, new Date(generoDTO.getFecha_baja().getTime()));

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
	public List<GeneroDTO> consultar(GeneroDTO generoDTO) {

		List<Object> listaParametrosConsulta = new ArrayList<Object>();

		List<GeneroDTO> listaRetorno = new ArrayList<GeneroDTO>();

		StringBuffer setenciaSQL = new StringBuffer("SELECT IN_CODIGO, NV_NOMBRE, DA_FECHA_BAJA, NV_ESTADO FORM TBL_GENERO");
		boolean colocarwhere = true;

		if (generoDTO != null) {
			if (generoDTO.getCodigo() != 0) {
				setenciaSQL.append("WHERE IN_CODIGO=?");
				colocarwhere = false;
				listaParametrosConsulta.add(generoDTO.getCodigo());
			}
			if (generoDTO.getNombre() != null && !"".equals(generoDTO.getNombre().trim())) {
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
					GeneroDTO generoDTOTemporal = new GeneroDTO();
					generoDTOTemporal.setCodigo(cursorResultados.getInt("IN_CODIGO"));
					generoDTOTemporal.setNombre(cursorResultados.getString("NV_NOMBRE"));
					generoDTOTemporal.setFecha_baja(new java.util.Date(cursorResultados.getDate("DA_FECHA_BAJA").getTime()));
					generoDTOTemporal.setEstado(cursorResultados.getString("NV_ESTADO"));

					listaRetorno.add(generoDTOTemporal);
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
