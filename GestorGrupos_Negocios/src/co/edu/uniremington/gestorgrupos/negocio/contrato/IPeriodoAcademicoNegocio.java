package co.edu.uniremington.gestorgrupos.negocio.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.PeriodoAcademicoDTO;

public interface IPeriodoAcademicoNegocio {

	void crear(PeriodoAcademicoDTO periodoAcademicoDTO);

	void modificar(PeriodoAcademicoDTO periodoAcademicoDTO);

	void cambiarFechaBaja(PeriodoAcademicoDTO periodoAcademicoDTO);

	List<PeriodoAcademicoDTO> consultar(PeriodoAcademicoDTO periodoAcademicoDTO);
}
