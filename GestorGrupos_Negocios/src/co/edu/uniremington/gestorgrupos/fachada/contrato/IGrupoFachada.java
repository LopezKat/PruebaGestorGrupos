package co.edu.uniremington.gestorgrupos.fachada.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.GrupoDTO;

public interface IGrupoFachada {

	void crear(GrupoDTO grupoDTO);

	void modificar(GrupoDTO grupoDTO);

	void cambiarFechaBaja(GrupoDTO grupoDTO);

	List<GrupoDTO> consultar(GrupoDTO grupoDTO);
}
