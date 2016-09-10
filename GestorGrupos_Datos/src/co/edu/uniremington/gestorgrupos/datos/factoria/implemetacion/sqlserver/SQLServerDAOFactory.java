package co.edu.uniremington.gestorgrupos.datos.factoria.implemetacion.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uniremington.gestorgrupos.datos.contrato.IDiaDAO;
import co.edu.uniremington.gestorgrupos.datos.contrato.IEstudianteDAO;
import co.edu.uniremington.gestorgrupos.datos.contrato.IEstudianteGrupoDAO;
import co.edu.uniremington.gestorgrupos.datos.contrato.IGeneroDAO;
import co.edu.uniremington.gestorgrupos.datos.contrato.IGrupoDAO;
import co.edu.uniremington.gestorgrupos.datos.contrato.IMateriaDAO;
import co.edu.uniremington.gestorgrupos.datos.contrato.IMateriaPensumDAO;
import co.edu.uniremington.gestorgrupos.datos.contrato.INotaEstudianteGrupoDAO;
import co.edu.uniremington.gestorgrupos.datos.contrato.INotaGrupoDAO;
import co.edu.uniremington.gestorgrupos.datos.contrato.IPensumDAO;
import co.edu.uniremington.gestorgrupos.datos.contrato.IPensumSemestreDAO;
import co.edu.uniremington.gestorgrupos.datos.contrato.IPeriodoAcademicoDAO;
import co.edu.uniremington.gestorgrupos.datos.contrato.IPersonaDAO;
import co.edu.uniremington.gestorgrupos.datos.contrato.IProfesorDAO;
import co.edu.uniremington.gestorgrupos.datos.contrato.IProgramaDAO;
import co.edu.uniremington.gestorgrupos.datos.contrato.ISemestreDAO;
import co.edu.uniremington.gestorgrupos.datos.contrato.ITipoIdentificacionDAO;
import co.edu.uniremington.gestorgrupos.datos.contrato.ITipoNotaDAO;
import co.edu.uniremington.gestorgrupos.datos.contrato.ITipoPeriodoAcademicoDAO;
import co.edu.uniremington.gestorgrupos.datos.contrato.ITipoProgramaDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.DiaSQLServerDAO;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.EstudianteGrupoSQLServerDAO;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.EstudianteSQLServerDAO;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.GeneroSQLServerDAO;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.GrupoSQLServerDAO;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.MateriaPensumSQLServerDAO;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.MateriaSQLServerDAO;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.NotaEstudianteGrupoSQLServerDAO;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.NotaGrupoSQLServerDAO;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.PensumSQLServerDAO;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.PensumSemestreSQLServerDAO;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.PeriodoAcademicoSQLServerDAO;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.PersonaSQLServerDAO;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.ProfesorSQLServerDAO;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.ProgramaSQLServerDAO;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.SemestreSQLServerDAO;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.TipoIdentificacionSQLServerDAO;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.TipoNotaSQLServerDAO;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.TipoPeriodoAcademicoSQLServerDAO;
import co.edu.uniremington.gestorgrupos.datos.implementacion.sqlserver.TipoProgramaSQLServerDAO;
import co.edu.uniremington.gestorgrupos.transversal.excepciones.GestorGruposException;

public class SQLServerDAOFactory extends DAOFactory {

	private Connection conexion;

	public SQLServerDAOFactory() {
		abrirConexion();
	}

	@Override
	protected void abrirConexion() {

		try {

			String urlConexion = "jdbc:sqlserver://%s:%s;databaseName=%s;user=%s;password=%s";

			String servidorBD = "localhost\\sqlexpress";
			String puerto = "1433";
			String nombreBD = "BD_GESTOR_GRUPOS";
			String usuario = "sa";
			String clave = "";

			urlConexion = String.format(urlConexion, servidorBD, puerto, nombreBD, usuario, clave);

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conexion = DriverManager.getConnection(urlConexion);
		} catch (ClassNotFoundException excepcion) {
			String mensajeTecnico = "Se ha presentado problema tratando de ubicar la clase del driver, debido a que no ha sido posible encontrarla.";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!!";
			GestorGruposException.crearExcepcion("DATOS", excepcion, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "abrirConexion");
		} catch (SQLException excepcion) {
			String mensajeTecnico = "Se ha presentado problema tratando de obtener la conexión con la fuente de información.";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!!";
			GestorGruposException.crearExcepcion("DATOS", excepcion, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "abrirConexion");
		} catch (Exception excepcion) {
			String mensajeTecnico = "Se ha presentado problema inesperado.";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!!";
			GestorGruposException.crearExcepcion("DATOS", excepcion, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "abrirConexion");
		}

	}

	@Override
	public void cerrarConexion() {
		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de cerrar la conexión, debido a que ya la conexión está cerrada o no fue inicializada.";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cerrarConexion");
			}

			conexion.close();

		} catch (SQLException excepcion) {
			String mensajeTecnico = "Se ha presentado un problema tratando de cerrar la conexión, debido a que ya la conexión está cerrada o no fue inicializada.";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!!";
			GestorGruposException.crearExcepcion("DATOS", excepcion, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cerrarConexion");
		}
	}

	@Override
	public void iniciarTransaccion() {
		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de iniciar la transacción, debido debido a que la conexión está cerrada o no fue inicializada.";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "iniciarTransaccion");
			}

			conexion.setAutoCommit(false);
		} catch (SQLException excepcion) {
			String mensajeTecnico = "Se ha presentado un problema tratando de iniciar la transacción.";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!!";
			GestorGruposException.crearExcepcion("DATOS", excepcion, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "iniciarTransaccion");
		}
	}

	@Override
	public void confirmarTransaccion() {
		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de confirmar la transacción, debido debido a que la conexión está cerrada o no fue inicializada.";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "confirmarTransaccion");
			}

			conexion.commit();
		} catch (SQLException excepcion) {
			String mensajeTecnico = "Se ha presentado un problema tratando de confirmar la transacción.";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!!";
			GestorGruposException.crearExcepcion("DATOS", excepcion, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "confirmarTransaccion");
		}
	}

	@Override
	public void cancelarTransaccion() {
		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de cancelar la transacción, debido debido a que la conexión está cerrada o no fue inicializada.";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cancelarTransaccion");
			}

			conexion.rollback();
		} catch (SQLException excepcion) {
			String mensajeTecnico = "Se ha presentado un problema tratando de cancelar la transacción.";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!!";
			GestorGruposException.crearExcepcion("DATOS", excepcion, mensajeTecnico, mensajeUsuario, this.getClass().getName(), "cancelarTransaccion");
		}
	}

	@Override
	public IDiaDAO obtenerDiaDAO() {
		
		IDiaDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerDiaDAO");
			}

			dao = new DiaSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerDiaDAO");
		}
		return dao;
	}

	@Override
	public IEstudianteGrupoDAO obtenerEstudianteGrupoDAO() {

		IEstudianteGrupoDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerEstudianteGrupoDAO");
			}

			dao = new EstudianteGrupoSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerEstudianteGrupoDAO");
		}
		return dao;
	}

	@Override
	public IEstudianteDAO obtenerEstudianteDAO() {

		IEstudianteDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerEstudianteDAO");
			}

			dao = new EstudianteSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerEstudianteDAO");
		}
		return dao;
	}

	@Override
	public IGeneroDAO obtenerGeneroDAO() {

		IGeneroDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerGeneroDAO");
			}

			dao = new GeneroSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerGeneroDAO");
		}
		return dao;
	}

	@Override
	public IGrupoDAO obtenerGrupoDAO() {

		IGrupoDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerGrupoDAO");
			}

			dao = new GrupoSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerGrupoDAO");
		}
		return dao;
	}

	@Override
	public IMateriaDAO obtenerMateriaDAO() {

		IMateriaDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerMateriaDAO");
			}

			dao = new MateriaSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerMateriaDAO");
		}
		return dao;
	}

	@Override
	public IMateriaPensumDAO obtenerMateriaPensumDAO() {

		IMateriaPensumDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerMateriaPensumDAO");
			}

			dao = new MateriaPensumSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerMateriaPensumDAO");
		}
		return dao;
	}

	@Override
	public INotaEstudianteGrupoDAO obtenerNotaEstudianteGrupoDAO() {

		INotaEstudianteGrupoDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerNotaEstudianteGrupoDAO");
			}

			dao = new NotaEstudianteGrupoSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerNotaEstudianteGrupoDAO");
		}
		return dao;
	}

	@Override
	public INotaGrupoDAO obtenerNotaGrupoDAO() {

		INotaGrupoDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerNotaGrupoDAO");
			}

			dao = new NotaGrupoSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerNotaGrupoDAO");
		}
		return dao;
	}

	@Override
	public IPensumDAO obtenerPensumDAO() {
		IPensumDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerPensumDAO");
			}

			dao = new PensumSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerPensumDAO");
		}
		return dao;
	}

	@Override
	public IPensumSemestreDAO obtenerPensumSemestreDAO() {

		IPensumSemestreDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerPensumSemestreDAO");
			}

			dao = new PensumSemestreSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerPensumSemestreDAO");
		}
		return dao;
	}

	@Override
	public IPeriodoAcademicoDAO obtenerPeriodoAcademicoDAO() {

		IPeriodoAcademicoDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerPeriodoAcademicoDAO");
			}

			dao = new PeriodoAcademicoSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerPeriodoAcademicoDAO");
		}
		return dao;
	}

	@Override
	public IPersonaDAO obtenerPersonaDAO() {

		IPersonaDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerPersonaDAO");
			}

			dao = new PersonaSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerPersonaDAO");
		}
		return dao;
	}

	@Override
	public IProfesorDAO obtenerProfesorDAO() {

		IProfesorDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerProfesorDAO");
			}

			dao = new ProfesorSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerProfesorDAO");
		}
		return dao;
	}

	@Override
	public IProgramaDAO obtenerProgramaDAO() {
		IProgramaDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerProgramaDAO");
			}

			dao = new ProgramaSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Programa debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerProgramaDAO");
		}
		return dao;
	}

	@Override
	public ISemestreDAO obtenerSemestreDAO() {

		ISemestreDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Semestre debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerSemestreDAO");
			}

			dao = new SemestreSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Semestre debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerSemestreDAO");
		}
		return dao;
	}

	@Override
	public ITipoIdentificacionDAO obtenerTipoIdentificacionDAO() {

		ITipoIdentificacionDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Tipo Identificación debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerTipoIdentificacionDAO");
			}

			dao = new TipoIdentificacionSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Tipo Identificación debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerTipoIdentificacionDAO");
		}
		return dao;
	}

	@Override
	public ITipoNotaDAO obtenerTipoNotaDAO() {

		ITipoNotaDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Tipo Nota debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerTipoNotaDAO");
			}

			dao = new TipoNotaSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Tipo Nota debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerTipoNotaDAO");
		}
		return dao;
	}

	@Override
	public ITipoPeriodoAcademicoDAO obtenerTipoPeriodoAcademicoDAO() {
		ITipoPeriodoAcademicoDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Tipo Periodo Academico debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerTipoPeriodoAcademicoDAO");
			}

			dao = new TipoPeriodoAcademicoSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Tipo Periodo Academico debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerTipoPeriodoAcademicoDAO");
		}
		return dao;
	}

	@Override
	public ITipoProgramaDAO obtenerTipoProgramaDAO() {

		ITipoProgramaDAO dao = null;

		try {
			if (conexion == null || conexion.isClosed()) {
				String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Tipo Programa debido a que la conexión no esta inicializada o cerrada";
				String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
				GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
						this.getClass().getName(), "obtenerTipoProgramaDAO");
			}

			dao = new TipoProgramaSQLServerDAO(conexion);
		} catch (SQLException exception) {
			String mensajeTecnico = "Se ha presentado un problema tratando de obtener el DAO Tipo Programa debido a que la conexión no esta inicializada o cerrada";
			String mensajeUsuario = "Upps!!! Se ha presentado un problema inesperado llevando a cabo la operación actual. Por favor intenta de nuevo!!!";
			GestorGruposException.crearExcepcion("DATOS", null, mensajeTecnico, mensajeUsuario,
					this.getClass().getName(), "obtenerTipoProgramaDAO");
		}
		return dao;
	}

}