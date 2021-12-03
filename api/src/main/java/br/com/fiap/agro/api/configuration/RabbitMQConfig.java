package br.com.fiap.agro.api.configuration;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;

public class RabbitMQConfig {
    private static CachingConnectionFactory connectionFactory;

    public static CachingConnectionFactory getConnection(){

        if(connectionFactory == null){
            connectionFactory = new CachingConnectionFactory("fox.rmq.cloudamqp.com");//TODO add hostname
            connectionFactory.setUsername("ilnhidka");//TODO add username
            connectionFactory.setPassword("pmvJp3rkp2hJNwNtAIsOR-K0UvczXBtE");//TODO add password
            connectionFactory.setVirtualHost("ilnhidka");//TODO add virtualhost
            //Recommended settings
            connectionFactory.setRequestedHeartBeat(30);
            connectionFactory.setConnectionTimeout(30000);
        }

        return connectionFactory;
    }
}
