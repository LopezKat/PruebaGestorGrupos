package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IDiaDAO;
import co.edu.uniremington.gestorgrupos.dto.DiaDTO;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class DiaSQLServerDAO implements IDiaDAO{

	private Connection conexion;
	private final static String NOMBRE_CLASE= "DiaSQLServerDAO";	

	public DiaSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(DiaDTO diaDTO) {

		StringBuffer sentenciaSQL = new StringBuffer("insert into TBL_DIA (NV_NOMBRE) select ?");
		try (PreparedStatement preparacionSentencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSentencia.setString(1, diaDTO.getNombre());

			// Ejecución de setencia
			preparacionSentencia.executeUpdate();

		} catch (SQLException e) {
			
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo dia con el nombre: "+diaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el dia con el nombre: "+ diaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un nuevo dia con el nombre: "+diaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el dia con el nombre: "+ diaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		}
	}

	@Override
	public void modificar(DiaDTO diaDTO) {
		StringBuffer sentenciaSQL = new StringBuffer("update TBL_DIA set (NV_NOMBRE) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setInt(2, diaDTO.getCodigo());

			// Ejecución de setencia
			preparacionSetencia.executeUpdate();

		} catch (SQLException e) {
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo dia con el nombre: "+diaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el dia con el nombre: "+ diaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un nuevo dia con el nombre: "+diaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el dia con el nombre: "+ diaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			e.printStackTrace();
		}

	}

	@Override
	public void cambiarFechaBaja(DiaDTO diaDTO) {

		StringBuffer setenciaSQL = new StringBuffer("update TBL_DIA set (DA_FECHA_BAJA) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(setenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setDate(1, new Date(diaDTO.getFecha_baja().getTime()));

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
	public List<DiaDTO> consultar(DiaDTO diaDTO) {

		List<Object> listaParametrosConsulta = new ArrayList<Object>();

		List<DiaDTO> listaRetorno = new ArrayList<DiaDTO>();

		StringBuffer setenciaSQL = new StringBuffer("SELECT IN_CODIGO, NV_NOMBRE, DA_FECHA_BAJA, NV_ESTADO FORM TBL_DIA");
		boolean colocarwhere = true;

		if (diaDTO != null) {
			if (diaDTO.getCodigo() != 0) {
				setenciaSQL.append("WHERE IN_CODIGO=?");
				colocarwhere = false;
				listaParametrosConsulta.add(diaDTO.getCodigo());
			}
			if (diaDTO.getNombre() != null && !"".equals(diaDTO.getNombre().trim())) {
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
					DiaDTO diaDTOTemporal = new DiaDTO();
					diaDTOTemporal.setCodigo(cursorResultados.getInt("IN_CODIGO"));
					diaDTOTemporal.setNombre(cursorResultados.getString("NV_NOMBRE"));
					diaDTOTemporal.setFecha_baja(new java.util.Date(cursorResultados.getDate("DA_FECHA_BAJA").getTime()));
					diaDTOTemporal.setEstado(cursorResultados.getString("NV_ESTADO"));

					listaRetorno.add(diaDTOTemporal);
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
