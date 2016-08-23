package co.edu.uniremington.gestorgrupos.negocio.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.MateriaDTO;

public interface IMateriaNegocio {

	void crear(MateriaDTO materiaDTO);

	void modificar(MateriaDTO materiaDTO);

	void cambiarFechaBaja(MateriaDTO materiaDTO);

	List<MateriaDTO> consultar(MateriaDTO materiaDTO);
}
