package co.edu.uniremington.gestorgrupos.fachada.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.TipoProgramaDTO;

public interface ITipoProgramaFachada {

	void crear(TipoProgramaDTO tipoProgramaDTO);

	void modificar(TipoProgramaDTO tipoProgramaDTO);

	void cambiarFechaBaja(TipoProgramaDTO tipoProgramaDTO);

	List<TipoProgramaDTO> consultar(TipoProgramaDTO tipoProgramaDTO);
}
