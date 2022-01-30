package com.smartsolutions.eshoponcontainersjava.catalogservice.services;

import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogType;
import com.smartsolutions.eshoponcontainersjava.catalogservice.repositories.CatalogTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogTypeService {

    @Autowired
    private CatalogTypeRepository repository;

    public List<CatalogType> getCatalogItems(){
        List<CatalogType> response = new ArrayList<>();
        repository.findAll().forEach(response::add);
        return response;
    }
    public CatalogType getCatalogItemById(int id){
        return repository.findById(id).orElse(null);
    }
    public void saveAll(List<CatalogType> catalogTypes){
        repository.saveAll(catalogTypes);
    }
}
