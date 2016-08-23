package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.ITipoPeriodoAcademicoDAO;
import co.edu.uniremington.gestorgrupos.dto.TipoPeriodoAcademicoDTO;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class TipoPeriodoAcademicoSQLServerDAO implements ITipoPeriodoAcademicoDAO{

	private Connection conexion;
	private final static String NOMBRE_CLASE= "TipoPeriodoAcademicoSQLServerDAO";	

	public TipoPeriodoAcademicoSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO) {

		StringBuffer sentenciaSQL = new StringBuffer("insert into TBL_TIPO_PERIODO_ACADEMICO (NV_NOMBRE) select ?");
		try (PreparedStatement preparacionSentencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSentencia.setString(1, tipoPeriodoAcademicoDTO.getNombre());

			// Ejecución de setencia
			preparacionSentencia.executeUpdate();

		} catch (SQLException e) {
			
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo tipoPeriodoAcademico con el nombre: "+tipoPeriodoAcademicoDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el tipoPeriodoAcademico con el nombre: "+ tipoPeriodoAcademicoDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un nuevo tipoPeriodoAcademico con el nombre: "+tipoPeriodoAcademicoDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el tipoPeriodoAcademico con el nombre: "+ tipoPeriodoAcademicoDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		}
	}

	@Override
	public void modificar(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO) {
		StringBuffer sentenciaSQL = new StringBuffer("update TBL_TIPO_PERIODO_ACADEMICO set (NV_NOMBRE) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setInt(2, tipoPeriodoAcademicoDTO.getCodigo());

			// Ejecución de setencia
			preparacionSetencia.executeUpdate();

		} catch (SQLException e) {
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo tipoPeriodoAcademico con el nombre: "+tipoPeriodoAcademicoDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el tipoPeriodoAcademico con el nombre: "+ tipoPeriodoAcademicoDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un nuevo tipoPeriodoAcademico con el nombre: "+tipoPeriodoAcademicoDTO.getNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el tipoPeriodoAcademico con el nombre: "+ tipoPeriodoAcademicoDTO.getNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			e.printStackTrace();
		}

	}

	@Override
	public void cambiarFechaBaja(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO) {

		StringBuffer setenciaSQL = new StringBuffer("update TBL_TIPO_PERIODO_ACADEMICO set (DA_FECHA_BAJA) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(setenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setDate(1, new Date(tipoPeriodoAcademicoDTO.getFecha_baja().getTime()));

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
	public List<TipoPeriodoAcademicoDTO> consultar(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO) {

		List<Object> listaParametrosConsulta = new ArrayList<Object>();

		List<TipoPeriodoAcademicoDTO> listaRetorno = new ArrayList<TipoPeriodoAcademicoDTO>();

		StringBuffer setenciaSQL = new StringBuffer("SELECT IN_CODIGO, NV_NOMBRE, DA_FECHA_BAJA, NV_ESTADO FORM TBL_TIPO_PERIODO_ACADEMICO");
		boolean colocarwhere = true;

		if (tipoPeriodoAcademicoDTO != null) {
			if (tipoPeriodoAcademicoDTO.getCodigo() != 0) {
				setenciaSQL.append("WHERE IN_CODIGO=?");
				colocarwhere = false;
				listaParametrosConsulta.add(tipoPeriodoAcademicoDTO.getCodigo());
			}
			if (tipoPeriodoAcademicoDTO.getNombre() != null && !"".equals(tipoPeriodoAcademicoDTO.getNombre().trim())) {
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
					TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTOTemporal = new TipoPeriodoAcademicoDTO();
					tipoPeriodoAcademicoDTOTemporal.setCodigo(cursorResultados.getInt("IN_CODIGO"));
					tipoPeriodoAcademicoDTOTemporal.setNombre(cursorResultados.getString("NV_NOMBRE"));
					tipoPeriodoAcademicoDTOTemporal.setFecha_baja(new java.util.Date(cursorResultados.getDate("DA_FECHA_BAJA").getTime()));
					tipoPeriodoAcademicoDTOTemporal.setEstado(cursorResultados.getString("NV_ESTADO"));

					listaRetorno.add(tipoPeriodoAcademicoDTOTemporal);
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
