package sda.bellerobe.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {
	
	private Integer id;
	
	private String nomrbre;
	
	private String apellidoP;
	
	private String apellidoM;
	
	private String correo;
	
	private String password;
	
	private String telefono;
	
	private Integer rol;

}
