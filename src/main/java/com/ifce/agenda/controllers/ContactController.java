package com.ifce.agenda.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.ifce.agenda.models.Contact;
import com.ifce.agenda.models.User;
import com.ifce.agenda.service.ServiceUser;

@Controller
public class ContactController {

	@Autowired
	HttpSession session;
	
	@Autowired
	private ServiceUser serviceUser;

	@GetMapping("/cadastro")
	public ModelAndView cadastroAluno(@ModelAttribute Contact contact) {
		return serviceUser.loggedUserTester(session, "cadastro");
	}
}
