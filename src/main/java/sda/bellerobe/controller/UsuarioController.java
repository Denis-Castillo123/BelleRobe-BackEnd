package sda.bellerobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.bellerobe.model.Response;
import sda.bellerobe.model.UsuarioModel;
import sda.bellerobe.model.UsuarioRequest;
import sda.bellerobe.model.VestidoModel;
import sda.bellerobe.model.VestidoRequest;
import sda.bellerobe.service.IUsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping(path= "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Response<UsuarioModel>> consultarTodos(){
		
		Response<UsuarioModel> response = usuarioService.consultarTodos();
		
		return new ResponseEntity<Response<UsuarioModel>>(response,HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/guardarUsuario", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response <UsuarioModel>> guardarUsuario (@RequestBody UsuarioRequest usuario){
		
		Response<UsuarioModel> response = usuarioService.guardarUsuario(usuario);
		
		return new ResponseEntity<Response<UsuarioModel>>(response,HttpStatus.OK);
		
	}
	
	@DeleteMapping(path = "/borrarUsuarioPorId/{idUsuario}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Integer>> borrarVestidoPorId (@PathVariable("idUsuario") Integer idUsuario){
		
		Response<Integer> response = usuarioService.eliminarUsuario(idUsuario);
		
		return new ResponseEntity<Response <Integer>>(response, HttpStatus.OK);
	}
	
	@PutMapping(path = "/actualizarVestido",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response <UsuarioModel>> actualizarVestido (@RequestBody UsuarioRequest usuario){
	
		Response<UsuarioModel> response = usuarioService.actualizarUsuario(usuario);
		
		return new ResponseEntity<Response<UsuarioModel>> (response, HttpStatus.OK);
	}

}
