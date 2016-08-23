package co.edu.uniremington.gestorgrupos.negocio.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.SemestreDTO;

public interface ISemestreNegocio {

	void crear(SemestreDTO semestreDTO);

	void modificar(SemestreDTO semestreDTO);

	void cambiarFechaBaja(SemestreDTO semestreDTO);

	List<SemestreDTO> consultar(SemestreDTO semestreDTO);
}
