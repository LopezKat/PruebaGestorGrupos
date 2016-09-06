package co.edu.uniremington.gestorgrupos.fachada.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.PersonaDTO;

public interface IPersonaFachada{

	void crear(PersonaDTO personaDTO);

	void modificar(PersonaDTO personaDTO);

	void cambiarFechaBaja(PersonaDTO personaDTO);

	List<PersonaDTO> consultar(PersonaDTO personaDTO);
}
