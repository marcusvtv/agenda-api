package com.ifce.agenda.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String telephone;
	private String city;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "contact_book_id")
	private ContactBook contactBook;

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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public ContactBook getContactBook() {
		return contactBook;
	}

	public void setContactBook(ContactBook contactBook) {
		this.contactBook = contactBook;
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(String name, String telephone, String city) {
		super();
		this.name = name;
		this.telephone = telephone;
		this.city = city;
	}
	
	
	
	

}
