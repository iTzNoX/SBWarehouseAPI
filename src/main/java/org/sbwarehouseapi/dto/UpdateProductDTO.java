package org.sbwarehouseapi.dto;

import java.math.BigDecimal;

public class UpdateProductDTO {

    private String name;
    private BigDecimal price;
    private Integer quantity;
    private String description;
    private String location;

    // Getter & Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}