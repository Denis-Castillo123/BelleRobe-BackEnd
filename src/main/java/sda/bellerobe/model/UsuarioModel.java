package sda.bellerobe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table (name = "TAB_Usuario")
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer idUsuario;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellidoP")
	private String apellidoP;
	
	@Column(name = "apellidoM")
	private String apellidoM;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "passwd")
	private String password;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "id_rol")
	private CatRolModel id_rol;
	
}
