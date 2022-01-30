package com.smartsolutions.eshoponcontainersjava.catalogservice.services;

import com.smartsolutions.eshoponcontainersjava.catalogservice.events.IntegrationEvent;
import org.springframework.stereotype.Service;

@Service
public class CatalogIntegrationService {

    public void PublishThroughEventBusAsync(IntegrationEvent event) {
        //TODO: Implement this later on
    }
}
