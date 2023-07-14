package sda.bellerobe.repository;

import sda.bellerobe.model.Response;
import sda.bellerobe.model.VestidoModel;
import sda.bellerobe.model.VestidoFiltroRequest;

public interface IConsultaVestidoRepository {

	Response <VestidoModel> busquedaVestido (VestidoFiltroRequest filtro);
	
}
