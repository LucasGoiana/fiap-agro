package br.com.fiap.agro.api.configuration;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;

public class RabbitMQConfig {
    private static CachingConnectionFactory connectionFactory;

    public static CachingConnectionFactory getConnection(){

        if(connectionFactory == null){
            connectionFactory = new CachingConnectionFactory("clam.rmq.cloudamqp.com");//TODO add hostname
            connectionFactory.setUsername("uymxsaau");//TODO add username
            connectionFactory.setPassword("jhEo4pivjk7sdKzlx4JKWTOe6G650RxP");//TODO add password
            connectionFactory.setVirtualHost("uymxsaau");//TODO add virtualhost
            //Recommended settings
            connectionFactory.setRequestedHeartBeat(30);
            connectionFactory.setConnectionTimeout(30000);
        }

        return connectionFactory;
    }
}
