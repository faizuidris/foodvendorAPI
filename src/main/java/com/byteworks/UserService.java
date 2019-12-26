package com.byteworks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
	public static Map<String, MyUser> users = new HashMap<>();

	
	public UserService() {
		List<SimpleGrantedAuthority> authorities = 
				Arrays.asList(new SimpleGrantedAuthority("ADMIN"));
		
		MyUser adminUser  = new MyUser("admin@example.com", "password", authorities);
		users.put(adminUser.getUsername(), adminUser);
	
	}
	
	public Map<String, MyUser> getAllUsers() {
		return users;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser user3 = users.get(username);
		
		if(user3 == null) {
			throw new UsernameNotFoundException("Not found");
		} else {
			return user3;
		}
	
	}
	
	public UserDetails loadUserByEmail(String username) {
		return users.get(username);
	}
	
	public void saveUser(String username, MyUser userA) {
		users.put(username, userA);
	}
	
	
}
