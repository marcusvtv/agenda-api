package com.ifce.agenda.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_book_id")
	private ContactBook contactBook = new ContactBook();
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return name;
	}
	public void setNome(String nome) {
		this.name = nome;
	}
	public String getTelefone() {
		return telephone;
	}
	public void setTelefone(String telefone) {
		this.telephone = telefone;
	}
	public String getCidade() {
		return city;
	}
	public void setCidade(String cidade) {
		this.city = cidade;
	}
	
	
		public ContactBook getContactBook() {
		return contactBook;
	}
	public void setContactBook(ContactBook contactBook) {
		this.contactBook = contactBook;
	}
	
	public Contact(Integer id, String nome, String telefone, String cidade, ContactBook contactBook) {
		super();
		this.id = id;
		this.name = nome;
		this.telephone = telefone;
		this.city = cidade;
		this.contactBook = contactBook;
	}
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
