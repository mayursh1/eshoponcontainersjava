package com.smartsolutions.eshoponcontainersjava.catalogservice.repositories;

import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CatalogBrandRepository extends PagingAndSortingRepository<CatalogBrand, Integer> {
}
