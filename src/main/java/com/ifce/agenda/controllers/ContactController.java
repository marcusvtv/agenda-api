package com.ifce.agenda.controllers;

import javax.servlet.http.HttpSession;

import com.ifce.agenda.models.UserAgenda;
import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ifce.agenda.models.Contact;
import com.ifce.agenda.models.ContactBook;
import com.ifce.agenda.repository.ContactBookRepository;
import com.ifce.agenda.service.ServiceContact;
import com.ifce.agenda.service.ServiceUserAgenda;

import java.util.List;

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
		return serviceUserAgenda.loggedUserTestAndRedirect(session, "cadastro");
	}
	
	@PostMapping("/cadastrocompleto")
	public ModelAndView cadastroConcluido(@ModelAttribute Contact contact) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("contact", new Contact());
		if (serviceUserAgenda.loggedUserTester(session)){
			UserAgenda userAgenda = serviceUserAgenda.getLoggedUser(session);
			ContactBook contactBook = userAgenda.getContactBook();
			contactBook.insertContact(contact);
			contactBookRepository.save(contactBook);
			mv.addObject("cadastroenviado", "enviado com sucesso");
			mv.setViewName("cadastro");
		} else{
			mv.setViewName("/");
		}
		return mv;
	}

	@GetMapping ("/deleteContact/{id}")
	public ModelAndView deleteContact(@PathVariable (value = "id") Integer id) {
		ModelAndView mv = new ModelAndView();
		if (serviceUserAgenda.loggedUserTester(session)){
			UserAgenda userAgenda = serviceUserAgenda.getLoggedUser(session);
			ContactBook contactBook = userAgenda.getContactBook();
			if (contactBook.deleteContactByID(id)){
				contactBookRepository.save(contactBook);
				mv.addObject("contatoapagado", "apagado com sucesso");

			} else{
				mv.addObject("contatoapagado", "erro ao tentar apagar o contato");
			}
			mv.setViewName("home/index");
		}else{
			mv.setViewName("redirect:/");
		}
		return mv;
	}




}
