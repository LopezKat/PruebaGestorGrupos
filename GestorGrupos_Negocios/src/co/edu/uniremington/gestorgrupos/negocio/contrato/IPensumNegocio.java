package co.edu.uniremington.gestorgrupos.negocio.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.PensumDTO;

public interface IPensumNegocio {

	void crear(PensumDTO pensumDTO);

	void modificar(PensumDTO pensumDTO);

	void cambiarFechaBaja(PensumDTO pensumDTO);

	List<PensumDTO> consultar(PensumDTO pensumDTO);
}
