package co.edu.uniremington.gestorgrupos.negocio.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.TipoPeriodoAcademicoDTO;

public interface ITipoPeriodoAcademicoNegocio {

	void crear(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO);

	void modificar(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO);

	void cambiarFechaBaja(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO);

	List<TipoPeriodoAcademicoDTO> consultar(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO);
}
