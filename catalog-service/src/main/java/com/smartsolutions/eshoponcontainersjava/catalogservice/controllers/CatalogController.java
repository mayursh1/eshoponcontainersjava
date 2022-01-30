package com.smartsolutions.eshoponcontainersjava.catalogservice.controllers;

import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogItem;
import com.smartsolutions.eshoponcontainersjava.catalogservice.services.CatalogItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("catalog")
public class CatalogController {
    @Autowired
    CatalogItemService catalogService;

    @GetMapping("/items")
    public List<CatalogItem> getItems(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                                      @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                      @RequestParam(value = "ids", required = false) String ids) {
        if(ids != null) {
            return getItemsByIdsImpl(ids);
        }
        else {
            return catalogService.getCatalogItems(pageNo != null ? pageNo : 1, pageSize != null ? pageSize : 10);
        }
    }

    @GetMapping("/items/{id}")
    public CatalogItem getItemById(@PathVariable("id") Integer id) {
        return catalogService.getCatalogItemById(id);
    }

    @GetMapping("/items/withname/{name}")
    public List<CatalogItem> getItemByName(@PathVariable("name") String name) {
        return catalogService.getCatalogItemsByName(name);
    }

    @GetMapping("/items/type/{typeId}/brand/{brandId}")
    public ResponseEntity<Object> getItemByName(@PathVariable("typeId") Integer typeId,
                                                @PathVariable("brandId") Integer brandId,
                                                @RequestParam(value = "pageNo", required = false) Integer pageNo,
                                                @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if( typeId != null && brandId != null)
            return ResponseEntity.ok(catalogService.getCatalogItemsByTypeAndBrand(typeId, brandId, pageNo, pageSize));
        return ResponseEntity.badRequest().build();
    }

    private List<CatalogItem> getItemsByIdsImpl(String ids) {
        var numIds =  Arrays.stream(ids.split(","))    // Split string by ','
                .map(this::tryParseInteger)                         // Convert to Integer
                .filter(Objects::nonNull)                               // Filter out invalid numbers
                .collect(Collectors.toList());                          // Collect in a list
        return catalogService.getCatalogItemsByIds(numIds);             // Return values by Ids
    }

    private Integer tryParseInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }
}
