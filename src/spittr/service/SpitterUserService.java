package spittr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import spittr.data.Spitter;
import spittr.data.SpitterRepository;

public class SpitterUserService implements UserDetailsService {

	private final SpitterRepository spitterRepository;

	public SpitterUserService(SpitterRepository spitterRepository) {

		this.spitterRepository = spitterRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Spitter spitter = spitterRepository.findByUsername(username);

		System.out.println(spitter);
		if (spitter != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

			authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));

			return new User(spitter.getLogin(), spitter.getPassword(), authorities);

		}

		throw new UsernameNotFoundException("User " + username + " not found");
	}

}
