package co.edu.uniremington.gestorgrupos.datos.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.MateriaPensumDTO;

public interface IMateriaPensumDAO {
	
	void crear(MateriaPensumDTO materiaPensumDTO);

	void modificar(MateriaPensumDTO materiaPensumDTO);

	void cambiarFechaBaja(MateriaPensumDTO materiaPensumDTO);

	List<MateriaPensumDTO> consultar(MateriaPensumDTO materiaPensumDTO);

}
