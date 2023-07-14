package sda.bellerobe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sda.bellerobe.model.CatTipoModel;
import sda.bellerobe.model.Response;
import sda.bellerobe.model.VestidoFiltroRequest;
import sda.bellerobe.model.VestidoModel;
import sda.bellerobe.model.VestidoRequest;
import sda.bellerobe.repository.ConsultaVestidoRepository;
import sda.bellerobe.repository.TipoRepository;
import sda.bellerobe.repository.VestidoRepository;

@Service
public class VestidoService implements IVestidoService{
	
	@Autowired
	private VestidoRepository vestidoRepository;
	
	@Autowired
	private ConsultaVestidoRepository consultaVestidoRepository;
	
	@Autowired
	private TipoRepository tipoRepository;

	@Override
	public Response<VestidoModel> consultarTodos() {
		
		Response<VestidoModel> response = new Response<VestidoModel>();
		List<VestidoModel> lista = vestidoRepository.findAll();
		
		if (lista.isEmpty()) {
			response.setMessage("No hay resultados");
		} else {
			response.setMessage("Consulta correcta");
		}
		
		response.setStatus("OK");
		response.setList(lista);
		response.setCount(lista.size());
		
		return response;
	}

	@Override
	public Response<VestidoModel> guardarVestido(VestidoRequest vestido) {

		Response<VestidoModel> response = new Response<VestidoModel>();
		
		Optional<CatTipoModel> optionalTipo = tipoRepository.findById(vestido.getIdTipo());
		
		CatTipoModel tipo = null;
		VestidoModel vestido1 = null;
		VestidoModel vestido2 = null;
		
		if(optionalTipo.isPresent()) {
			tipo = optionalTipo.get();
			vestido1 = new VestidoModel();
			vestido1.setNombreVestido(vestido.getNombreVestido());
			vestido1.setDescripcion(vestido.getDescripcion());
			vestido1.setPrecio(vestido.getPrecio());
			vestido1.setValoracion(vestido.getValoracion());
			vestido1.setIdTipo(tipo);
			
			vestido2 = vestidoRepository.save(vestido1);
			
			response.setStatus("OK");
			response.setMessage("Guardaro correctamente");
			response.setData(vestido2);
			
		}else {
			
			response.setStatus("ERROR");
			response.setMessage("El tipo no existe");
			response.setData(null);
			
		}
		
		return response;
	}

	@Override
	public Response<VestidoModel> buscarVestidoId(Integer idVestido) {

		Response <VestidoModel> response = new Response<VestidoModel>();
		
		VestidoModel vestido = null;
		
		Optional<VestidoModel> optional = vestidoRepository.findById(idVestido);
		
		if (optional.isPresent()) {
			
			vestido = optional.get();
			response.setStatus("OK");
			response.setMessage("Busqueda correcta");
			response.setData(vestido);
			
		}
		
		response.setMessage("Sin resultados");
		response.setData(null);
		
		return response;
	}

	@Override
	public Response<Integer> eliminarVestido(Integer idVestido) {

		Response<Integer> response = new Response<Integer>();
		vestidoRepository.deleteById(idVestido);
		
		response.setStatus("OK");
		response.setMessage("Eliminado correcto");
		response.setData(idVestido);
		
		return response;
	}

	@Override
	public Response<VestidoModel> busquedaVestidoDinamica(VestidoFiltroRequest filtro) {

		Response<VestidoModel> response  = new Response<VestidoModel>();
		
		response = consultaVestidoRepository.busquedaVestido(filtro);
		
		return response;
	}

	@Override
	public Response<VestidoModel> actualizarVestido(VestidoRequest vestido) {

		Response<VestidoModel> response = new Response<VestidoModel>();
		
		Optional <CatTipoModel> optionalTipo = tipoRepository.findById(vestido.getIdTipo());
		
		CatTipoModel tipo = null;
		VestidoModel vestido1 = null;
		VestidoModel vestido2 = null;
		
		if(optionalTipo.isPresent()) {
			tipo = optionalTipo.get();
			vestido1 = new VestidoModel();
			vestido1.setIdVestido(vestido.getIdVestido());
			vestido1.setNombreVestido(vestido.getNombreVestido());
			vestido1.setDescripcion(vestido.getDescripcion());
			vestido1.setPrecio(vestido.getPrecio());
			vestido1.setValoracion(vestido.getValoracion());
			vestido1.setIdTipo(tipo);
			
			vestido2 = vestidoRepository.save(vestido1);
			
			response.setStatus("OK");
			response.setMessage("Guardaro correctamente");
			response.setData(vestido2);
			
		}else {
			
			response.setStatus("ERROR");
			response.setMessage("El tipo no existe");
			response.setData(null);
			
		}
		
		return response;
	}
	

}
