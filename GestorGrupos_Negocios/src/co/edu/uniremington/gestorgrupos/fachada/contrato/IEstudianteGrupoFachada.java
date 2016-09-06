package co.edu.uniremington.gestorgrupos.fachada.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.EstudianteGrupoDTO;

public interface IEstudianteGrupoFachada {

	void crear(EstudianteGrupoDTO estudianteGrupoDTO);

	void modificar(EstudianteGrupoDTO estudianteGrupoDTO);

	void cambiarFechaBaja(EstudianteGrupoDTO estudianteGrupoDTO);

	List<EstudianteGrupoDTO> consultar(EstudianteGrupoDTO estudianteGrupoDTO);
}
