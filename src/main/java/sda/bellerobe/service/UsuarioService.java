package sda.bellerobe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sda.bellerobe.model.CatRolModel;
import sda.bellerobe.model.Response;
import sda.bellerobe.model.UsuarioModel;
import sda.bellerobe.model.UsuarioRequest;
import sda.bellerobe.repository.IRolRepository;
import sda.bellerobe.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private IRolRepository rolRepository;
	
	@Override
	public Response<UsuarioModel> consultarTodos() {

		Response<UsuarioModel> response = new Response<UsuarioModel>();
		
		List<UsuarioModel> lista = usuarioRepository.findAll();
		
		if(lista.isEmpty()) {
			
			response.setMessage("No hay resultados");
			response.setStatus("OK");
			
		}else {
			
			response.setMessage("Consulta correcta");
			
		}
		
		response.setStatus("OK");
		response.setList(lista);
		response.setCount(lista.size());
		
		return response;
	}

	@Override
	public Response<UsuarioModel> guardarUsuario(UsuarioRequest usuario) {

		Response<UsuarioModel> response = new Response<UsuarioModel>();
		
		Optional <CatRolModel> optional = rolRepository.findById(usuario.getRol());
		
		CatRolModel rol = null;
		UsuarioModel usuario1 = null;
		UsuarioModel usuario2 = null;
		
		
		return response;
	}

	@Override
	public Response<UsuarioModel> actualizarUsuario(UsuarioRequest usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<Integer> eliminarUsuario(Integer idUsuario) {

		Response<Integer> response = new Response<Integer>();
		
		usuarioRepository.deleteById(idUsuario);
		
		response.setMessage("Borrado exitoso");
		response.setStatus("OK");
		response.setData(idUsuario);
		
		return response;
	}

}
