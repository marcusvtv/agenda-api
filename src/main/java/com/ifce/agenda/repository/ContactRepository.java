package com.ifce.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifce.agenda.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

//    @Query("select c from Contact c where UPPER(c.name) like UPPER(CONCAT('%', :name, '%')) and c.contact order by c.name")
//    public List<Contact> findByNameContainingIgnoreCase(String name);
	
	

}
