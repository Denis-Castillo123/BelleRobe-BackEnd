package sda.bellerobe.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VestidoRequest {

	private Integer idVestido;

	private String nombreVestido;

	private String descripcion;

	private String valoracion;

	private BigDecimal precio;

	private Integer idTipo;
	
	private String imagen;

}
