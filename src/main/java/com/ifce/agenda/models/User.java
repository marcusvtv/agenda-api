package com.ifce.agenda.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Email
	private String email;
	@Size(min=3, max=20, message = "Username deve ter entre 3 e 20 caracteres")
	private String username;
	private String password;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_book_id")
	private ContactBook contactBook = new ContactBook();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ContactBook getContactBook() {
		return contactBook;
	}
	public void setContactBook(ContactBook contactBook) {
		this.contactBook = contactBook;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	public User(String email, String username, String password) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.name = username;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

}
