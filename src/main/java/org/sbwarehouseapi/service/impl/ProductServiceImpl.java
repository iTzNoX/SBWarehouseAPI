package org.sbwarehouseapi.service.impl;

import org.sbwarehouseapi.dto.*;
import org.sbwarehouseapi.repository.ProductRepository;
import org.sbwarehouseapi.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    private String normalize(String input) {
        if (input == null || input.isBlank()) return "XXX";

        String upper = input.toUpperCase();

        if (upper.length() >= 3) return upper.substring(0, 3);

        return String.format("%-3s", upper).replace(' ', 'X');
    }

    private String generateSKU(String name, String location){
        String SKUName = normalize(name);
        String SKULocation = normalize(location);

        long count = repository.countByNameAndLocation(name, location) + 1;

        return String.format("%s-%s-%03d", SKUName, SKULocation, count);
    }

    public void updateStock(Long id, UpdateStockDTO dto) {
    }

    public void transferStock(TransferStockDTO dto) {
    }

    public List<ProductDTO> findAllProducts() {
        return null;
    }

    public ProductDTO findProductById(Long id) {
        return null;
    }

    public ProductDTO createProduct (CreateProductDTO dto) {
        return null;
    }

    public ProductDTO updateProduct (UpdateProductDTO dto) {
        return null;
    }

    public void deleteProduct (Long id) {
    }
}
