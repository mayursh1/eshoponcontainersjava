package com.smartsolutions.eshoponcontainersjava.catalogservice.repositories;

import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogItemRepository extends JpaRepository<CatalogItem, Integer> {
}
