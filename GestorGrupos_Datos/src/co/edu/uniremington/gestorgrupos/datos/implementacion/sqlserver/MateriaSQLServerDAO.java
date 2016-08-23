package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IMateriaDAO;
import co.edu.uniremington.gestorgrupos.dto.MateriaDTO;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class MateriaSQLServerDAO implements IMateriaDAO{

	private Connection conexion;
	private final static String NOMBRE_CLASE= "MateriaSQLServerDAO";	

	public MateriaSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(MateriaDTO materiaDTO) {

		StringBuffer sentenciaSQL = new StringBuffer("insert into TBL_MATERIA (NV_NOMBRE) select ?");
		try (PreparedStatement preparacionSentencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSentencia.setString(1, materiaDTO.getNombre());

			// Ejecución de setencia
			preparacionSentencia.executeUpdate();

		} catch (SQLException e) {
			
			String mensajeTecnico="Se ha presentado un problema tratando de registrar una nueva materia con el nombre: "+materiaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar la materia con el nombre: "+ materiaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar una nuevo materia con el nombre: "+materiaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar la materia con el nombre: "+ materiaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		}
	}

	@Override
	public void modificar(MateriaDTO materiaDTO) {
		StringBuffer sentenciaSQL = new StringBuffer("update TBL_MATERIA set (NV_NOMBRE) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setInt(2, materiaDTO.getCodigo());

			// Ejecución de setencia
			preparacionSetencia.executeUpdate();

		} catch (SQLException e) {
			String mensajeTecnico="Se ha presentado un problema tratando de registrar una nueva materia con el nombre: "+materiaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar la materia con el nombre: "+ materiaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar una nueva materia con el nombre: "+materiaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar la materia con el nombre: "+ materiaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			e.printStackTrace();
		}

	}

	@Override
	public void cambiarFechaBaja(MateriaDTO materiaDTO) {

		StringBuffer setenciaSQL = new StringBuffer("update TBL_MATERIA set (DA_FECHA_BAJA) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(setenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setDate(1, new Date(materiaDTO.getFecha_baja().getTime()));

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
	public List<MateriaDTO> consultar(MateriaDTO materiaDTO) {

		List<Object> listaParametrosConsulta = new ArrayList<Object>();

		List<MateriaDTO> listaRetorno = new ArrayList<MateriaDTO>();

		StringBuffer setenciaSQL = new StringBuffer("SELECT IN_CODIGO, NV_NOMBRE, DA_FECHA_BAJA, NV_ESTADO FORM TBL_MATERIA");
		boolean colocarwhere = true;

		if (materiaDTO != null) {
			if (materiaDTO.getCodigo() != 0) {
				setenciaSQL.append("WHERE IN_CODIGO=?");
				colocarwhere = false;
				listaParametrosConsulta.add(materiaDTO.getCodigo());
			}
			if (materiaDTO.getNombre() != null && !"".equals(materiaDTO.getNombre().trim())) {
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
					MateriaDTO materiaDTOTemporal = new MateriaDTO();
					materiaDTOTemporal.setCodigo(cursorResultados.getInt("IN_CODIGO"));
					materiaDTOTemporal.setNombre(cursorResultados.getString("NV_NOMBRE"));
					materiaDTOTemporal.setFecha_baja(new java.util.Date(cursorResultados.getDate("DA_FECHA_BAJA").getTime()));
					materiaDTOTemporal.setEstado(cursorResultados.getString("NV_ESTADO"));

					listaRetorno.add(materiaDTOTemporal);
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
