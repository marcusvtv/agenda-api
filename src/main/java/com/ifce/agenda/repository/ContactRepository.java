package com.ifce.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifce.agenda.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
