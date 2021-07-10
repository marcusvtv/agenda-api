package com.ifce.agenda.controllers;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ifce.agenda.exceptions.ServiceExc;
import com.ifce.agenda.models.Contact;
import com.ifce.agenda.models.User;
import com.ifce.agenda.repository.ContactBookRepository;
import com.ifce.agenda.repository.ContactRepository;
import com.ifce.agenda.service.ServiceUser;

@Controller
public class UserController {
	
	@Autowired
	private ServiceUser serviceUser;
	
	@Autowired 
	ContactRepository contactRepository;
	
	@Autowired 
	ContactBookRepository contactBookRepository;
	
	
	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("Login/login");
		mv.addObject("user", new User());
		return mv;
	}
	
	@GetMapping("/index")
	public ModelAndView index(User user, HttpSession session) {
		ModelAndView mv= new ModelAndView();
		
		if (session.getAttribute("userLogado")==null) {
			mv.setViewName("redirect:/");
			return mv;
		}
		else {
			Contact novoContato = new Contact(null,"Giselle","982000556","Fortaleza", null);
			user.getContactBook().insertContact(novoContato);
			contactBookRepository.save(user.getContactBook());
			mv.setViewName("home/index");
			return mv;
		}
	}
	
	@GetMapping("/cadastro")
	public ModelAndView cadastrar() {
		ModelAndView mv= new ModelAndView();
		mv.addObject("user", new User());
		mv.setViewName("Login/cadastro");
		return mv;
	}
	
	@PostMapping("saveUser")
	public ModelAndView cadastrar(User user) throws Exception{
		ModelAndView mv = new ModelAndView();
		serviceUser.saveUser(user);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@PostMapping("/index")
	public ModelAndView login(@ModelAttribute User user, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user",new User());
		User userLogin;
		try {
			userLogin = this.serviceUser.loginUser(user.getUsername(), user.getPassword());
			session.setAttribute("userLogado", userLogin);
			session.getAttribute("userLogado");
		}catch (ServiceExc e) {
			mv.addObject("msgLoginErro",e.getMessage());
			mv.setViewName("Login/login");
			System.out.println(e.getMessage());
			return mv;
		}
		return index(userLogin, session);
	}
	
	@PostMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return login();
	}
	

}
