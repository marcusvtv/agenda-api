package com.ifce.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifce.agenda.models.ContactBook;

@Repository
public interface ContactBookRepository extends JpaRepository<ContactBook, Integer>{

}
