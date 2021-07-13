package com.ifce.agenda.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ifce.agenda.models.Contact;
import com.ifce.agenda.models.ContactBook;
import com.ifce.agenda.models.UserAgenda;
import com.ifce.agenda.repository.ContactRepository;

@Service
public class ServiceContact {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private ServiceUserAgenda serviceUserAgenda;
	
	@Autowired
	private ContactRepository contactRepository;
	
	public void saveContact(Contact contact) throws Exception {
		
		UserAgenda userAgenda = serviceUserAgenda.loggedUser(session);
		ContactBook contactBook = userAgenda.getContactBook();
		contact.setContactBook(contactBook);
		
		
		/*
		 * try { // if(userRepository.findByEmail() != null) { // throw new
		 * EmailExistsException("Já existe um email cadastrado para: "+
		 * user.getEmail()); // } user.setPassword(user.getPassword());
		 * //user.setPassword(Util.md5(user.getPassword())); } catch
		 * (NoSuchAlgorithmException e) { throw new
		 * CriptoExistException("Erro na criptografia da senha"); }
		 */
		contactRepository.save(contact);

	}

	public Page<Contact> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
				Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.contactRepository.findAll(pageable);
	}
	

}
