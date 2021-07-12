package com.ifce.agenda.controllers;

import javax.servlet.http.HttpSession;

import com.ifce.agenda.models.UserAgenda;
import com.ifce.agenda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ifce.agenda.exceptions.ServiceExc;
import com.ifce.agenda.service.ServiceUserAgenda;

@Controller
public class UserAgendaController {

	@Autowired
	private ServiceUserAgenda serviceUserAgenda;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private HttpSession session;

	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login/login");
		mv.addObject("user", new UserAgenda());
		return mv;
	}

	@GetMapping("/index")
	public ModelAndView index(UserAgenda userAgenda) {
		return serviceUserAgenda.loggedUserTester(session, "home/index");
	}

	@GetMapping("/cadastro-usuario")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new UserAgenda());
		mv.setViewName("Login/cadastro-usuario");
		return mv;
	}

	@PostMapping("saveUser")
	public ModelAndView cadastrarUsuario(UserAgenda userAgenda)  {
		ModelAndView mv = new ModelAndView();
		userRepository.save(userAgenda);
		mv.setViewName("Login/login");
		return mv;
	}

	@PostMapping("/index")
	public ModelAndView login(@ModelAttribute UserAgenda userAgenda) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new UserAgenda());
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
		return index(userAgendaLogin);
	}

	@PostMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return login();
	}

}
