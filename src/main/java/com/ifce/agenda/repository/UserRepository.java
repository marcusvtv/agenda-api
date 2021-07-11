package com.ifce.agenda.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ifce.agenda.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select x from User x where x.username= :username and x.password = :password")
	public User findLogin(String username, String password);
	
	
	@Query("select u from User u where u.id= :id")
	public User findUserById(Integer id);

}
