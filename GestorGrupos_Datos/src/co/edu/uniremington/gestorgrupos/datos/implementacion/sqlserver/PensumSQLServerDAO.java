package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IPensumDAO;
import co.edu.uniremington.gestorgrupos.dto.PensumDTO;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class PensumSQLServerDAO implements IPensumDAO{

	private Connection conexion;
	private final static String NOMBRE_CLASE= "PensumSQLServerDAO";	

	public PensumSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(PensumDTO pensumDTO) {

		StringBuffer sentenciaSQL = new StringBuffer("insert into TBL_PENSUM (NV_NOMBRE) select ?");
		try (PreparedStatement preparacionSentencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSentencia.setString(1, pensumDTO.getNombre());

			// Ejecución de setencia
			preparacionSentencia.executeUpdate();

		} catch (SQLException e) {
			
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo pensum con el nombre: "+pensumDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el pensum con el nombre: "+ pensumDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un nuevo pensum con el nombre: "+pensumDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el pensum con el nombre: "+ pensumDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		}
	}

	@Override
	public void modificar(PensumDTO pensumDTO) {
		StringBuffer sentenciaSQL = new StringBuffer("update TBL_PENSUM set (NV_NOMBRE) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setInt(2, pensumDTO.getCodigo());

			// Ejecución de setencia
			preparacionSetencia.executeUpdate();

		} catch (SQLException e) {
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo pensum con el nombre: "+pensumDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el pensum con el nombre: "+ pensumDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un nuevo pensum con el nombre: "+pensumDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el pensum con el nombre: "+ pensumDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			e.printStackTrace();
		}

	}

	@Override
	public void cambiarFechaBaja(PensumDTO pensumDTO) {

		StringBuffer setenciaSQL = new StringBuffer("update TBL_PENSUM set (DA_FECHA_BAJA) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(setenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setDate(1, new Date(pensumDTO.getFecha_baja().getTime()));

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
	public List<PensumDTO> consultar(PensumDTO pensumDTO) {

		List<Object> listaParametrosConsulta = new ArrayList<Object>();

		List<PensumDTO> listaRetorno = new ArrayList<PensumDTO>();

		StringBuffer setenciaSQL = new StringBuffer("SELECT IN_CODIGO, NV_NOMBRE, DA_FECHA_BAJA, NV_ESTADO FORM TBL_PENSUM");
		boolean colocarwhere = true;

		if (pensumDTO != null) {
			if (pensumDTO.getCodigo() != 0) {
				setenciaSQL.append("WHERE IN_CODIGO=?");
				colocarwhere = false;
				listaParametrosConsulta.add(pensumDTO.getCodigo());
			}
			if (pensumDTO.getNombre() != null && !"".equals(pensumDTO.getNombre().trim())) {
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
					PensumDTO pensumDTOTemporal = new PensumDTO();
					pensumDTOTemporal.setCodigo(cursorResultados.getInt("IN_CODIGO"));
					pensumDTOTemporal.setNombre(cursorResultados.getString("NV_NOMBRE"));
					pensumDTOTemporal.setFecha_baja(new java.util.Date(cursorResultados.getDate("DA_FECHA_BAJA").getTime()));
					pensumDTOTemporal.setEstado(cursorResultados.getString("NV_ESTADO"));

					listaRetorno.add(pensumDTOTemporal);
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
