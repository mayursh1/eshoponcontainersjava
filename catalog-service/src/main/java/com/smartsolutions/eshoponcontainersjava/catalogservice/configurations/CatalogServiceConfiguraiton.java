package com.smartsolutions.eshoponcontainersjava.catalogservice.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties() //Todo: Change this to catalog-service once config is checked in
@Getter
@Setter
public class CatalogServiceConfiguraiton {
    private String appName;
    private String appVersion;
    private String mqhost;
    private int mqport;
}
