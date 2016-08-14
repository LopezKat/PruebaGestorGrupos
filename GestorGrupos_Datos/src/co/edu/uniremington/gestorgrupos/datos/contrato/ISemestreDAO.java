package co.edu.uniremington.gestorgrupos.datos.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.SemestreDTO;

public interface ISemestreDAO {
	
	void crear(SemestreDTO semestreDTO);

	void modificar(SemestreDTO semestreDTO);

	void cambiarFechaBaja(SemestreDTO semestreDTO);

	List<SemestreDTO> consultar(SemestreDTO semestreDTO);

}
