package com.ifce.agenda.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ContactBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@OneToMany(mappedBy = "contactBook", cascade = CascadeType.ALL)
	private List<Contact> contactList = new ArrayList<Contact>();

	public void insertContact(Contact contato) {
		contato.setContactBook(this);
		contactList.add(contato);
	}
	
	public Contact getContact(Integer id) {
		return this.getContactList().get(id); //modificar para retornar dado um id
	}
	
	
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

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public ContactBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactBook(Integer id, String name, List<Contact> contactList) {
		super();
		this.id = id;
		this.name = name;
		this.contactList = contactList;
	}
	
	
	
	
	
	
}
