package org.sbwarehouseapi.service;

import org.sbwarehouseapi.dto.CreateProductDTO;
import org.sbwarehouseapi.dto.ProductDTO;
import org.sbwarehouseapi.dto.UpdateProductDTO;

import java.util.List;

public interface ProductService {

    void receiveStock(Long id, int quantity);

    void removeStock(Long id, int quantity);

    void transferStock(Long idFrom,  Long idTo, int quantity);

    List<ProductDTO> findAllProducts();

    ProductDTO findProductById(Long id);

    ProductDTO createProduct(CreateProductDTO dto);

    ProductDTO updateProduct(UpdateProductDTO dto);

    void deleteProduct(Long id);
}