package com.byteworks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
public class AuthenticationConfiguration 
	extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	AuthenticationSuccessHandler authenticationSuccessHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) 
			throws Exception {
		auth.userDetailsService(userService);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests()
        //    .antMatchers("/register").permitAll()
        //   .antMatchers("/**").hasAnyRole("USER", "ADMIN").and().formLogin();
		
		
		http
        .authorizeRequests()
            .antMatchers("/resources/**", "/register").permitAll()
            .anyRequest().authenticated()
            .antMatchers("/orders").hasRole("ADMIN")
            .and()
        .formLogin()
            .permitAll().successHandler(authenticationSuccessHandler)
            .and()
        .logout()
            .permitAll();
    }

}
