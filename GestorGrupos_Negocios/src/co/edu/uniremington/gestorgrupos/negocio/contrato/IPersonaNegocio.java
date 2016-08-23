package co.edu.uniremington.gestorgrupos.negocio.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.PersonaDTO;

public interface IPersonaNegocio {

	void crear(PersonaDTO personaDTO);

	void modificar(PersonaDTO personaDTO);

	void cambiarFechaBaja(PersonaDTO personaDTO);

	List<PersonaDTO> consultar(PersonaDTO personaDTO);
}
