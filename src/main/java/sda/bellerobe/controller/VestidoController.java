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
import sda.bellerobe.model.VestidoFiltroRequest;
import sda.bellerobe.model.VestidoModel;
import sda.bellerobe.model.VestidoRequest;

import sda.bellerobe.service.IUsuarioService;
import sda.bellerobe.service.IVestidoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vestido")
public class VestidoController {
	
	@Autowired
	private IVestidoService vestidoService;
	
	@GetMapping(path = "/consultarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<VestidoModel>> consultartodos(){
		
		Response<VestidoModel> lista = vestidoService.consultarTodos();
		
		return new ResponseEntity<Response<VestidoModel>> (lista, HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/guardarVestido", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response <VestidoModel>> guardarVestido (@RequestBody VestidoRequest vestido){
		
		Response<VestidoModel> response = vestidoService.guardarVestido(vestido);
		
		return new ResponseEntity<Response<VestidoModel>> (response, HttpStatus.OK);
		
	}
	
	@DeleteMapping(path = "/borrarVestidoPorId/{idVestido}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Integer>> borrarVestidoPorId (@PathVariable("idVestido") Integer idVestido){
		
		Response<Integer> response = vestidoService.eliminarVestido(idVestido);
		
		return new ResponseEntity<Response <Integer>>(response, HttpStatus.OK);
	}
	
	@PutMapping(path = "/actualizarVestido",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response <VestidoModel>> actualizarVestido (@RequestBody VestidoRequest vestido){
	
		Response<VestidoModel> response = vestidoService.actualizarVestido(vestido);
		
		return new ResponseEntity<Response<VestidoModel>> (response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/buscarVestido",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<VestidoModel>> buscarVestido (
			@RequestBody VestidoFiltroRequest filtro){
		
				Response<VestidoModel> response = vestidoService.busquedaVestidoDinamica(filtro);
				
				return new ResponseEntity<Response<VestidoModel>>(response,HttpStatus.OK);
	}
	
	@GetMapping(path = "/consultarVestidoPorID/{idVestido}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<VestidoModel>> consultarVestidoPorID (@PathVariable("idVestido") Integer idVestido){ 
		
		
		Response<VestidoModel> response = vestidoService.buscarVestidoId(idVestido);
		
		return new ResponseEntity<Response<VestidoModel>> (response,HttpStatus.OK);
		
	}
	
	/*
	 * @GetMapping(path = "/{category}", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public
	 * ResponseEntity<List<ProductResponse>> getProductsByCategory(@PathVariable
	 * String category){ return new
	 * ResponseEntity<>(productService.getProductsByCategory(category),
	 * HttpStatus.OK); }
	 */


}
