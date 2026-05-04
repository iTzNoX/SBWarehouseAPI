package org.sbwarehouseapi.mapper;

import org.junit.jupiter.api.Test;
import org.sbwarehouseapi.dto.CreateProductDTO;
import org.sbwarehouseapi.dto.ProductDTO;
import org.sbwarehouseapi.dto.UpdateProductDTO;
import org.sbwarehouseapi.entity.Product;
import org.sbwarehouseapi.mapper.Impl.ProductMapperImpl;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ProductMapperImplTest {

    private final ProductMapperImpl mapper = new ProductMapperImpl();

    private Product createEntity() {
        Product p = new Product(
                "Laptop",
                "LAP-BER-001",
                new BigDecimal("1000.00"),
                5
        );
        p.setDescription("Gaming Laptop");
        p.setLocation("Berlin");
        return p;
    }

    @Test
    void mapEntityToDTO() {
        Product entity = createEntity();

        ProductDTO dto = mapper.entityToProductDTO(entity);

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(entity.getId());
        assertThat(dto.getName()).isEqualTo("Laptop");
        assertThat(dto.getSku()).isEqualTo("LAP-BER-001");
        assertThat(dto.getPrice()).isEqualTo(new BigDecimal("1000.00"));
        assertThat(dto.getQuantity()).isEqualTo(5);
        assertThat(dto.getDescription()).isEqualTo("Gaming Laptop");
        assertThat(dto.getLocation()).isEqualTo("Berlin");
    }

    @Test
    void mapCreateDTOToEntity() {
        CreateProductDTO dto = new CreateProductDTO();

        dto.setName("Keyboard");
        dto.setPrice(new BigDecimal("50.00"));
        dto.setQuantity(3);
        dto.setDescription("Mechanical");
        dto.setLocation("Berlin");

        Product entity = mapper.createProductDTOToEntity(dto);

        assertThat(entity.getName()).isEqualTo("Keyboard");
        assertThat(entity.getSku()).isNull();
        assertThat(entity.getPrice()).isEqualTo(new BigDecimal("50.00"));
        assertThat(entity.getQuantity()).isEqualTo(3);
        assertThat(entity.getLocation()).isEqualTo("Berlin");
    }

    @Test
    void mapUpdateDTOToEntity() {
        Product entity = createEntity();
        UpdateProductDTO dto = new UpdateProductDTO();

        dto.setName("Updated Laptop");
        dto.setPrice(null); // no override because Price cannot be null

        mapper.updateEntityFromUpdateProductDTO(dto, entity);

        assertThat(entity.getName()).isEqualTo("Updated Laptop");
        assertThat(entity.getLocation()).isEqualTo("Berlin");

        // not changed
        assertThat(entity.getPrice()).isEqualTo(new BigDecimal("1000.00"));

    }

    @Test
    void returnNullWhenEntityIsNull() {
        assertThat(mapper.entityToProductDTO(null)).isNull();
    }

    @Test
    void returnNullWhenDTOIsNull() {
        assertThat(mapper.createProductDTOToEntity(null)).isNull();
    }

    @Test
    void doesNotCrashOnNullUpdate() {
        Product entity = createEntity();

        mapper.updateEntityFromUpdateProductDTO(null, entity);

        assertThat(entity.getName()).isEqualTo("Laptop");
    }
}