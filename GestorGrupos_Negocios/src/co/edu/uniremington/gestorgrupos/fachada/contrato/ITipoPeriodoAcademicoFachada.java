package co.edu.uniremington.gestorgrupos.fachada.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.TipoPeriodoAcademicoDTO;

public interface ITipoPeriodoAcademicoFachada {

	void crear(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO);

	void modificar(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO);

	void cambiarFechaBaja(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO);

	List<TipoPeriodoAcademicoDTO> consultar(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO);
}
