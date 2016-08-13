package co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.ITipoProgramaDAO;
import co.edu.uniremington.gestorgrupos.dto.TipoProgramaDTO;

public class TipoProgramaSQLServerDAO implements ITipoProgramaDAO {

	private Connection conexion;

	public TipoProgramaSQLServerDAO(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crear(TipoProgramaDTO tipoProgramaDTO) {
		StringBuffer setenciaSQL = new StringBuffer("insert into TBL_TIPO_PROGRAMA (NV_NOMBRE) select ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(setenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setString(1, tipoProgramaDTO.getNombre());

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
	public void modificar(TipoProgramaDTO tipoProgramaDTO) {
		StringBuffer setenciaSQL = new StringBuffer("update TBL_TIPO_PROGRAMA set (NV_NOMBRE) = ? where IN_CODIGO = ?");
		try (PreparedStatement preparacionSetencia = conexion.prepareStatement(setenciaSQL.toString())) {

			// Mapeo de parametros
			preparacionSetencia.setInt(2, tipoProgramaDTO.getCodigo());

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
	public void cambiarFechaBaja(TipoProgramaDTO tipoProgramaDTO) {

		StringBuffer setenciaSQL = new StringBuffer(
				"update TBL_TIPO_PROGRAMA set (DA_FECHA_BAJA) = ? where IN_CODIGO = ?");
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
		StringBuffer setenciaSQL = new StringBuffer(
				"SELECT IN_CODIGO, NV_NOMBRE, DA_FECHA_BAJA, NV_ESTADO FORM TBL_TIPO_PROGRAMA");
		boolean colocarwhere = true;

		if (tipoProgramaDTO != null) {
			if (tipoProgramaDTO.getCodigo() != 0) {
				setenciaSQL.append("WHERE IN_CODIGO=?");
				colocarwhere = false;
			}
			if (tipoProgramaDTO.getNombre() != null && !"".equals(tipoProgramaDTO.getNombre().trim())) {
				setenciaSQL.append(colocarwhere ? "WHERE" : "AND").append("NV_NOMBRE=?");
			}

		}
		setenciaSQL.append("ORDER BY NV_NOMBRE ASC");
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
		return null;
	}

}
