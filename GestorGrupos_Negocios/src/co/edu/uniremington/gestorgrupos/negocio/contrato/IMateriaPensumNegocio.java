package co.edu.uniremington.gestorgrupos.negocio.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.MateriaPensumDTO;

public interface IMateriaPensumNegocio {

	void crear(MateriaPensumDTO materiaPensumDTO);

	void modificar(MateriaPensumDTO materiaPensumDTO);

	void cambiarFechaBaja(MateriaPensumDTO materiaPensumDTO);

	List<MateriaPensumDTO> consultar(MateriaPensumDTO materiaPensumDTO);
}
