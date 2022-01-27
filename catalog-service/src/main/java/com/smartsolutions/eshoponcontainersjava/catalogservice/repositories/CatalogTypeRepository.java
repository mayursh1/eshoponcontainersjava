package com.smartsolutions.eshoponcontainersjava.catalogservice.repositories;

import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CatalogTypeRepository extends PagingAndSortingRepository<CatalogType, Integer> {
}
