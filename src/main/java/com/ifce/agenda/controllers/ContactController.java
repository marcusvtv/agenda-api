package com.ifce.agenda.controllers;

import javax.servlet.http.HttpSession;

import com.ifce.agenda.models.UserAgenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ifce.agenda.models.Contact;
import com.ifce.agenda.models.ContactBook;
import com.ifce.agenda.repository.ContactBookRepository;
import com.ifce.agenda.service.ServiceContact;
import com.ifce.agenda.service.ServiceUserAgenda;

@Controller
public class ContactController {

	@Autowired
	HttpSession session;
	
	@Autowired
	private ServiceUserAgenda serviceUserAgenda;
	
	@Autowired
	private ServiceContact serviceContact;
	
	@Autowired
	ContactBookRepository contactBookRepository;

	@GetMapping("/cadastro")
	public ModelAndView cadastroAluno(@ModelAttribute Contact contact) {
		return serviceUserAgenda.loggedUserTester(session, "cadastro");
	}
	
	@PostMapping("/cadastrocompleto")
	public ModelAndView cadastroConcluido(@ModelAttribute Contact contact) throws Exception {
		
		System.out.println(contact.getCity());
		System.out.println(contact.getName());
		System.out.println(contact.getTelephone());
		UserAgenda userAgenda = serviceUserAgenda.loggedUser(session);
		System.out.println(userAgenda.getContactBook().getId().toString()+" id do contactbook do usuario logado");
		contact.setContactBook(userAgenda.getContactBook());
		System.out.println(contact.getContactBook().getId().toString() +" id do contactbook do contato apos atribuição");
//		serviceContact.saveContact(contact);		
		serviceUserAgenda.loggedUserTester(session, "cadastro");
		UserAgenda userAgenda2 = serviceUserAgenda.getLoggedUser(session);
		System.out.println(userAgenda2.getContactBook().getId().toString()+" e-mail do do usuario2 logado");
		
		//aqui esta o ouro
		ContactBook contactBook = userAgenda2.getContactBook();
		contactBook.insertContact(contact);
		contactBookRepository.save(contactBook);
		
		
		
		return serviceUserAgenda.loggedUserTester(session, "cadastro");
	}
}
