package com.ifce.agenda.service;

import javax.servlet.http.HttpSession;

import com.ifce.agenda.models.UserAgenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ifce.agenda.exceptions.ServiceExc;
import com.ifce.agenda.repository.UserRepository;

@Service
public class ServiceUserAgenda {
	
	@Autowired
	HttpSession session;
		
	@Autowired
	private UserRepository userRepository;

	public void saveUser(UserAgenda userAgenda) throws Exception {
		/*
		 * try { // if(userRepository.findByEmail() != null) { // throw new
		 * EmailExistsException("Já existe um email cadastrado para: "+
		 * user.getEmail()); // } user.setPassword(user.getPassword());
		 * //user.setPassword(Util.md5(user.getPassword())); } catch
		 * (NoSuchAlgorithmException e) { throw new
		 * CriptoExistException("Erro na criptografia da senha"); }
		 */
		userRepository.save(userAgenda);

	}
	
	public UserAgenda getLoggedUser(HttpSession session) {
		Integer userId = ((UserAgenda) session.getAttribute("userLogado")).getId();
		return userRepository.findUserById(userId);
		
	}
	
	public UserAgenda loggedUser(HttpSession session) {
		return (UserAgenda) session.getAttribute("userLogado");
		
	}

	public UserAgenda loginUser(String username, String password) throws ServiceExc {
		UserAgenda userAgendaLogin = this.userRepository.findLogin(username, password);
		if (userAgendaLogin == null) {
			throw new ServiceExc("Usuário ou senha inválidos!");
		}
		return userAgendaLogin;
	}

	public boolean loggedUserTester(HttpSession session){
		if (session.getAttribute("userLogado") != null){
			return true;
		} else {
			return false;
		}
	}

	public ModelAndView loggedUserTestAndRedirect(HttpSession session, String destinoSucesso) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("userLogado") != null) {
			mv.setViewName(destinoSucesso); // destino caso tenha usuário logado
		} else {
			mv.setViewName("redirect:/"); // destino caso não tenha usuario logado
		}
		return mv;
	}

}
