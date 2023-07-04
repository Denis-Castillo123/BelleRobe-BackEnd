package sda.bellerobe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sda.bellerobe.model.Response;
import sda.bellerobe.model.VestidoModel;
import sda.bellerobe.repository.VestidoRepository;

@Service
public class VestidoService implements IVestidoService{
	
	@Autowired 
	private VestidoRepository vestidoRepository;

	@Override
	public Response<VestidoModel> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<VestidoModel> guardarVestido() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<VestidoModel> buscarVestidoId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<VestidoModel> eliminarVestido() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<VestidoModel> busquedaVestidoDinamica() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<VestidoModel> actualizarVestido() {
		// TODO Auto-generated method stub
		return null;
	}

}
