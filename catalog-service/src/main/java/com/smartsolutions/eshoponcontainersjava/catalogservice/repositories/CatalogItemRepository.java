package com.smartsolutions.eshoponcontainersjava.catalogservice.repositories;

import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogItem;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogItemRepository extends PagingAndSortingRepository<CatalogItem, Integer> {

    List<CatalogItem> findByNameContainsIgnoreCase(String name);

    @Query(value = "select * from catalog_item where type_id=?1 and brand_id=?2",
            countQuery = "select count(*) from catalog_item where type_id=?1 and brand_id=?2",
            nativeQuery = true)
    Page<CatalogItem> findByTypeIdAndBrandId(int typeId, int brandId, Pageable pageable);
}