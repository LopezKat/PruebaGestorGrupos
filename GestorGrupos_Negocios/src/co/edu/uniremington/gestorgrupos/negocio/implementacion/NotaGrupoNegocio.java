package co.edu.uniremington.gestorgrupos.negocio.implementacion;

import java.util.List;

import co.edu.uniremington.gestorgrupos.datos.contrato.INotaGrupoDAO;
import co.edu.uniremington.gestorgrupos.datos.factoria.DAOFactory;
import co.edu.uniremington.gestorgrupos.dto.NotaGrupoDTO;
import co.edu.uniremington.gestorgrupos.negocio.contrato.INotaGrupoNegocio;

public class NotaGrupoNegocio implements INotaGrupoNegocio{

	private DAOFactory daoFactory;
	
	public NotaGrupoNegocio(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	
	} 
	
	@Override
	public void crear(NotaGrupoDTO notaGrupoDTO) {
		INotaGrupoDAO notaGrupoDAO= daoFactory.obtenerNotaGrupoDAO();
		notaGrupoDAO.crear(notaGrupoDTO);
		
	}

	@Override
	public void modificar(NotaGrupoDTO notaGrupoDTO) {
		INotaGrupoDAO notaGrupoDAO= daoFactory.obtenerNotaGrupoDAO();
		notaGrupoDAO.modificar(notaGrupoDTO);
		
	}

	@Override
	public void cambiarFechaBaja(NotaGrupoDTO notaGrupoDTO) {
		INotaGrupoDAO notaGrupoDAO= daoFactory.obtenerNotaGrupoDAO();
		notaGrupoDAO.cambiarFechaBaja(notaGrupoDTO);
		
	}

	@Override
	public List<NotaGrupoDTO> consultar(NotaGrupoDTO notaGrupoDTO) {
		INotaGrupoDAO notaGrupoDAO= daoFactory.obtenerNotaGrupoDAO();
		return notaGrupoDAO.consultar(notaGrupoDTO);
		
	}

}
