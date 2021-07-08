package com.ifce.agenda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ifce.agenda.models.User;

import com.ifce.agenda.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("Login/login");
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
	public ModelAndView cadastrar(User user) {
		ModelAndView mv = new ModelAndView();
		userRepository.save(user);
		mv.setViewName("redirect:/");
		return mv;
		
	}

}
