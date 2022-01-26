package com.smartsolutions.eshoponcontainersjava.catalogservice.controllers;

import com.smartsolutions.eshoponcontainersjava.catalogservice.configurations.CatalogServiceConfiguraiton;
import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogItem;
import com.smartsolutions.eshoponcontainersjava.catalogservice.services.CatalogItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("catalog")
public class CatalogController {
    @Autowired
    CatalogItemService catalogService;

    @GetMapping("/items")
    public List<CatalogItem> getItems() {
        var items =catalogService.getCatalogItems();
        return items;
    }
}
