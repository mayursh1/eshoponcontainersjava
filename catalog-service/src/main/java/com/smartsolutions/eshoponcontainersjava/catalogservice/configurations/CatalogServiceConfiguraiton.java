package com.smartsolutions.eshoponcontainersjava.catalogservice.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties() //Todo: Change this to catalog-service once config is checked in
public class CatalogServiceConfiguraiton {
    private String appName;
    private String appVersion;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
}
