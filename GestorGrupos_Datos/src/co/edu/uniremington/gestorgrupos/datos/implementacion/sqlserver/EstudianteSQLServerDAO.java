package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.IEstudianteDAO;
import co.edu.uniremington.gestorgrupos.dto.EstudianteDTO;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class EstudianteSQLServerDAO implements IEstudianteDAO{

	private Connection conexion;
	private final static String NOMBRE_CLASE= "EstudianteSQLServerDAO";	

	public EstudianteSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(EstudianteDTO estudianteDTO) {

		StringBuffer sentenciaSQL = new StringBuffer("insert into TBL_ESTUDIANTE (NV_NOMBRE) select ?");
		try (PreparedStatement preparacionSentencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSentencia.setString(1, estudianteDTO.getPersona().getPrimerNombre());

			// Ejecución de setencia
			preparacionSentencia.executeUpdate();

		} catch (SQLException e) {
			
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo estudiante con el nombre: "+estudianteDTO.getPersona().getPrimerNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el estudianteD con el nombre: "+ estudianteDTO.getPersona().getPrimerNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un estudiante con el nombre: "+estudianteDTO.getPersona().getPrimerNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el estudianteD con el nombre: "+ estudianteDTO.getPersona().getPrimerNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		}
	}

	@Override
	public void modificar(EstudianteDTO estudianteDTO) {
		StringBuffer sentenciaSQL = new StringBuffer("update TBL_ESTUDIANTE set (NV_NOMBRE) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(sentenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setInt(2, estudianteDTO.getCodigo());

			// Ejecución de setencia
			preparacionSetencia.executeUpdate();

		} catch (SQLException e) {
			String mensajeTecnico="Se ha presentado un problema tratando de registrar un nuevo estudiante con el nombre: "+estudianteDTO.getPersona().getPrimerNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el estudianteD con el nombre: "+ estudianteDTO.getPersona().getPrimerNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			
			e.printStackTrace();
		} catch (Exception e) {
			
			String mensajeTecnico="Se ha presentado un problema no esperado tratando de registrar un estudiante con el nombre: "+estudianteDTO.getPersona().getPrimerNombre();
			String mensajeUsuario="Upps!!! No hemos logrado registrar el estudianteD con el nombre: "+ estudianteDTO.getPersona().getPrimerNombre()+". Por favor intenta de nuevo";
			
			GestorGruposException.crearExcepcion(NOMBRE_CLASE, e, mensajeTecnico, mensajeUsuario, NOMBRE_CLASE, "crear");
			e.printStackTrace();
		}

	}

	@Override
	public void cambiarFechaBaja(EstudianteDTO estudianteDTO) {

		StringBuffer setenciaSQL = new StringBuffer("update TBL_ESTUDIANTE set (DA_FECHA_BAJA) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(setenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setDate(1, new Date(estudianteDTO.getFecha_baja().getTime()));

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
	public List<EstudianteDTO> consultar(EstudianteDTO estudianteDTO) {

		List<Object> listaParametrosConsulta = new ArrayList<Object>();

		List<EstudianteDTO> listaRetorno = new ArrayList<EstudianteDTO>();

		StringBuffer setenciaSQL = new StringBuffer("SELECT IN_CODIGO, NV_NOMBRE, DA_FECHA_BAJA, NV_ESTADO FORM TBL_ESTUDIANTE");
		boolean colocarwhere = true;

		if (estudianteDTO != null) {
			if (estudianteDTO.getCodigo() != 0) {
				setenciaSQL.append("WHERE IN_CODIGO=?");
				colocarwhere = false;
				listaParametrosConsulta.add(estudianteDTO.getCodigo());
			}
			if (estudianteDTO.getPersona().getPrimerNombre() != null && !"".equals(estudianteDTO.getPersona().getPrimerNombre().trim())) {
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
					EstudianteDTO estudianteDTOTemporal = new EstudianteDTO();
					estudianteDTOTemporal.setCodigo(cursorResultados.getInt("IN_CODIGO"));
					//TODO consultar el primer nombre
					//estudianteDTOTemporal.setPersona()(cursorResultados.getString("NV_NOMBRE"));
					estudianteDTOTemporal.setFecha_baja(new java.util.Date(cursorResultados.getDate("DA_FECHA_BAJA").getTime()));
					estudianteDTOTemporal.setEstado(cursorResultados.getString("NV_ESTADO"));

					listaRetorno.add(estudianteDTOTemporal);
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
