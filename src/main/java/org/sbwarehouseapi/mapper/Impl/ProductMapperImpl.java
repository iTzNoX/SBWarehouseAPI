package org.sbwarehouseapi.mapper.Impl;

import org.sbwarehouseapi.dto.CreateProductDTO;
import org.sbwarehouseapi.dto.ProductDTO;
import org.sbwarehouseapi.dto.UpdateProductDTO;
import org.sbwarehouseapi.entity.Product;
import org.sbwarehouseapi.mapper.ProductMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper {


    public ProductDTO entityToProductDTO(Product product){
        if (product == null) return null;

        ProductDTO dto = new ProductDTO();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setSku(product.getSku());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        dto.setDescription(product.getDescription());
        dto.setLocation(product.getLocation());
        return dto;
    }

    public Product createProductDTOToEntity(CreateProductDTO dto) {
        if (dto == null) return null;

        Product product = new Product();

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        product.setDescription(dto.getDescription());
        product.setLocation(dto.getLocation());
        return product;
    }

    public void updateEntityFromUpdateProductDTO(UpdateProductDTO dto, Product entity) {
        if (dto == null || entity == null) return;

        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getPrice() != null) entity.setPrice(dto.getPrice());
        if (dto.getQuantity() != null) entity.setQuantity(dto.getQuantity());
        if (dto.getDescription() != null) entity.setDescription(dto.getDescription());
        if (dto.getLocation() != null) entity.setLocation(dto.getLocation());
    }
}