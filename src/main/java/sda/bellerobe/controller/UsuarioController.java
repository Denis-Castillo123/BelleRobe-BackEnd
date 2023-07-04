package sda.bellerobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.bellerobe.model.Response;
import sda.bellerobe.model.UsuarioModel;
import sda.bellerobe.service.IUsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping(path= "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Response<UsuarioModel>> consultarTodos(){
		
		Response<UsuarioModel> response = usuarioService.consultarTodos();
		
		return new ResponseEntity<Response<UsuarioModel>>(response,HttpStatus.OK);
		
	}
	
	

}
