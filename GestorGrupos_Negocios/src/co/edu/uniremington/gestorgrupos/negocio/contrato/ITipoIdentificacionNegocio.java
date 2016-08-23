package co.edu.uniremington.gestorgrupos.negocio.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.TipoIdentificacionDTO;

public interface ITipoIdentificacionNegocio {

	void crear(TipoIdentificacionDTO tipoIdentificacionDTO);

	void modificar(TipoIdentificacionDTO tipoIdentificacionDTO);

	void cambiarFechaBaja(TipoIdentificacionDTO tipoIdentificacionDTO);

	List<TipoIdentificacionDTO> consultar(TipoIdentificacionDTO tipoIdentificacionDTO);
}
