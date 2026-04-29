package org.sbwarehouseapi.service.impl;

import org.sbwarehouseapi.dto.CreateProductDTO;
import org.sbwarehouseapi.dto.ProductDTO;
import org.sbwarehouseapi.dto.UpdateProductDTO;
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

    public void receiveStock(UpdateProductDTO dto) {
    }

    public void removeStock(UpdateProductDTO dto){
    }

    public void transferStock(UpdateProductDTO dto1, UpdateProductDTO dto2) {
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
