package com.ifce.agenda.models;

import org.springframework.data.domain.*;

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
		contact.setContactBook(this);
		this.contact.add(contact);
	}

	public Page<Contact> getContactPaged(Integer pageNo, Integer pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
				Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		final int start = (int)pageable.getOffset();
		final int end = Math.min((start + pageable.getPageSize()), contact.size());
		final Page<Contact> page = new PageImpl<>(contact.subList(start, end), pageable, contact.size());

		return page;
	}

}
