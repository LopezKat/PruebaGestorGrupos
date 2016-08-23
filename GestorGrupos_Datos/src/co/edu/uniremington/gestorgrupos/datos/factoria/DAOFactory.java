package co.edu.uniremington.gestorgrupos.datos.factoria;

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

public abstract class DAOFactory {

	public abstract void abrirConexion();

	public abstract void cerrarConexion();

	public abstract void iniciarTransaccion();

	public abstract void confirmarTransaccion();

	public abstract void cancelarTransaccion();
	
	public abstract IDiaDAO obtenerDiaDAO();
	
	public abstract IEstudianteGrupoDAO obtenerEstudianteGrupoDAO();
	
	public abstract IEstudianteDAO obtenerEstudianteDAO();
	
	public abstract IGeneroDAO obtenerGeneroDAO();
	
	public abstract IGrupoDAO obtenerGrupoDAO();
	
	public abstract IMateriaDAO obtenerMateriaDAO();
	
	public abstract IMateriaPensumDAO obtenerMateriaPensumDAO();
	
	public abstract INotaEstudianteGrupoDAO obtenerNotaEstudianteGrupoDAO();
	
	public abstract INotaGrupoDAO obtenerNotaGrupoDAO();
	
	public abstract IPensumDAO obtenerPensumDAO();
	
	public abstract IPensumSemestreDAO obtenerPensumSemestreDAO();
	
	public abstract IPeriodoAcademicoDAO obtenerPeriodoAcademicoDAO();
	
	public abstract IPersonaDAO obtenerPersonaDAO();
	
	public abstract IProfesorDAO obtenerProfesorDAO();
	
	public abstract IProgramaDAO obtenerProgramaDAO();
	
	public abstract ISemestreDAO obtenerSemestreDAO();
	
	public abstract ITipoIdentificacionDAO obtenerTipoIdentificacionDAO();
	
	public abstract ITipoNotaDAO obtenerTipoNotaDAO();
	
	public abstract ITipoPeriodoAcademicoDAO obtenerTipoPeriodoAcademicoDAO();
	
	public abstract ITipoProgramaDAO obtenerTipoProgramaDAO();
}
