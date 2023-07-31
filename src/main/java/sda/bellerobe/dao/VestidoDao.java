package sda.bellerobe.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sda.bellerobe.entity.Vestido;

@Repository
public interface VestidoDao extends CrudRepository<Vestido, Integer>{

	public List<Vestido> findAll(Pageable pageable);
	
	public List<Vestido>  findByVestidoNameContainingIgnoreCaseOrVestidoDescriptionContainingIgnoreCase(
			String key1, String key2, Pageable pageable);
	

}
