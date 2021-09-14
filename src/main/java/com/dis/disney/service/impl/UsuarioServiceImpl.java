package com.dis.disney.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dis.disney.builder.UsuarioBuilder;
import com.dis.disney.dto.UsuarioDto;
import com.dis.disney.model.Usuario;
import com.dis.disney.repository.UsuarioRepository;
import com.dis.disney.service.ISendMailService;
import com.dis.disney.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ISendMailService sendMailService;
	
	@Override
	public Usuario findByUsername(String username) {
		Usuario usuario = usuarioRepository.findByUsername(username);
		return usuario;
	}

	@Override
	public Usuario save(UsuarioDto usuarioDto) {
		Usuario usuario = new UsuarioBuilder().withUsuarioDto(usuarioDto).build();
		usuario = usuarioRepository.save(usuario);
		sendMailService.sendEmail(usuario);
		return usuario;
	}

}

