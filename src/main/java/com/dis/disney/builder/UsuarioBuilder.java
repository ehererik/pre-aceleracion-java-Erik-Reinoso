package com.dis.disney.builder;

import com.dis.disney.dto.UsuarioDto;
import com.dis.disney.model.Usuario;

public class UsuarioBuilder {
	private String name;
	private String lastName;
	private String mail;
	private String username;
	private String password;

	public UsuarioBuilder() {
	}
	public UsuarioBuilder withUsuarioDto(UsuarioDto usDTO) {
		name=usDTO.getName();
		lastName= usDTO.getLastName();
		mail= usDTO.getMail();
		username =usDTO.getUsername();
		password = usDTO.getPassword();
		return this;
	}
	
	public Usuario build() {
		Usuario us = new Usuario();
		us.setLastName(lastName);
		us.setMail(mail);
		us.setName(name);
		us.setPassword(password);
		us.setUsername(username);
		return us;
	}

}
