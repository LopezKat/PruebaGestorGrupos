package co.edu.uniremington.gestorgrupos.datos.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.NotaEstudianteGrupoDTO;

public interface INotaEstudianteGrupoDAO {
	
	void crear(NotaEstudianteGrupoDTO notaEstudianteGrupoDTO);

	void modificar(NotaEstudianteGrupoDTO notaEstudianteGrupoDTO);

	void cambiarFechaBaja(NotaEstudianteGrupoDTO notaEstudianteGrupoDTO);

	List<NotaEstudianteGrupoDTO> consultar(NotaEstudianteGrupoDTO notaEstudianteGrupoDTO);
}
