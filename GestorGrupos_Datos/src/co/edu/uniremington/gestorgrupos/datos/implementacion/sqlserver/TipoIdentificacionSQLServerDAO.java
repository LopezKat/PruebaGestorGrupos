package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.ITipoIdentificacionDAO;
import co.edu.uniremington.gestorgrupos.dto.TipoIdentificacionDTO;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class TipoIdentificacionSQLServerDAO implements ITipoIdentificacionDAO{

	private Connection conexion;
	private final static String NOMBRE_CLASE= "TipoIdentificacionSQLServerDAO";	

	public TipoIdentificacionSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(TipoIdentificacionDTO tipoIdentificacionDTO) {

		StringBuffer sentenciaSQL = new StringBuffer("insert into TBL_TIPO_IDENTIFICACION (NV_NOMBRE) select ?");
		try (PreparedStatement preparacionSentencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSentencia.setString(1, tipoIdentificacionDTO.getNombre());

			// Ejecución de setencia
			preparacionSentencia.executeUpdate();

		} catch (SQLException e) {
			
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo tipoIdentificacion con el nombre: "+tipoIdentificacionDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el tipoIdentificacion con el nombre: "+ tipoIdentificacionDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un nuevo tipoIdentificacion con el nombre: "+tipoIdentificacionDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el tipoIdentificacion con el nombre: "+ tipoIdentificacionDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		}
	}

	@Override
	public void modificar(TipoIdentificacionDTO tipoIdentificacionDTO) {
		StringBuffer sentenciaSQL = new StringBuffer("update TBL_TIPO_IDENTIFICACION set (NV_NOMBRE) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setInt(2, tipoIdentificacionDTO.getCodigo());

			// Ejecución de setencia
			preparacionSetencia.executeUpdate();

		} catch (SQLException e) {
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo tipoIdentificacion con el nombre: "+tipoIdentificacionDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el tipoIdentificacion con el nombre: "+ tipoIdentificacionDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un nuevo tipoIdentificacion con el nombre: "+tipoIdentificacionDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el tipoIdentificacion con el nombre: "+ tipoIdentificacionDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			e.printStackTrace();
		}

	}

	@Override
	public void cambiarFechaBaja(TipoIdentificacionDTO tipoIdentificacionDTO) {

		StringBuffer setenciaSQL = new StringBuffer("update TBL_TIPO_IDENTIFICACION set (DA_FECHA_BAJA) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(setenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setDate(1, new Date(tipoIdentificacionDTO.getFecha_baja().getTime()));

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
	public List<TipoIdentificacionDTO> consultar(TipoIdentificacionDTO tipoIdentificacionDTO) {

		List<Object> listaParametrosConsulta = new ArrayList<Object>();

		List<TipoIdentificacionDTO> listaRetorno = new ArrayList<TipoIdentificacionDTO>();

		StringBuffer setenciaSQL = new StringBuffer("SELECT IN_CODIGO, NV_NOMBRE, DA_FECHA_BAJA, NV_ESTADO FORM TBL_TIPO_IDENTIFICACION");
		boolean colocarwhere = true;

		if (tipoIdentificacionDTO != null) {
			if (tipoIdentificacionDTO.getCodigo() != 0) {
				setenciaSQL.append("WHERE IN_CODIGO=?");
				colocarwhere = false;
				listaParametrosConsulta.add(tipoIdentificacionDTO.getCodigo());
			}
			if (tipoIdentificacionDTO.getNombre() != null && !"".equals(tipoIdentificacionDTO.getNombre().trim())) {
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
					TipoIdentificacionDTO tipoIdentificacionDTOTemporal = new TipoIdentificacionDTO();
					tipoIdentificacionDTOTemporal.setCodigo(cursorResultados.getInt("IN_CODIGO"));
					tipoIdentificacionDTOTemporal.setNombre(cursorResultados.getString("NV_NOMBRE"));
					tipoIdentificacionDTOTemporal.setFecha_baja(new java.util.Date(cursorResultados.getDate("DA_FECHA_BAJA").getTime()));
					tipoIdentificacionDTOTemporal.setEstado(cursorResultados.getString("NV_ESTADO"));

					listaRetorno.add(tipoIdentificacionDTOTemporal);
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
