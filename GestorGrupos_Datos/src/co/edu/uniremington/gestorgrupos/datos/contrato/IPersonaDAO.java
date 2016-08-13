package co.edu.uniremington.gestorgrupos.datos.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.PersonaDTO;

public interface IPersonaDAO {
	
	void crear(PersonaDTO persona);

	void modificar(PersonaDTO persona);

	void activar(PersonaDTO persona);

	void desactivar(PersonaDTO persona);

	List<PersonaDTO> consultar(PersonaDTO persona);

}
