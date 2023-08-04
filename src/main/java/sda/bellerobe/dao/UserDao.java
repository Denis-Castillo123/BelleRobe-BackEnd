package sda.bellerobe.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sda.bellerobe.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
