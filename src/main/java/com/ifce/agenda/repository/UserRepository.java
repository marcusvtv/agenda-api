package com.ifce.agenda.repository;

import com.ifce.agenda.models.UserAgenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserAgenda, Integer> {
	
	@Query("select x from UserAgenda x where x.username= :username and x.password = :password")
	public UserAgenda findLogin(String username, String password);
	
	
	@Query("select u from UserAgenda u where u.id= :id")
	public UserAgenda findUserById(Integer id);

}
