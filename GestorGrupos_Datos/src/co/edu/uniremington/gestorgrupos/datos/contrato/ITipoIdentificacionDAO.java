package co.edu.uniremington.gestorgrupos.datos.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.TipoIdentificacionDTO;

public interface ITipoIdentificacionDAO {
	
	void crear(TipoIdentificacionDTO tipoIdentificacionDTO);

	void modificar(TipoIdentificacionDTO tipoIdentificacionDTO);

	void cambiarFechaBaja(TipoIdentificacionDTO tipoIdentificacionDTO);

	List<TipoIdentificacionDTO> consultar(TipoIdentificacionDTO tipoIdentificacionDTO);


}
