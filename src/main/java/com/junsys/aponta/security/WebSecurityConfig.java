package com.junsys.aponta.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.junsys.aponta.repository.UserRepository;
import com.junsys.aponta.service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserRepository userRepository;

	@Bean
	public UserDetailsService userDetailsServiceImpl() {
		return new UserDetailsServiceImpl(userRepository);
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl()).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/home/**").permitAll()
				//.antMatchers("/usuario/edit/**").hasRole("ENG_COMP")
				.antMatchers("/static/favicon.ico").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/usuario/picador", true)
				.permitAll()
				.and()
				.logout()
				
				.permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		;
	}
	/*
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/home/**")
			.permitAll()
		.anyRequest()
			.authenticated()
		.and()
		.formLogin(form -> form
            .loginPage("/login")
            .defaultSuccessUrl("/usuario/picador", true)
            .permitAll()
        )
		.logout(logout -> {
			logout.logoutUrl("/logout")
				.logoutSuccessUrl("/login");
		}).csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		/*
		UserDetails user =
				 User.builder()
				.username("agnaldo")
					.password(encoder.encode("5544690"))
					.roles("ADM")
					.build();
		
		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(encoder)
			;//.withUser(user);
		
		
		
//		UserDetails user =
//				 User.builder()
//					.username("maria")
//					.password(encoder.encode("maria"))
//					.roles("ADM")
//					.build();
	}
	*/
}
