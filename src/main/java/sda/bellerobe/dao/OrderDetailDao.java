package sda.bellerobe.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sda.bellerobe.entity.OrderDetail;
import sda.bellerobe.entity.User;

@Repository
public interface OrderDetailDao extends CrudRepository<OrderDetail, Integer>{
	
	public List<OrderDetail> findByUser(User user);

}
