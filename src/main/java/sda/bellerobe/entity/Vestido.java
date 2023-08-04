package sda.bellerobe.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Vestido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vestidoId;
	private String vestidoName;
	@Column(length = 1000)
	private String vestidoDescription;
	private Double vestidoDiscountedPrice;
	private Double vestidoActualPrice;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade =CascadeType.ALL)
	@JoinTable(name = "vestido_images",
	joinColumns = {
			@JoinColumn(name = "vestido_id")
	},
	inverseJoinColumns = {
			@JoinColumn(name = "image_id")
	})
	private Set<ImageModel> vestidoImages;
	
	
	
	public Set<ImageModel> getVestidoImages() {
		return vestidoImages;
	}

	public void setVestidoImages(Set<ImageModel> vestidoImages) {
		this.vestidoImages = vestidoImages;
	}

	public Vestido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getVestidoId() {
		return vestidoId;
	}

	public void setVestidoId(Integer vestidoId) {
		this.vestidoId = vestidoId;
	}

	public String getVestidoName() {
		return vestidoName;
	}

	public void setVestidoName(String vestidoName) {
		this.vestidoName = vestidoName;
	}

	public String getVestidoDescription() {
		return vestidoDescription;
	}

	public void setVestidoDescription(String vestidoDescription) {
		this.vestidoDescription = vestidoDescription;
	}

	public Double getVestidoDiscountedPrice() {
		return vestidoDiscountedPrice;
	}

	public void setVestidoDiscountedPrice(Double vestidoDiscountedPrice) {
		this.vestidoDiscountedPrice = vestidoDiscountedPrice;
	}

	public Double getVestidoActualPrice() {
		return vestidoActualPrice;
	}

	public void setVestidoActualPrice(Double vestidoActualPrice) {
		this.vestidoActualPrice = vestidoActualPrice;
	}

	public Vestido(Integer vestidoId, String vestidoName, String vestidoDescription, Double vestidoDiscountedPrice,
			Double vestidoActualPrice) {
		super();
		this.vestidoId = vestidoId;
		this.vestidoName = vestidoName;
		this.vestidoDescription = vestidoDescription;
		this.vestidoDiscountedPrice = vestidoDiscountedPrice;
		this.vestidoActualPrice = vestidoActualPrice;
	}
	
	
	
	

}
