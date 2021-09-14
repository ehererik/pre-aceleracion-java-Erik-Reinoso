package com.dis.disney.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.dis.disney.model.Usuario;
import com.dis.disney.service.ISendMailService;

@Service
public class ISendMailServiceImpl implements ISendMailService{
	@Autowired
	private JavaMailSender mailSender;
	public ISendMailServiceImpl()  {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sendEmail(Usuario usuario) {
		SimpleMailMessage MailMessage = new SimpleMailMessage();
		MailMessage.setTo(usuario.getMail());
		MailMessage.setSubject("Bienvenido");
		MailMessage.setText("Su cuenta a sido creada con exito");
		mailSender.send(MailMessage);
		
	}

}
