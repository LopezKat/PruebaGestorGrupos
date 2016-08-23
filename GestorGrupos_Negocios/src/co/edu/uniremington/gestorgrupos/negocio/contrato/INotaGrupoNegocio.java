package co.edu.uniremington.gestorgrupos.negocio.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.NotaGrupoDTO;

public interface INotaGrupoNegocio {

	void crear(NotaGrupoDTO notaGrupoDTO);

	void modificar(NotaGrupoDTO notaGrupoDTO);

	void cambiarFechaBaja(NotaGrupoDTO notaGrupoDTO);

	List<NotaGrupoDTO> consultar(NotaGrupoDTO notaGrupoDTO);
}
