package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.ITipoNotaDAO;
import co.edu.uniremington.gestorgrupos.dto.TipoNotaDTO;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class TipoNotaSQLServerDAO implements ITipoNotaDAO{

	private Connection conexion;
	private final static String NOMBRE_CLASE= "TipoNotaSQLServerDAO";	

	public TipoNotaSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(TipoNotaDTO tipoNotaDTO) {

		StringBuffer sentenciaSQL = new StringBuffer("insert into TBL_TIPO_NOTA (NV_NOMBRE) select ?");
		try (PreparedStatement preparacionSentencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSentencia.setString(1, tipoNotaDTO.getNombre());

			// Ejecución de setencia
			preparacionSentencia.executeUpdate();

		} catch (SQLException e) {
			
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo tipoNota con el nombre: "+tipoNotaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el tipoNota con el nombre: "+ tipoNotaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un nuevo tipoNota con el nombre: "+tipoNotaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el tipoNota con el nombre: "+ tipoNotaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		}
	}

	@Override
	public void modificar(TipoNotaDTO tipoNotaDTO) {
		StringBuffer sentenciaSQL = new StringBuffer("update TBL_TIPO_NOTA set (NV_NOMBRE) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setInt(2, tipoNotaDTO.getCodigo());

			// Ejecución de setencia
			preparacionSetencia.executeUpdate();

		} catch (SQLException e) {
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo tipoNota con el nombre: "+tipoNotaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el tipoNota con el nombre: "+ tipoNotaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un nuevo tipoNota con el nombre: "+tipoNotaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el tipoNota con el nombre: "+ tipoNotaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			e.printStackTrace();
		}

	}

	@Override
	public void cambiarFechaBaja(TipoNotaDTO tipoNotaDTO) {

		StringBuffer setenciaSQL = new StringBuffer("update TBL_TIPO_NOTA set (DA_FECHA_BAJA) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(setenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setDate(1, new Date(tipoNotaDTO.getFecha_baja().getTime()));

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
	public List<TipoNotaDTO> consultar(TipoNotaDTO tipoNotaDTO) {

		List<Object> listaParametrosConsulta = new ArrayList<Object>();

		List<TipoNotaDTO> listaRetorno = new ArrayList<TipoNotaDTO>();

		StringBuffer setenciaSQL = new StringBuffer("SELECT IN_CODIGO, NV_NOMBRE, DA_FECHA_BAJA, NV_ESTADO FORM TBL_TIPO_NOTA");
		boolean colocarwhere = true;

		if (tipoNotaDTO != null) {
			if (tipoNotaDTO.getCodigo() != 0) {
				setenciaSQL.append("WHERE IN_CODIGO=?");
				colocarwhere = false;
				listaParametrosConsulta.add(tipoNotaDTO.getCodigo());
			}
			if (tipoNotaDTO.getNombre() != null && !"".equals(tipoNotaDTO.getNombre().trim())) {
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
					TipoNotaDTO tipoNotaDTOTemporal = new TipoNotaDTO();
					tipoNotaDTOTemporal.setCodigo(cursorResultados.getInt("IN_CODIGO"));
					tipoNotaDTOTemporal.setNombre(cursorResultados.getString("NV_NOMBRE"));
					tipoNotaDTOTemporal.setFecha_baja(new java.util.Date(cursorResultados.getDate("DA_FECHA_BAJA").getTime()));
					tipoNotaDTOTemporal.setEstado(cursorResultados.getString("NV_ESTADO"));

					listaRetorno.add(tipoNotaDTOTemporal);
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
