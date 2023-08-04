package sda.bellerobe.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import sda.bellerobe.entity.ImageModel;
import sda.bellerobe.entity.Vestido;
import sda.bellerobe.service.VestidoService;

@RestController
public class VestidoController {
	
	@Autowired
	private VestidoService vestidoService;
	
	@PreAuthorize("hasRole('Admin')")
	@PostMapping(value = {"/addNewVestido"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public Vestido addNewVestido(@RequestPart("vestido") Vestido vestido,
									@RequestPart("imageFile") MultipartFile[] file) {		
	
		try {
			Set<ImageModel> images = uplodImage(file);
			vestido.setVestidoImages(images);
			return vestidoService.addNewVestido(vestido); 
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		
	}
	
	
	public Set<ImageModel> uplodImage(MultipartFile[] multipartFiles) throws IOException{
		
		Set<ImageModel> imageModels = new HashSet<>();
		
		for(MultipartFile file: multipartFiles) {
			ImageModel imageModel = new ImageModel(
					file.getOriginalFilename(),
					file.getContentType(),
					file.getBytes());
			imageModels.add(imageModel);
		}
		return imageModels;
	}
	
	
	@GetMapping({"/getAllVestidos"})
	public List<Vestido> getAllVestidos(@RequestParam(defaultValue = "0") int pageNumber
			, @RequestParam(defaultValue = "") String searchKey){
		return vestidoService.getAllVestidos(pageNumber, searchKey);
	}
	
	
	@GetMapping({"/getVestidoDetailsById/{vestidoId}"})
	public Vestido getVestidoDetailsById(@PathVariable("vestidoId") Integer vestidoId) {
		
		return vestidoService.getVestidoDetailsById(vestidoId);
		
	}
	
	@PreAuthorize("hasRole('Admin')")
	@DeleteMapping({"/deleteVestidoDetails/{vestidoId}"})
	public void deleteVestidoDetailes(@PathVariable("vestidoId") Integer vestidoId) {
		vestidoService.deleteVestidoDetails(vestidoId);
	}
	
	@PreAuthorize("hasRole('User')")
	@GetMapping({"/getVestidoDetails/{isSingeVestidoCheckout}/{vestidoId}"})
	public List<Vestido> getVestidoDetails(@PathVariable(name="isSingeVestidoCheckout") boolean isSingeVestidoCheckout,
										@PathVariable(name= "vestidoId") Integer vestidoId) {
		
		return vestidoService.getVestidoDetails(isSingeVestidoCheckout, vestidoId);
		
		
	}

}
