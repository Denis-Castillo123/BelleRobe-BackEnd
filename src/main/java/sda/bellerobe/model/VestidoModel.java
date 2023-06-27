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
@Table (name = "TAB_vestido") 
public class VestidoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vestido")
	private Integer idVestido;
	
	@Column(name = "nombrevestido")
	private Integer nombreVestido;
	
	@Column(name = "descripcion")
	private Integer descripcion;
	
	@Column(name = "valoracion")
	private Integer valoracion;
	
	@Column(name = "precio")
	private Integer precio;
	
	@Column(name = "id_tipo")
	private Integer id_tipo;
	
}
