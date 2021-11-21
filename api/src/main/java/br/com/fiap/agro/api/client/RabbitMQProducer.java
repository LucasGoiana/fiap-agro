package br.com.fiap.agro.api.client;


import br.com.fiap.agro.api.configuration.RabbitMQConfig;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitMQ   {
    public String send(String mensagem){
        var connection = RabbitMQConfig.getConnection();
        //Set up queue, exchanges and bindings
        RabbitAdmin admin = new RabbitAdmin(connection);
        Queue queueSPFC = new Queue("teste");

        final String exchange = "exchange.teste";

        admin.declareQueue(queueSPFC);

        DirectExchange exchangeTorcedor = new DirectExchange(exchange);
        admin.declareExchange(exchangeTorcedor);

        admin.declareBinding(BindingBuilder.bind(queueSPFC).to(exchangeTorcedor).with("spfc"));

        RabbitTemplate template = new RabbitTemplate(connection);

        template.convertAndSend(exchange, "spfc", "teste");

        return "i";
    }
}
