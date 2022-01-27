package com.smartsolutions.eshoponcontainersjava.catalogservice.services;

import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogBrand;
import com.smartsolutions.eshoponcontainersjava.catalogservice.repositories.CatalogBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogBrandService {

    @Autowired
    private CatalogBrandRepository repository;

    public List<CatalogBrand> getCatalogBrands(int pageNo){
        var pageable = PageRequest.of(pageNo, 5);
        return repository.findAll(pageable).toList();
    }
    public CatalogBrand getCatalogItemById(int id){
        return repository.findById(id).orElse(null);
    }
    public void saveAll(List<CatalogBrand> catalogBrands){
        repository.saveAll(catalogBrands);
    }

}
