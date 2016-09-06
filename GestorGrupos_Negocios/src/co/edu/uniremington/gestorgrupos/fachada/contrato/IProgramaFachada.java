package co.edu.uniremington.gestorgrupos.fachada.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.ProgramaDTO;

public interface IProgramaFachada {

	void crear(ProgramaDTO programaDTO);

	void modificar(ProgramaDTO programaDTO);

	void cambiarFechaBaja(ProgramaDTO programaDTO);

	List<ProgramaDTO> consultar(ProgramaDTO programaDTO);
}
