package com.ifce.agenda.controllers;

import javax.servlet.http.HttpSession;

import com.ifce.agenda.models.Contact;
import com.ifce.agenda.models.UserAgenda;
import com.ifce.agenda.repository.UserRepository;
import com.ifce.agenda.service.ServiceContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ifce.agenda.exceptions.ServiceExc;
import com.ifce.agenda.service.ServiceUserAgenda;

import java.util.List;

@Controller
public class UserAgendaController {

	@Autowired
	private ServiceUserAgenda serviceUserAgenda;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private HttpSession session;

	@Autowired
	ServiceContact serviceContact;

	@GetMapping("/")
	public ModelAndView login() {
		if (serviceUserAgenda.loggedUserTester(session)){
			return index();
		} else{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("Login/login");
			mv.addObject("userAgenda", new UserAgenda());
			return mv;
		}

	}
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		if (serviceUserAgenda.loggedUserTester(session)){
			return viewHomePage(mv);
		}
		else{
			return login();
		}

	}

	public ModelAndView viewHomePage(ModelAndView mv) {
		if (serviceUserAgenda.loggedUserTester(session)){
			return findPaginated(1, mv);
		}else{
			mv.setViewName("Login/login");
			return mv;
		}
	}

	@GetMapping("/page/{pageNo}")
	public ModelAndView findPaginated(@PathVariable(value = "pageNo") int pageNo,ModelAndView mv) {

		int pageSize = 5;

		String sortField = "name";
		String sortDir = "asc";


		Page<Contact> page = serviceContact.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Contact> listContact = page.getContent();

		mv.addObject("currentPage", pageNo);
		mv.addObject("totalPages", page.getTotalPages());
		mv.addObject("totalItems", page.getTotalElements());
		mv.addObject("sortField", sortField);
		mv.addObject("sortDir", sortDir);
		mv.addObject("listContact", listContact);

		mv.setViewName("home/index");
		return mv;

	}



	@GetMapping("/cadastro-usuario")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userAgenda", new UserAgenda());
		mv.setViewName("Login/cadastro-usuario");
		return mv;
	}

	@PostMapping("saveUser")
	public ModelAndView cadastrarUsuario(UserAgenda userAgenda)  {
		ModelAndView mv = new ModelAndView();
		userRepository.save(userAgenda);
		mv.setViewName("redirect:/");
		return mv;
	}

	@PostMapping("/index")
	public ModelAndView login(@ModelAttribute UserAgenda userAgenda) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userAgenda", new UserAgenda());
		UserAgenda userAgendaLogin;
		try {
			userAgendaLogin = this.serviceUserAgenda.loginUser(userAgenda.getUsername(), userAgenda.getPassword());
			session.setAttribute("userLogado", userAgendaLogin);
			session.getAttribute("userLogado");
			System.out.println(userAgendaLogin.getEmail()+" "+ userAgendaLogin.getId()+" "+ userAgendaLogin.getContactBook().getId());
		} catch (ServiceExc e) {
			mv.addObject("msgLoginErro", e.getMessage());
			mv.setViewName("Login/login");
			System.out.println(e.getMessage());
			return mv;
		}
		return index();
	}

	@PostMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return login();
	}

}
