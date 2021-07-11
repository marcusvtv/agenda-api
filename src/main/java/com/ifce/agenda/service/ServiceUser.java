package com.ifce.agenda.service;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ifce.agenda.exceptions.CriptoExistException;
import com.ifce.agenda.exceptions.EmailExistsException;
import com.ifce.agenda.exceptions.ServiceExc;
import com.ifce.agenda.models.User;
import com.ifce.agenda.repository.UserRepository;
import com.ifce.agenda.util.Util;

@Service
public class ServiceUser {

	@Autowired
	private UserRepository userRepository;

	public void saveUser(User user) throws Exception {
		/*
		 * try { // if(userRepository.findByEmail() != null) { // throw new
		 * EmailExistsException("Já existe um email cadastrado para: "+
		 * user.getEmail()); // } user.setPassword(user.getPassword());
		 * //user.setPassword(Util.md5(user.getPassword())); } catch
		 * (NoSuchAlgorithmException e) { throw new
		 * CriptoExistException("Erro na criptografia da senha"); }
		 */
		userRepository.save(user);

	}

	public User loginUser(String username, String password) throws ServiceExc {
		User userLogin = this.userRepository.findLogin(username, password);
		if (userLogin == null) {
			throw new ServiceExc("Usuário ou senha inválidos!");
		}
		return userLogin;
	}

	public ModelAndView loggedUserTester(HttpSession session, String destinoSucesso) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("userLogado") != null) {
			mv.setViewName(destinoSucesso); // destino caso tenha usuário logado
		} else {
			mv.setViewName("redirect:/"); // destino caso não tenha usuario logado
		}
		return mv;
	}

}
