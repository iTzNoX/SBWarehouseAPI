package org.sbwarehouseapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

    @Getter
    @Setter
    public class ProductDTO {

    private Long id;
    private String name;
    private String sku;
    private BigDecimal price;
    private Integer quantity;
    private String description;
    private String location;
}