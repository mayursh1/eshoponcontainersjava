package com.smartsolutions.eshoponcontainersjava.catalogservice.services;

import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogBrand;
import com.smartsolutions.eshoponcontainersjava.catalogservice.repositories.CatalogBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogBrandService {

    @Autowired
    private CatalogBrandRepository repository;

    public List<CatalogBrand> getCatalogBrands(){
        var response = new ArrayList<CatalogBrand>();
        repository.findAll().forEach(response::add);
        return response;
    }
    public CatalogBrand getCatalogBrandById(int id){
        return repository.findById(id).orElse(null);
    }
    public void saveAll(List<CatalogBrand> catalogBrands){
        repository.saveAll(catalogBrands);
    }

}
