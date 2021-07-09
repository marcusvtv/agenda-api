package com.ifce.agenda.controllers;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ifce.agenda.exceptions.ServiceExc;
import com.ifce.agenda.models.User;

import com.ifce.agenda.repository.UserRepository;
import com.ifce.agenda.service.ServiceUser;
import com.ifce.agenda.util.Util;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ServiceUser serviceUser;
	
	
	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("Login/login");
		mv.addObject("user", new User());
		return mv;
	}
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/index");
		return mv;
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
		//userRepository.save(user);
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
			return mv;
		}
		return index();
	}
	

}
