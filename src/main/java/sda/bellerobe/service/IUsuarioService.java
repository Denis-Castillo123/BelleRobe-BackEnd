package sda.bellerobe.service;

import sda.bellerobe.model.Response;
import sda.bellerobe.model.UsuarioModel;
import sda.bellerobe.model.UsuarioRequest;

public interface IUsuarioService {
	
	Response <UsuarioModel> consultarTodos();
	
	Response <UsuarioModel> guardarUsuario(UsuarioRequest usuario);
	
	Response <UsuarioModel> actualizarUsuario(UsuarioRequest usuario);
	
	Response <Integer> eliminarUsuario(Integer idUsuario);
	

}
