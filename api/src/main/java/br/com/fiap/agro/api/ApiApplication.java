package br.com.fiap.agro.api;

import br.com.fiap.agro.api.client.RabbitMQConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Autowired
	private JavaMailSender mailSender;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}


	@Override
	public void run(String... args ) throws Exception {
		RabbitMQConsumer rabbitMQConsumer = new RabbitMQConsumer();
		rabbitMQConsumer.consumer(mailSender);
	}

}
