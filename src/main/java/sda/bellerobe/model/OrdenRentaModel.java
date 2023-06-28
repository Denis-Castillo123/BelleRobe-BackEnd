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
	
	@Column(name = "id_usuario")
	private Integer id_usuario;
	
	@Column(name = "id_ciudad")
	private Integer id_ciudad;
	
	@Column(name = "id_direccion")
	private Integer id_direccion;
	
	@Column(name = "id_vestido")
	private Integer id_vestido;
	
}
