package com.smartsolutions.eshoponcontainersjava.catalogservice.repositories;

import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CatalogItemRepository extends PagingAndSortingRepository<CatalogItem, Integer> {
}
