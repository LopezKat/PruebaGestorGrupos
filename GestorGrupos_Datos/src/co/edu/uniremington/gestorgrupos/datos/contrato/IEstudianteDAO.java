package co.edu.uniremington.gestorgrupos.datos.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.EstudianteDTO;

public interface IEstudianteDAO {
	
	void crear(EstudianteDTO estudianteDTO);

	void modificar(EstudianteDTO estudianteDTO);

	void cambiarFechaBaja(EstudianteDTO estudianteDTO);

	List<EstudianteDTO> consultar(EstudianteDTO estudianteDTO);

}
