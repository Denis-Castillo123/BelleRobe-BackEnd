package sda.bellerobe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sda.bellerobe.model.CatTipoModel;

@Repository
public interface TipoRepository extends JpaRepository <CatTipoModel,Integer>{

	
}
