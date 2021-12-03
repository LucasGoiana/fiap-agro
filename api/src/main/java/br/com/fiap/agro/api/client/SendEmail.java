package br.com.fiap.agro.api.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service

public class SendEmail {

    public String sendEmail(String information, JavaMailSender mailSender){

        try {

            StringBuilder email = new StringBuilder("<h1>Alerta de Umidade e Temperatura</h1><p>");
            email.append(information).append("</p>");
            MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper( mail );
            helper.setTo( "lucasgoianam@hotmail.com" );
            helper.setFrom("send@lucasgoiana.com");
            helper.setSubject( "Email de Alerta" );



            helper.setText(email.toString(), true);
            mailSender.send(mail);
            System.out.println("Enviado");;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "a";

    }
}
