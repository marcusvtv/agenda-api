package com.ifce.agenda.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	

}
