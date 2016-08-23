package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.ISemestreDAO;
import co.edu.uniremington.gestorgrupos.dto.SemestreDTO;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class SemestreSQLServerDAO implements ISemestreDAO{

	private Connection conexion;
	private final static String NOMBRE_CLASE= "SemestreSQLServerDAO";	

	public SemestreSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(SemestreDTO semestreDTO) {

		StringBuffer sentenciaSQL = new StringBuffer("insert into TBL_SEMESTRE (NV_NOMBRE) select ?");
		try (PreparedStatement preparacionSentencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSentencia.setString(1, semestreDTO.getNombre());

			// Ejecución de setencia
			preparacionSentencia.executeUpdate();

		} catch (SQLException e) {
			
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo semestre con el nombre: "+semestreDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el semestre con el nombre: "+ semestreDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un nuevo semestre con el nombre: "+semestreDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el semestre con el nombre: "+ semestreDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		}
	}

	@Override
	public void modificar(SemestreDTO semestreDTO) {
		StringBuffer sentenciaSQL = new StringBuffer("update TBL_SEMESTRE set (NV_NOMBRE) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setInt(2, semestreDTO.getCodigo());

			// Ejecución de setencia
			preparacionSetencia.executeUpdate();

		} catch (SQLException e) {
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo semestre con el nombre: "+semestreDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el semestre con el nombre: "+ semestreDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un nuevo semestre con el nombre: "+semestreDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el semestre con el nombre: "+ semestreDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			e.printStackTrace();
		}

	}

	@Override
	public void cambiarFechaBaja(SemestreDTO semestreDTO) {

		StringBuffer setenciaSQL = new StringBuffer("update TBL_semestre set (DA_FECHA_BAJA) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(setenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setDate(1, new Date(semestreDTO.getFecha_baja().getTime()));

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
	public List<SemestreDTO> consultar(SemestreDTO semestreDTO) {

		List<Object> listaParametrosConsulta = new ArrayList<Object>();

		List<SemestreDTO> listaRetorno = new ArrayList<SemestreDTO>();

		StringBuffer setenciaSQL = new StringBuffer("SELECT IN_CODIGO, NV_NOMBRE, DA_FECHA_BAJA, NV_ESTADO FORM TBL_SEMESTRE");
		boolean colocarwhere = true;

		if (semestreDTO != null) {
			if (semestreDTO.getCodigo() != 0) {
				setenciaSQL.append("WHERE IN_CODIGO=?");
				colocarwhere = false;
				listaParametrosConsulta.add(semestreDTO.getCodigo());
			}
			if (semestreDTO.getNombre() != null && !"".equals(semestreDTO.getNombre().trim())) {
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
					SemestreDTO semestreDTOTemporal = new SemestreDTO();
					semestreDTOTemporal.setCodigo(cursorResultados.getInt("IN_CODIGO"));
					semestreDTOTemporal.setNombre(cursorResultados.getString("NV_NOMBRE"));
					semestreDTOTemporal.setFecha_baja(new java.util.Date(cursorResultados.getDate("DA_FECHA_BAJA").getTime()));
					semestreDTOTemporal.setEstado(cursorResultados.getString("NV_ESTADO"));

					listaRetorno.add(semestreDTOTemporal);
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
