package org.sbwarehouseapi.service;

import org.sbwarehouseapi.dto.CreateProductDTO;
import org.sbwarehouseapi.dto.ProductDTO;
import org.sbwarehouseapi.dto.UpdateProductDTO;

import java.util.List;

public interface ProductService {

    void receiveStock(UpdateProductDTO dto);

    void removeStock(UpdateProductDTO dto);

    void transferStock(UpdateProductDTO dto1, UpdateProductDTO dto2);

    List<ProductDTO> findAllProducts();

    ProductDTO findProductById(Long id);

    ProductDTO createProduct(CreateProductDTO dto);

    ProductDTO updateProduct(UpdateProductDTO dto);

    void deleteProduct(Long id);
}