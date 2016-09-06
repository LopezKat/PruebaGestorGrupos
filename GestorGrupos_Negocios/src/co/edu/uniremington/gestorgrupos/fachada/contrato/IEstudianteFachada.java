package co.edu.uniremington.gestorgrupos.fachada.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.EstudianteDTO;

public interface IEstudianteFachada {

	void crear(EstudianteDTO estudianteDTO);

	void modificar(EstudianteDTO estudianteDTO);

	void cambiarFechaBaja(EstudianteDTO estudianteDTO);

	List<EstudianteDTO> consultar(EstudianteDTO estudianteDTO);
}
