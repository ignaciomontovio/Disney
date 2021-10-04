package com.DisneyWorld.service;

import java.io.IOException;

import javax.mail.MessagingException;

public interface ISendMailService {
	void sendEmail(String email,String nombre);
	void sendEmailWithAttachment() throws MessagingException, IOException;
}
