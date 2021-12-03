package br.com.fiap.agro.api.client;

import br.com.fiap.agro.api.configuration.RabbitMQConfig;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.mail.javamail.JavaMailSender;


public class RabbitMQConsumer {

    RabbitTemplate template = new RabbitTemplate(RabbitMQConfig.getConnection());

    public void consumer(JavaMailSender mailSender){

        SendEmail email = new SendEmail();
        int cont = 1;
        var data = "";
        while(true){

            try {

                byte[] body = this.template.receive("fiapAgro").getBody();

                String response = new String(body);
                var sendEmail = response.substring(response.length() - 2, response.length() - 1 );

                if (sendEmail.equalsIgnoreCase("1")){

                    data += this.hydrateEmailBody(response);
                    cont++;
                    if (cont > 6) {
                        cont = 1;
                        email.sendEmail(data, mailSender);
                        data = "";
                    }



                }else{
                    cont = 1;
                    data = "";
                }
                System.out.println(response);

            } catch (NullPointerException ex){
                System.out.println("fila vazia!");
                continue;
            }
        }
    }

    private String hydrateEmailBody(String response){
        var body = response.replaceAll("SendEmail: 1","<br><br><br>")+"<br>";
        body = body.replaceAll("ID Drone: ","<strong>ID Drone: </strong>");
        body = body.replaceAll("Latitude: ","<br><strong>Latitude: </strong>");
        body = body.replaceAll("Longitude: ","<br><strong>Logintude: </strong>");
        body = body.replaceAll("Umidade: ","<br><strong>Umidade: </strong>");
        body = body.replaceAll("Temperatura: ","<br><strong>Temperatura: </strong>");
        return body;
    }

}



