package co.edu.uniremington.gestorgrupos.datos.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.TipoProgramaDTO;

public interface ITipoProgramaDAO {

	void crear(TipoProgramaDTO tipoProgramaDTO);

	void modificar(TipoProgramaDTO tipoProgramaDTO);

	void cambiarFechaBaja(TipoProgramaDTO tipoProgramaDTO);

	List<TipoProgramaDTO> consultar(TipoProgramaDTO tipoProgramaDTO);
}
