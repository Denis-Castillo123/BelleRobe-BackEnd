package sda.bellerobe.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	@OneToOne
	private Vestido vestido;
	@OneToOne
	private User user;
	
	
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Cart(Vestido vestido, User user) {
		super();
		this.vestido = vestido;
		this.user = user;
	}


	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Vestido getVestido() {
		return vestido;
	}
	public void setVestido(Vestido vestido) {
		this.vestido = vestido;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
