package co.edu.uniremington.gestorgrupos.fachada.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.DiaDTO;

public interface IDiaFachada {

	void crear(DiaDTO diaDTO);

	void modificar(DiaDTO diaDTO);

	void cambiarFechaBaja(DiaDTO diaDTO);

	List<DiaDTO> consultar(DiaDTO diaDTO);
}
