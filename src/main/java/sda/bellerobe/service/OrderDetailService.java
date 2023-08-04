package sda.bellerobe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sda.bellerobe.configuration.JwtRequestFilter;
import sda.bellerobe.dao.CartDao;
import sda.bellerobe.dao.OrderDetailDao;
import sda.bellerobe.dao.VestidoDao;
import sda.bellerobe.dao.UserDao;
import sda.bellerobe.entity.Cart;
import sda.bellerobe.entity.OrderDetail;
import sda.bellerobe.entity.OrderInput;
import sda.bellerobe.entity.OrderDressQuantity;
import sda.bellerobe.entity.Vestido;
import sda.bellerobe.entity.User;

@Service
public class OrderDetailService {
	
	private static final String ORDER_PLACED = "Placed";  
	
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@Autowired
	private VestidoDao vestidoDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CartDao cartDao;
	
	public List<OrderDetail> getAllOrderDetails(){
		List<OrderDetail> orderDetails = new ArrayList<>();
		orderDetailDao.findAll().forEach(e -> orderDetails.add(e));
		
		return orderDetails;
	}
	
	public List<OrderDetail> getOrderDetails() {
		String currentUser = JwtRequestFilter.CURRENT_USER;
		User user = userDao.findById(currentUser).get();
		
		return orderDetailDao.findByUser(user);
	}
	
	public void placeOrder(OrderInput orderInput, boolean isSingleVestidoCheckout) {
		List<OrderDressQuantity> vestidoQuantityList = orderInput.getOrderDressQuantityList();
		
		for(OrderDressQuantity o: vestidoQuantityList) {
			Vestido vestido = vestidoDao.findById(o.getVestidoId()).get();
			
			String currentUser = JwtRequestFilter.CURRENT_USER;
			User user= userDao.findById(currentUser).get();
			
			OrderDetail orderDetail = new OrderDetail(
					orderInput.getFullName(),
					orderInput.getFullAddress(),
					orderInput.getContactNumber(),
					orderInput.getAlternateContactNumber(),
					ORDER_PLACED,
					vestido.getVestidoDiscountedPrice()*o.getQuantity(),
					vestido,
					user);
			
			if(!isSingleVestidoCheckout) {
				List<Cart> carts= cartDao.findByUser(user);
				carts.stream().forEach(x -> cartDao.deleteById(x.getCartId()));			
				
			}
			orderDetailDao.save(orderDetail);
		}
	}
	
	

}
