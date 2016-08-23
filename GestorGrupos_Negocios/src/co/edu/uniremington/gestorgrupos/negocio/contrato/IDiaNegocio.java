package co.edu.uniremington.gestorgrupos.negocio.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.DiaDTO;

public interface IDiaNegocio {

	void crear(DiaDTO diaDTO);

	void modificar(DiaDTO diaDTO);

	void cambiarFechaBaja(DiaDTO diaDTO);

	List<DiaDTO> consultar(DiaDTO diaDTO);
}
