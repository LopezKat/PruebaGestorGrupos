package co.edu.uniremington.gestorgrupos.datos.contrato;

import java.util.List;

import co.edu.uniremington.gestorgrupos.dto.TipoPeriodoAcademicoDTO;

public interface ITipoPeriodoAcademicoDAO {
	
	void crear(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO);

	void modificar(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO);

	void cambiarFechaBaja(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO);

	List<TipoPeriodoAcademicoDTO> consultar(TipoPeriodoAcademicoDTO tipoPeriodoAcademicoDTO);

}
