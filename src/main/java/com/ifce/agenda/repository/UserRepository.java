package com.ifce.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifce.agenda.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select x from User x where x.username= :username and x.password = :password")
	public User findLogin(String username, String password);

}
