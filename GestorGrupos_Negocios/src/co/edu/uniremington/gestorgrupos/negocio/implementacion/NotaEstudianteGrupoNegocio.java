package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.INotaEstudianteGrupoDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.NotaEstudianteGrupoDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.INotaEstudianteGrupoNegocio;

public class NotaEstudianteGrupoNegocio implements INotaEstudianteGrupoNegocio{

	private DAOFactory daoFactory;
	
	public NotaEstudianteGrupoNegocio(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	
	} 
	
	@Override
	public void crear(NotaEstudianteGrupoDTO notaEstudianteGrupoDTO) {
		INotaEstudianteGrupoDAO notaEstudianteGrupoDAO= daoFactory.obtenerNotaEstudianteGrupoDAO();
		notaEstudianteGrupoDAO.crear(notaEstudianteGrupoDTO);
		
	}

	@Override
	public void modificar(NotaEstudianteGrupoDTO notaEstudianteGrupoDTO) {
		INotaEstudianteGrupoDAO notaEstudianteGrupoDAO= daoFactory.obtenerNotaEstudianteGrupoDAO();
		notaEstudianteGrupoDAO.modificar(notaEstudianteGrupoDTO);
		
	}

	@Override
	public void cambiarFechaBaja(NotaEstudianteGrupoDTO notaEstudianteGrupoDTO) {
		INotaEstudianteGrupoDAO notaEstudianteGrupoDAO= daoFactory.obtenerNotaEstudianteGrupoDAO();
		notaEstudianteGrupoDAO.cambiarFechaBaja(notaEstudianteGrupoDTO);
		
	}

	@Override
	public List<NotaEstudianteGrupoDTO> consultar(NotaEstudianteGrupoDTO notaEstudianteGrupoDTO) {
		INotaEstudianteGrupoDAO notaEstudianteGrupoDAO= daoFactory.obtenerNotaEstudianteGrupoDAO();
		return notaEstudianteGrupoDAO.consultar(notaEstudianteGrupoDTO);
		
	}

}
