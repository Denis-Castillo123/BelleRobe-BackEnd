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
@Table (name = "CAT_Direccion")
public class CatDireccionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_direccion")
	private Integer idDireccion;
	
	@Column(name = "calle")
	private String calle;
	
	@Column(name = "colonia")
	private String colinia;
	
	@Column(name = "numero")
	private String numero;
	
}
