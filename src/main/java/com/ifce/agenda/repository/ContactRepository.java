package com.ifce.agenda.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifce.agenda.models.Contact;


public interface ContactRepository extends JpaRepository<Contact, Integer>{
	
	@Query("select x from Contact x where x.name= :name ")
	public List<Contact> findByName(String name);
	
	public Optional<Contact> findById(Integer id);
	

}
