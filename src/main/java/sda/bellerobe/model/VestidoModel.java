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
	private String nombreVestido;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "valoracion")
	private String valoracion;
	
	@Column(name = "precio")
	private Number precio;
	
	@Column(name = "id_tipo")
	private Integer id_tipo;
	
}
