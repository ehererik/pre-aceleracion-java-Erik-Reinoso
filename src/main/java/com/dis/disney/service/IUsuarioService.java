package com.dis.disney.service;

import com.dis.disney.dto.UsuarioDto;
import com.dis.disney.model.Usuario;

public interface IUsuarioService {
	public Usuario findByUsername(String username);
	public Usuario save(UsuarioDto usuarioDto);
}