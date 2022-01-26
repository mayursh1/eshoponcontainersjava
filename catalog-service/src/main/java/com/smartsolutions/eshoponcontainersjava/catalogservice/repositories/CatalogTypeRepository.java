package com.smartsolutions.eshoponcontainersjava.catalogservice.repositories;

import com.smartsolutions.eshoponcontainersjava.catalogservice.models.CatalogType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogTypeRepository extends JpaRepository<CatalogType, Integer> {
}
