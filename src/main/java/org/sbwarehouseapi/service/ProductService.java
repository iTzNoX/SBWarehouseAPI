package org.sbwarehouseapi.service;

import org.sbwarehouseapi.dto.*;

import java.util.List;

public interface ProductService {

    void updateStock(Long id, UpdateStockDTO dto);

    void transferStock(TransferStockDTO dto);

    List<ProductDTO> findAllProducts();

    ProductDTO findProductById(Long id);

    ProductDTO createProduct(CreateProductDTO dto);

    ProductDTO updateProduct(UpdateProductDTO dto);

    void deleteProduct(Long id);
}