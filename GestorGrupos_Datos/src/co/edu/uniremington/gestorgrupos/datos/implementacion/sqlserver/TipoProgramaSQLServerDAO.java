package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.ITipoProgramaDAO;
import co.edu.uniremington.gestorgrupos.dto.TipoProgramaDTO;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class TipoProgramaSQLServerDAO implements ITipoProgramaDAO {

	private Connection conexion;
	private final static String NOMBRE_CLASE= "TipoProgramaSQLServerDAO";	

	public TipoProgramaSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(TipoProgramaDTO tipoProgramaDTO) {

		StringBuffer sentenciaSQL = new StringBuffer("insert into TBL_TIPO_PROGRAMA (NV_NOMBRE) select ?");
		try (PreparedStatement preparacionSentencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSentencia.setString(1, tipoProgramaDTO.getNombre());

			// Ejecución de setencia
			preparacionSentencia.executeUpdate();

		} catch (SQLException e) {
			
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo tipo de programa con el nombre: "+tipoProgramaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el tipo de programa con el nombre: "+ tipoProgramaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un nuevo tipo de programa con el nombre: "+tipoProgramaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el tipo de programa con el nombre: "+ tipoProgramaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		}
	}

	@Override
	public void modificar(TipoProgramaDTO tipoProgramaDTO) {
		StringBuffer sentenciaSQL = new StringBuffer("update TBL_TIPO_PROGRAMA set (NV_NOMBRE) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setInt(2, tipoProgramaDTO.getCodigo());

			// Ejecución de setencia
			preparacionSetencia.executeUpdate();

		} catch (SQLException e) {
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo tipo de programa con el nombre: "+tipoProgramaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el tipo de programa con el nombre: "+ tipoProgramaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un nuevo tipo de programa con el nombre: "+tipoProgramaDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el tipo de programa con el nombre: "+ tipoProgramaDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			e.printStackTrace();
		}

	}

	@Override
	public void cambiarFechaBaja(TipoProgramaDTO tipoProgramaDTO) {

		StringBuffer setenciaSQL = new StringBuffer("update TBL_TIPO_PROGRAMA set (DA_FECHA_BAJA) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(setenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setDate(1, new Date(tipoProgramaDTO.getFecha_baja().getTime()));

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
	public List<TipoProgramaDTO> consultar(TipoProgramaDTO tipoProgramaDTO) {

		List<Object> listaParametrosConsulta = new ArrayList<Object>();

		List<TipoProgramaDTO> listaRetorno = new ArrayList<TipoProgramaDTO>();

		StringBuffer setenciaSQL = new StringBuffer("SELECT IN_CODIGO, NV_NOMBRE, DA_FECHA_BAJA, NV_ESTADO FORM TBL_TIPO_PROGRAMA");
		boolean colocarwhere = true;

		if (tipoProgramaDTO != null) {
			if (tipoProgramaDTO.getCodigo() != 0) {
				setenciaSQL.append("WHERE IN_CODIGO=?");
				colocarwhere = false;
				listaParametrosConsulta.add(tipoProgramaDTO.getCodigo());
			}
			if (tipoProgramaDTO.getNombre() != null && !"".equals(tipoProgramaDTO.getNombre().trim())) {
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
					TipoProgramaDTO tipoProgramaDTOTemporal = new TipoProgramaDTO();
					tipoProgramaDTOTemporal.setCodigo(cursorResultados.getInt("IN_CODIGO"));
					tipoProgramaDTOTemporal.setNombre(cursorResultados.getString("NV_NOMBRE"));
					tipoProgramaDTOTemporal.setFecha_baja(new java.util.Date(cursorResultados.getDate("DA_FECHA_BAJA").getTime()));
					tipoProgramaDTOTemporal.setEstado(cursorResultados.getString("NV_ESTADO"));

					listaRetorno.add(tipoProgramaDTOTemporal);
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
