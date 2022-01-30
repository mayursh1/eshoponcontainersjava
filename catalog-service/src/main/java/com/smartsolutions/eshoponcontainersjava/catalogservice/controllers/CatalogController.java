package com.smartsolutions.eshoponcontainersjava.catalogservice.controllers;

import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogItem;
import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogType;
import com.smartsolutions.eshoponcontainersjava.catalogservice.services.CatalogItemService;
import com.smartsolutions.eshoponcontainersjava.catalogservice.services.CatalogTypeService;
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

    @Autowired
    CatalogTypeService catalogTypeService;

    @GetMapping("/items")
    public ResponseEntity<List<CatalogItem>> getItems(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                                      @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                      @RequestParam(value = "ids", required = false) String ids) {
        if((pageNo != null && pageNo <= 0) || (pageSize != null && pageSize <= 0)) {
            return ResponseEntity.badRequest().build();
        }

        try {
            List<CatalogItem> response;
            if (ids != null) {
                response = getItemsByIdsImpl(ids);
            } else {
                response = catalogService.getCatalogItems(pageNo != null ? pageNo : 1, pageSize != null ? pageSize : 10);
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<CatalogItem> getItemById(@PathVariable("id") Integer id) {
        if(id == null || id < 0) {
            return ResponseEntity.badRequest().build();
        }
        try {
            return ResponseEntity.ok(catalogService.getCatalogItemById(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/items/withname/{name}")
    public ResponseEntity<List<CatalogItem>> getItemByName(@PathVariable("name") String name) {
        if(name == null || name.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        try {
            return ResponseEntity.ok(catalogService.getCatalogItemsByName(name));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/items/type/{typeId}/brand/{brandId}")
    public ResponseEntity<List<CatalogItem>> getItemByName(@PathVariable("typeId") Integer typeId,
                                                @PathVariable("brandId") Integer brandId,
                                                @RequestParam(value = "pageNo", required = false) Integer pageNo,
                                                @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if(typeId == null || brandId == null || typeId < 0 || brandId < 0) {
            return ResponseEntity.badRequest().build();
        }
        if(pageNo < 0 || pageSize < 0) {
            return ResponseEntity.badRequest().build();
        }
        try {
            return ResponseEntity.ok(catalogService.getCatalogItemsByTypeAndBrand(typeId, brandId, pageNo, pageSize));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("catalogtypes")
    public ResponseEntity<List<CatalogType>> getCatalogTypes() {
        try {
            return ResponseEntity.ok(catalogTypeService.getCatalogItems());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
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
