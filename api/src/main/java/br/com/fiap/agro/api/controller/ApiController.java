package br.com.fiap.agro.api.controller;


import br.com.fiap.agro.api.client.SendEmail;
import br.com.fiap.agro.api.dto.DatasDto;
import br.com.fiap.agro.api.dto.EmailDatasDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;
import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired private JavaMailSender mailSender;

    @PostMapping("/")
    public String sendEmail(@RequestBody String information){
        try {
            JSONObject jsonObject = new JSONObject(information);
            JSONArray jsonArray = new JSONArray(jsonObject.get("SendEmail").toString());
            StringBuilder email = new StringBuilder("<h1>Alerta de Umidade e Temperatura</h1><p>");
                for (int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject2 = new JSONObject(jsonArray.get(i).toString());
                    email.append("ID do Drone: ").append(jsonObject2.get("id_drone")).append("<br>").append("\n");
                    email.append("Latitude: ").append(jsonObject2.get("latitude")).append("<br>").append("\n");
                    email.append("Longitude: ").append(jsonObject2.get("longitude")).append("<br>").append("\n");
                    email.append("Umidade: ").append(jsonObject2.get("umidade")).append("<br>").append("\n");
                    email.append("Temperatura: ").append(jsonObject2.get("temperatura")).append("<br><br><br>").append("\n");
                }

                email.append("</p>");
            MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper( mail );
            helper.setTo( "lucasgoianam@hotmail.com" );
            helper.setFrom("send@lucasgoiana.com");
            helper.setSubject( "Email de Alerta" );



            helper.setText(email.toString(), true);
            mailSender.send(mail);

            return "OK";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar e-mail";
        }

    }
}
