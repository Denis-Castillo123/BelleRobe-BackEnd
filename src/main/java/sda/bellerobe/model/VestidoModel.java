package sda.bellerobe.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private BigDecimal precio;
	
	@Column(name = "imagen")
	private String imagen;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo")
	private CatTipoModel idTipo;
	
}
