package com.smartsolutions.eshoponcontainersjava.catalogservice.services;

import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogItem;
import com.smartsolutions.eshoponcontainersjava.catalogservice.repositories.CatalogItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogItemService {

    @Autowired
    private CatalogItemRepository repository;

    public List<CatalogItem> getCatalogItems(int pageNo, int pageSize){
        var pageable = PageRequest.of(pageNo <= 0 ? 1 : pageNo, pageSize <=0 ? 10 : pageSize);
        return repository.findAll(pageable).toList();
    }

    public CatalogItem getCatalogItemById(int id){
        return repository.findById(id).orElse(null);
    }

    public List<CatalogItem> getCatalogItemsByName(String name){
        return repository.findByName(name);
    }

    public List<CatalogItem> getCatalogItemsByTypeAndBrand(int typeId, int brandId, Integer pageNo, Integer pageSize){
        var pageable = PageRequest.of(pageNo == null ? 1 : pageNo, pageSize == null ? 10 : pageSize);
        return repository.findByTypeIdAndBrandId(typeId, brandId, pageable).toList();
    }

    public List<CatalogItem> getCatalogItemsByIds(Iterable<Integer> ids){
        var items = repository.findAllById(ids);
        List<CatalogItem> response = new ArrayList<>();
        items.forEach(response::add);
        return response;
    }

    public CatalogItem update(CatalogItem item){
        return repository.save(item);
    }

    public CatalogItem add(CatalogItem item){
        return repository.save(item);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }


    public void saveAll(List<CatalogItem> catalogItems){
        repository.saveAll(catalogItems);
    }
}
