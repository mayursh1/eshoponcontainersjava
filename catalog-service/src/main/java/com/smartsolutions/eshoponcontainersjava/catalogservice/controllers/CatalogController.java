package com.smartsolutions.eshoponcontainersjava.catalogservice.controllers;

import com.smartsolutions.eshoponcontainersjava.catalogservice.configurations.CatalogServiceConfiguraiton;
import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogItem;
import com.smartsolutions.eshoponcontainersjava.catalogservice.services.CatalogItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("catalog")
public class CatalogController {
    @Autowired
    CatalogItemService catalogService;

    @GetMapping("/items/{pageNo}")
    public List<CatalogItem> getItems(@PathVariable(value = "pageNo", required = false) Integer pageNo, @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        var items =catalogService.getCatalogItems(pageNo != null ? pageNo : 1, pageSize != null ? pageSize : 10);
        return items;
    }
}
