package co.edu.uniremington.gestorgrupos.negocio.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.TipoNotaDTO;

public interface ITipoNotaNegocio {

	void crear(TipoNotaDTO tipoNotaDTO);

	void modificar(TipoNotaDTO tipoNotaDTO);

	void cambiarFechaBaja(TipoNotaDTO tipoNotaDTO);

	List<TipoNotaDTO> consultar(TipoNotaDTO tipoNotaDTO);
}
