package co.edu.uniremington.gestorgrupos.fachada.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.ProfesorDTO;

public interface IProfesorFachada {

	void crear(ProfesorDTO profesorDTO);

	void modificar(ProfesorDTO profesorDTO);

	void cambiarFechaBaja(ProfesorDTO profesorDTO);

	List<ProfesorDTO> consultar(ProfesorDTO profesorDTO);
}
