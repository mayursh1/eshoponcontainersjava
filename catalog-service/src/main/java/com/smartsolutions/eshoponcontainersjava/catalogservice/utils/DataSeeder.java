package com.smartsolutions.eshoponcontainersjava.catalogservice.utils;

import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogBrand;
import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogItem;
import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogType;
import com.smartsolutions.eshoponcontainersjava.catalogservice.services.CatalogBrandService;
import com.smartsolutions.eshoponcontainersjava.catalogservice.services.CatalogItemService;
import com.smartsolutions.eshoponcontainersjava.catalogservice.services.CatalogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private CatalogItemService catalogItemService;

    @Autowired
    private CatalogBrandService catalogBrandService;

    @Autowired
    private CatalogTypeService catalogTypeService;

    @Override
    public void run(String... args) {
        var currentItems = catalogItemService.getCatalogItems(1,1);
        if (currentItems.size() != 0) return;

        // Data has not been initialized
        var types = new ArrayList<CatalogType>();
        types.add((new CatalogType()).type("Fashion"));
        types.add((new CatalogType()).type("Electronics"));
        types.add((new CatalogType()).type("Home and Kitchen"));
        types.add((new CatalogType()).type("Sports"));
        types.add((new CatalogType()).type("Toys"));

        catalogTypeService.saveAll(types);

        var brands = new ArrayList<CatalogBrand>();
        brands.add((new CatalogBrand()).brand("Raymond"));
        brands.add((new CatalogBrand()).brand("Nokia"));
        brands.add((new CatalogBrand()).brand("Samsung"));
        brands.add((new CatalogBrand()).brand("LG"));
        brands.add((new CatalogBrand()).brand("Philiphs"));

        catalogBrandService.saveAll(brands);

        var items = new ArrayList<CatalogItem>();
        items.add((new CatalogItem()).catalogBrand(brands.get(0)).catalogType(types.get(0)).description("Pants for men").name("PantsM"));
        items.add((new CatalogItem()).catalogBrand(brands.get(0)).catalogType(types.get(0)).description("Pants for Women").name("PantsW"));
        items.add((new CatalogItem()).catalogBrand(brands.get(1)).catalogType(types.get(1)).description("Nokia Mobile").name("MobileNk"));
        items.add((new CatalogItem()).catalogBrand(brands.get(2)).catalogType(types.get(1)).description("Samsung Mobile").name("MobileSs"));
        items.add((new CatalogItem()).catalogBrand(brands.get(3)).catalogType(types.get(2)).description("LG Fridge").name("FridgeLg"));
        items.add((new CatalogItem()).catalogBrand(brands.get(3)).catalogType(types.get(2)).description("Philiphs Fridge").name("FridgePh"));

        catalogItemService.saveAll(items);

    }

}
