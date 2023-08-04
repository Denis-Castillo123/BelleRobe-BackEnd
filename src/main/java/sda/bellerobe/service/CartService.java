package sda.bellerobe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sda.bellerobe.configuration.JwtRequestFilter;
import sda.bellerobe.dao.CartDao;
import sda.bellerobe.dao.VestidoDao;
import sda.bellerobe.dao.UserDao;
import sda.bellerobe.entity.Cart;
import sda.bellerobe.entity.Vestido;
import sda.bellerobe.entity.User;

@Service
public class CartService {
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private VestidoDao vestidoDao;
	
	@Autowired
	private UserDao userDao;
	
	public void deleteCartItem(Integer cartId) {
		cartDao.deleteById(cartId);
	}
	
	public Cart addToCart(Integer vestidoId) {
		
		Vestido vestido = vestidoDao.findById(vestidoId).get();
		
		String username = JwtRequestFilter.CURRENT_USER;
		
		User user = null;
		
		if(username != null) {
			user = userDao.findById(username).get();
			
		}
		
		List<Cart> cartList = cartDao.findByUser(user);
		List<Cart> filteredList = cartList.stream().filter(x -> x.getVestido().getVestidoId() == vestidoId).collect(Collectors.toList());
		
		if(filteredList.size() > 0) {
			return null;
		}
		
		
		if(vestido != null && user != null) {
			Cart cart = new Cart(vestido, user);
			return cartDao.save(cart);
		}
		return null;
	}
	
	public List<Cart> getCartDetails(){
		String username = JwtRequestFilter.CURRENT_USER;
		User user = userDao.findById(username).get();
		return cartDao.findByUser(user);
		
	}
	
	

}
