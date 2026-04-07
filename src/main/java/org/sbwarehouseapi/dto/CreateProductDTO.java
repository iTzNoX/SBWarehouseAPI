package org.sbwarehouseapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateProductDTO {

    private String name;
    private BigDecimal price;
    private Integer quantity;
    private String description;
    private String location;
}