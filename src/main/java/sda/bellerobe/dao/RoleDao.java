package sda.bellerobe.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sda.bellerobe.entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
