package org.sbwarehouseapi.repository;

import org.sbwarehouseapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    long countByNameAndLocation(String name, String location);

    List<Product> findByName(String name);

    List<Product> findByLocation(String location);

    Optional<Product> findByNameAndLocation(String name, String location);
}