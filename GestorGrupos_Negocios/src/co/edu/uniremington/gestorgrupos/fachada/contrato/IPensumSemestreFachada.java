package co.edu.uniremington.gestorgrupos.fachada.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.PensumSemestreDTO;

public interface IPensumSemestreFachada {

	void crear(PensumSemestreDTO pensumSemestreDTO);

	void modificar(PensumSemestreDTO pensumSemestreDTO);

	void cambiarFechaBaja(PensumSemestreDTO pensumSemestreDTO);

	List<PensumSemestreDTO> consultar(PensumSemestreDTO pensumSemestreDTO);
}
