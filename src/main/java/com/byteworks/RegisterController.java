package com.byteworks;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session; //autowiring session
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegistrationPage(ModelAndView modelAndView){
		modelAndView.setViewName("register");
		return modelAndView;
	}

	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processRegistrationForm(ModelAndView modelAndView,
			@RequestParam Map requestParams) {
		
		String username = (String) requestParams.get("username");
		String password = (String) requestParams.get("password");
		
		if(userService.loadUserByEmail(username) != null) {
			modelAndView.addObject("error", "User already Exits");
			modelAndView.setViewName("register");
			return modelAndView;
		}
		

		List<SimpleGrantedAuthority> authorities = 
				Arrays.asList(new SimpleGrantedAuthority("USER"));
		
		MyUser user2 = new MyUser(username, password, authorities);
		userService.saveUser(user2.getUsername(), user2);
		modelAndView.setViewName("welcome");
		return modelAndView;
	}
	
	@RequestMapping(value = "/welcome-user", method = RequestMethod.GET)
	public ModelAndView welcomeUser(ModelAndView modelAndView) {
		
		modelAndView.setViewName("welcome-user");
		return modelAndView;
	}
	
	
}