package com.ifce.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifce.agenda.models.ContactBook;

public interface ContactBookRepository extends JpaRepository<ContactBook, Integer>{

}
