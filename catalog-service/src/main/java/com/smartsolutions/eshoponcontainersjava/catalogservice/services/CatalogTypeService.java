package com.smartsolutions.eshoponcontainersjava.catalogservice.services;

import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogItem;
import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogType;
import com.smartsolutions.eshoponcontainersjava.catalogservice.repositories.CatalogItemRepository;
import com.smartsolutions.eshoponcontainersjava.catalogservice.repositories.CatalogTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogTypeService {

    @Autowired
    private CatalogTypeRepository repository;

    public List<CatalogType> getCatalogItems(int pageNo){
        var pageable = PageRequest.of(pageNo, 5);
        return repository.findAll(pageable).toList();
    }
    public CatalogType getCatalogItemById(int id){
        return repository.findById(id).orElse(null);
    }
    public void saveAll(List<CatalogType> catalogTypes){
        repository.saveAll(catalogTypes);
    }
}
