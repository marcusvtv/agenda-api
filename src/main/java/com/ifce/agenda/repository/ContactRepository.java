package com.ifce.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifce.agenda.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{
	
	

}
