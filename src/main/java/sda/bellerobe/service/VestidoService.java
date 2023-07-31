package sda.bellerobe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import sda.bellerobe.configuration.JwtRequestFilter;
import sda.bellerobe.dao.CartDao;
import sda.bellerobe.dao.VestidoDao;
import sda.bellerobe.dao.UserDao;
import sda.bellerobe.entity.Cart;
import sda.bellerobe.entity.Vestido;
import sda.bellerobe.entity.User;

@Service
public class VestidoService {
	
	@Autowired
	private VestidoDao vestidoDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private CartDao cartDao;
	
	public Vestido addNewVestido(Vestido vestido) {
		return vestidoDao.save(vestido);		
	}
	
	public List<Vestido> getAllVestidos(int pageNumber, String searchKey){
		Pageable pageable = PageRequest.of(pageNumber, 8);
		
		if(searchKey.equals("")) {
			return (List<Vestido>) vestidoDao.findAll(pageable);
		}else {
			return (List<Vestido>)vestidoDao.findByVestidoNameContainingIgnoreCaseOrVestidoDescriptionContainingIgnoreCase(searchKey, searchKey, pageable);
		}
		
	}
	
	public void deleteVestidoDetails(Integer vestidoId) {
		vestidoDao.deleteById(vestidoId);
	}

	public Vestido getVestidoDetailsById(Integer vestidoId) {
		
		return vestidoDao.findById(vestidoId).get();
	}
	
	public List<Vestido> getVestidoDetails(boolean isSingeVestidoCheckout, Integer vestidoId) {
	
		if(isSingeVestidoCheckout && vestidoId != 0) {
			List<Vestido> list= new ArrayList<>();
			Vestido vestido = vestidoDao.findById(vestidoId).get();
			list.add(vestido);
			return list;
		}else {
		
			String username = JwtRequestFilter.CURRENT_USER;
			User user = userDao.findById(username).get();
			List<Cart>  carts= cartDao.findByUser(user);
			
			return carts.stream().map(x -> x.getVestido()).collect(Collectors.toList());
			
		}
		
	
	}
	
	
	

}
