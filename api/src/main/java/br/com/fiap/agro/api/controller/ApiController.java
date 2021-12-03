package br.com.fiap.agro.api.controller;


import br.com.fiap.agro.api.client.RabbitMQConsumer;
import br.com.fiap.agro.api.client.RabbitMQProducer;
import br.com.fiap.agro.api.dto.LocaltionDTO;
import br.com.fiap.agro.api.service.LocationService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired private JavaMailSender mailSender;
    private final LocationService createLocationService;

    public ApiController(LocationService createLocationService) {
        this.createLocationService = createLocationService;
    }

    @PostMapping("/producerRabbitMq/")
    public String sendRabbitMQ(@RequestBody String information){

        JSONObject jsonObject = new JSONObject(information);
        JSONArray jsonArray = new JSONArray(jsonObject.get("RabbitMQ").toString());
        JSONObject jsonObject2 = new JSONObject(jsonArray.get(0).toString());
        String  body =
                "ID Drone: " +  jsonObject2.get("id_drone").toString()
                + "\nLatitude: " +  jsonObject2.get("latitude").toString()
                + "\nLongitude: " +  jsonObject2.get("longitude").toString()
                + "\nUmidade: " +  jsonObject2.get("umidade").toString()
                + "\nTemperatura: " + jsonObject2.get("temperatura")
                +"\nSendEmail: " + jsonObject2.get("disparaEmail")+"\n";

        RabbitMQProducer rabbitMQProducer = new RabbitMQProducer();
        rabbitMQProducer.send(body);
        return "oi";
    }

    @GetMapping("/consumerRabbitMQ")
    public void consumer(){
        RabbitMQConsumer rabbitMQConsumer = new RabbitMQConsumer();
        rabbitMQConsumer.consumer(mailSender);

    }

    @PostMapping("/tracking/")
    public LocaltionDTO makeTracking(@RequestBody LocaltionDTO localtionDTO){
        return createLocationService.makeTracking(localtionDTO);
    }

    @GetMapping("/tracking/{idDrone}")
    public LocaltionDTO getTracking(@PathVariable String idDrone){

        return createLocationService.getTracking(idDrone);

    }
}
