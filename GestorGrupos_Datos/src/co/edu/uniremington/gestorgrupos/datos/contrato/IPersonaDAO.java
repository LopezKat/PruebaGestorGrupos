package co.edu.uniremington.gestorgrupos.datos.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.PersonaDTO;

public interface IPersonaDAO {
	
	void crear(PersonaDTO personaDTO);

	void modificar(PersonaDTO personaDTO);

	void cambiarFechaBaja(PersonaDTO personaDTO);

	List<PersonaDTO> consultar(PersonaDTO personaDTO);

}
