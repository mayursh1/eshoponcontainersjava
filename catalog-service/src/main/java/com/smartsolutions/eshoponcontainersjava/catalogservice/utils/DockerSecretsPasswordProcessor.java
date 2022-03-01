package com.smartsolutions.eshoponcontainersjava.catalogservice.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Properties;

public class DockerSecretsPasswordProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Properties props = new Properties();
        enrichResource("/run/secrets/catalogdbrootpassword", "spring.datasource.password", props);
        enrichResource("/run/secrets/sslkeystorepassword", "server.ssl.key-store-password", props);
        environment.getPropertySources().addLast(new PropertiesPropertySource("secretProps", props));

    }

    private void enrichResource(String resourcePath, String propName, Properties props) {
        Resource resource = new FileSystemResource(resourcePath);
        if (resource.exists()) {
            try {
                String secret = StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());
                props.put(propName, secret);
            } catch (IOException e) {
                System.out.println(e.toString());
                throw new RuntimeException(e);
            }
        }

    }
}
