package spittr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import spittr.data.SpitterRepository;
import spittr.service.SpitterUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	SpitterRepository spitterRepository;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(new SpitterUserService(spitterRepository));
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.rememberMe()
			.tokenValiditySeconds(2419200)
		.and()
		.formLogin()
			.loginPage("/login")
		.and()
		.httpBasic()
			.realmName("Spitter")
		.and()
			.authorizeRequests()
				.antMatchers("/spitter/me").authenticated()
				.antMatchers(HttpMethod.POST, "/spittles").hasRole("SPITTER")
				.anyRequest().permitAll()
				
			.and().requiresChannel()
				.antMatchers("spitter/register").requiresSecure()
				.antMatchers("/").requiresInsecure();
		
				

	}
	
	

}
