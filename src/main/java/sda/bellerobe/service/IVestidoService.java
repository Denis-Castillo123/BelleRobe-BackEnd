package sda.bellerobe.service;

import sda.bellerobe.model.Response;
import sda.bellerobe.model.VestidoModel;

public interface IVestidoService {
	
	Response<VestidoModel> consultarTodos();
	
	Response<VestidoModel> guardarVestido();
	
	Response<VestidoModel> buscarVestidoId();
	
	Response<VestidoModel> eliminarVestido();
	
	Response<VestidoModel> busquedaVestidoDinamica();
	
	Response<VestidoModel> actualizarVestido();
	

}
