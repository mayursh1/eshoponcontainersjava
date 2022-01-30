package com.smartsolutions.eshoponcontainersjava.catalogservice.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.smartsolutions.eshoponcontainersjava.catalogservice.configurations.CatalogServiceConfiguraiton;
import com.smartsolutions.eshoponcontainersjava.catalogservice.events.IntegrationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
public class CatalogIntegrationService {

    @Autowired
    private CatalogServiceConfiguraiton configuration;

    private final static String queue_name = "ProductPriceChanged";

    public CatalogIntegrationService() {


    }

    public void PublishThroughEventBusAsync(IntegrationEvent event) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(configuration.getMqhost());
        factory.setPort(configuration.getMqport());
        var mapper = new ObjectMapper();

        try (Connection connection = factory.newConnection()){
            var channel = connection.createChannel();
            channel.queueDeclare(queue_name,false, false, false, null);
            var  message = mapper.writeValueAsBytes(event);
            channel.basicPublish("", queue_name, null, message);
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
