package co.edu.uniremington.gestorgrupos.datos.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.DiaDTO;

public interface IDiaDAO {

	void crear(DiaDTO diaDTO);

	void modificar(DiaDTO diaDTO);

	void cambiarFechaBaja(DiaDTO diaDTO);

	List<DiaDTO> consultar(DiaDTO diaDTO);

}
