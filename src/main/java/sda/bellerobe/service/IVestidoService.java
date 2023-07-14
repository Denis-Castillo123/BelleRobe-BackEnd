package sda.bellerobe.service;

import sda.bellerobe.model.Response;
import sda.bellerobe.model.VestidoFiltroRequest;
import sda.bellerobe.model.VestidoModel;
import sda.bellerobe.model.VestidoRequest;

public interface IVestidoService {
	
	Response<VestidoModel> consultarTodos();
	
	Response<VestidoModel> guardarVestido(VestidoRequest vestido);
	
	Response<VestidoModel> buscarVestidoId(Integer idVestido);
	
	Response<Integer> eliminarVestido(Integer idVestido);
	
	Response<VestidoModel> busquedaVestidoDinamica(VestidoFiltroRequest filtro);
	
	Response<VestidoModel> actualizarVestido(VestidoRequest vestido);
	

}
