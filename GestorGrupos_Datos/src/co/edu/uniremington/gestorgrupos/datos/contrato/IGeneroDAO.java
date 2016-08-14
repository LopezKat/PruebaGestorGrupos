package co.edu.uniremington.gestorgrupos.datos.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.GeneroDTO;

public interface IGeneroDAO {
	
	void crear(GeneroDTO generoDTO);

	void modificar(GeneroDTO generoDTO);

	void cambiarFechaBaja(GeneroDTO generoDTO);

	List<GeneroDTO> consultar(GeneroDTO generoDTO);
}
