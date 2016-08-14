package co.edu.uniremington.gestorgrupos.datos.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.MateriaDTO;

public interface IMateriaDAO {
	
	void crear(MateriaDTO materiaDTO);

	void modificar(MateriaDTO materiaDTO);

	void cambiarFechaBaja(MateriaDTO materiaDTO);

	List<MateriaDTO> consultar(MateriaDTO materiaDTO);

}
