package br.com.fiap.agro.api.client;


import br.com.fiap.agro.api.configuration.RabbitMQConfig;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitMQProducer {
    public void send(String mensagem){
        var connection = RabbitMQConfig.getConnection();
        //Set up queue, exchanges and bindings
        RabbitAdmin admin = new RabbitAdmin(connection);
        Queue fiapAgro = new Queue("fiapAgro");

        final String exchange = "exchange.fiapAgro";

        admin.declareQueue(fiapAgro);

        DirectExchange exchangeTorcedor = new DirectExchange(exchange);
        admin.declareExchange(exchangeTorcedor);

        admin.declareBinding(BindingBuilder.bind(fiapAgro).to(exchangeTorcedor).with("fiapAgro"));

        RabbitTemplate template = new RabbitTemplate(connection);

        template.convertAndSend(exchange, "fiapAgro", mensagem);
    }

    public void trackingProducer(String mensagem){
        var connection = RabbitMQConfig.getConnection();
        //Set up queue, exchanges and bindings
        RabbitAdmin admin = new RabbitAdmin(connection);
        Queue fiapAgro = new Queue("tracking");

        final String exchange = "exchange.fiapAgro";

        admin.declareQueue(fiapAgro);

        DirectExchange exchangeTorcedor = new DirectExchange(exchange);
        admin.declareExchange(exchangeTorcedor);

        admin.declareBinding(BindingBuilder.bind(fiapAgro).to(exchangeTorcedor).with("tracking"));

        RabbitTemplate template = new RabbitTemplate(connection);

        template.convertAndSend(exchange, "tracking", mensagem);
    }
}
