package com.dis.disney.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dis.disney.model.Usuario;
import com.dis.disney.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsuarioRepository usuarioRepository;
	public UserDetailsServiceImpl() {
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user=usuarioRepository.findByUsername(username);
		UserBuilder userBuilder = null;
		if(user!=null) {
			userBuilder=User.withUsername(username);
			userBuilder.disabled(false);
			userBuilder.password(user.getPassword());
			userBuilder.authorities(new SimpleGrantedAuthority("ROl_USER"));
		}
		else
			throw new UsernameNotFoundException("Usuario no registrado");
		return userBuilder.build();
	}

}
