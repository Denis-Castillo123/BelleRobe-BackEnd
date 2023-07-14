package sda.bellerobe.model;

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
@Table (name = "TAB_Orden_Renta")
public class OrdenRentaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_orden")
	private Integer idOrden;
	
	@Column(name = "fechaOrden")
	private String fechaOrden;
	
	@Column(name = "fechaEntrega")
	private String fechaEntrega;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "totalOrden")
	private Double totalOrden;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario")
	private UsuarioModel id_usuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ciudad")
	private CatCiudadModel id_ciudad;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_direccion")
	private CatDireccionModel id_direccion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_vestido")
	private VestidoModel id_vestido;
	
}
