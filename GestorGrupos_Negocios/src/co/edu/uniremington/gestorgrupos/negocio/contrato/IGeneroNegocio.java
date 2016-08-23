package co.edu.uniremington.gestorgrupos.negocio.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.GeneroDTO;

public interface IGeneroNegocio {

	void crear(GeneroDTO generoDTO);

	void modificar(GeneroDTO generoDTO);

	void cambiarFechaBaja(GeneroDTO generoDTO);

	List<GeneroDTO> consultar(GeneroDTO generoDTO);
}
