package com.ifce.agenda.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ContactBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Contact> contact = new ArrayList<Contact>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Contact> getContact() {
		return contact;
	}

	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}

	public ContactBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactBook(Integer id, String name, List<Contact> contact) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
	}
	
	public void insertContact(Contact contact) {
		this.contact.add(contact);
	}
	

}
