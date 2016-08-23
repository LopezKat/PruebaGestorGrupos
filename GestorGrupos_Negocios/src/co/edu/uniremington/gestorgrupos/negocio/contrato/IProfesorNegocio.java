package co.edu.uniremington.gestorgrupos.negocio.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.ProfesorDTO;

public interface IProfesorNegocio {

	void crear(ProfesorDTO profesorDTO);

	void modificar(ProfesorDTO profesorDTO);

	void cambiarFechaBaja(ProfesorDTO profesorDTO);

	List<ProfesorDTO> consultar(ProfesorDTO profesorDTO);
}
