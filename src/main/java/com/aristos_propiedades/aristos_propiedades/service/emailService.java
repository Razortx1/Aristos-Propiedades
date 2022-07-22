package com.aristos_propiedades.aristos_propiedades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class emailService {
     //Importante hacer la inyección de dependencia de JavaMailSender:
     @Autowired
     private JavaMailSender javaMailSender;
 
     //Pasamos por parametro: destinatario, asunto y el mensaje
     public void sendEmail(String from, String to, String subject, String body) {
 
         SimpleMailMessage email = new SimpleMailMessage();

         email.setFrom(from);
         email.setTo(to);
         email.setSubject(subject);
         email.setText(body);
 
         javaMailSender.send(email);
     }
}
