package org.sbwarehouseapi.mapper;

import org.sbwarehouseapi.dto.CreateProductDTO;
import org.sbwarehouseapi.dto.ProductDTO;
import org.sbwarehouseapi.dto.UpdateProductDTO;
import org.sbwarehouseapi.entity.Product;

public interface ProductMapper {

    ProductDTO entityToProductDTO(Product product);

    Product createProductDTOToEntity(CreateProductDTO dto);

    void updateEntityFromUpdateProductDTO(UpdateProductDTO dto, Product entity);
}