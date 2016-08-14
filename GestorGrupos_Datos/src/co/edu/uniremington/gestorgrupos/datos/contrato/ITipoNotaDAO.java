package co.edu.uniremington.gestorgrupos.datos.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.TipoNotaDTO;

public interface ITipoNotaDAO {
	
	void crear(TipoNotaDTO tipoNotaDTO);

	void modificar(TipoNotaDTO tipoNotaDTO);

	void cambiarFechaBaja(TipoNotaDTO tipoNotaDTO);

	List<TipoNotaDTO> consultar(TipoNotaDTO tipoNotaDTO);

}
