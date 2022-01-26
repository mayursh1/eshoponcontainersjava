package com.smartsolutions.eshoponcontainersjava.catalogservice.services;

import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogItem;
import com.smartsolutions.eshoponcontainersjava.catalogservice.repositories.CatalogItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogItemService {

    @Autowired
    private CatalogItemRepository repository;

    public List<CatalogItem> getCatalogItems(){
        return repository.findAll();
    }
    public CatalogItem getCatalogItemById(int id){
        return repository.findById(id).orElse(null);
    }
    public void saveAll(List<CatalogItem> catalogItems){
        repository.saveAllAndFlush(catalogItems);
    }
}
