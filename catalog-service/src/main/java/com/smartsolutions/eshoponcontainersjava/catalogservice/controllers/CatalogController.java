package com.smartsolutions.eshoponcontainersjava.catalogservice.controllers;

import com.smartsolutions.eshoponcontainersjava.catalogservice.configurations.CatalogServiceConfiguraiton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController()
public class CatalogController {

    @Autowired
    CatalogServiceConfiguraiton properties;

    @GetMapping(path = "items")
    public List<String> getItems() {
        var list = new ArrayList<String>();
        list.add(properties.getAppName());
        list.add(properties.getAppVersion());
        return list;
    }
}
