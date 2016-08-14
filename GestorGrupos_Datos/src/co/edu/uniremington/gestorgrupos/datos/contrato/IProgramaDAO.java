package co.edu.uniremington.gestorgrupos.datos.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.ProgramaDTO;

public interface IProgramaDAO {
	
	void crear(ProgramaDTO programaDTO);

	void modificar(ProgramaDTO programaDTO);

	void cambiarFechaBaja(ProgramaDTO programaDTO);

	List<ProgramaDTO> consultar(ProgramaDTO programaDTO);

}
