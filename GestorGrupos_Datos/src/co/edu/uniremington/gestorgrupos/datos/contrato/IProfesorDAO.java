package co.edu.uniremington.gestorgrupos.datos.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.ProfesorDTO;

public interface IProfesorDAO {

	void crear(ProfesorDTO profesor);

	void modificar(ProfesorDTO profesor);

	void activar(ProfesorDTO profesor);

	void desactivar(ProfesorDTO profesor);

	List<ProfesorDTO> consultar(ProfesorDTO profesor);
	
}
