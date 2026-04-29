package org.sbwarehouseapi.repository;

import org.junit.jupiter.api.Test;
import org.sbwarehouseapi.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    private Product createProduct(String name, String sku, String location) {
        Product p1 = new Product(
                name,
                sku,
                new BigDecimal("10.00"),
                5);
        p1.setLocation(location);
        return p1;
    }

    @Test
    void saveProduct() {
        Product product = createProduct("Laptop", "LAP-BER-001", "Berlin");

        Product saved = productRepository.save(product);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getName()).isEqualTo("Laptop");
        assertThat(saved.getSku()).isEqualTo("LAP-BER-001");
        assertThat(saved.getLocation()).isEqualTo("Berlin");
    }

    @Test
    void findById() {
        Product product = createProduct("Laptop", "LAP-BER-001", "Berlin");

        Product saved = productRepository.save(product);

        Optional<Product> result = productRepository.findById(saved.getId());

        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(saved.getId());
        assertThat(result.get().getName()).isEqualTo("Laptop");
        assertThat(result.get().getSku()).isEqualTo("LAP-BER-001");
        assertThat(result.get().getLocation()).isEqualTo("Berlin");
    }

    @Test
    void findByName() {
        productRepository.save(createProduct("Laptop", "LAP-BER-001", "Berlin"));
        productRepository.save(createProduct("Laptop", "LAP-BRE-001", "Bremen"));

        List<Product> result = productRepository.findByName("Laptop");

        assertThat(result).hasSize(2);
    }

    @Test
    void findByLocation() {
        productRepository.save(createProduct("Laptop", "LAP-BER-001", "Berlin"));
        productRepository.save(createProduct("Mouse", "MOU-BER-001", "Berlin"));

        List<Product> result = productRepository.findByLocation("Berlin");

        assertThat(result).hasSize(2);
    }

    @Test
    void findByNameAndLocation() {
        productRepository.save(createProduct("Laptop", "LAP-BER-001", "Berlin"));

        Optional<Product> result =
                productRepository.findByNameAndLocation("Laptop", "Berlin");

        assertThat(result).isPresent();
    }

    @Test
    void returnEmptyWhenNotFound() {
        Optional<Product> result = productRepository.findByNameAndLocation("X", "Y");

        assertThat(result).isEmpty();
    }

    @Test
    void allowSameNameDifferentLocation() {
        productRepository.save(createProduct("Laptop", "LAP-BER-001", "Berlin"));
        productRepository.save(createProduct("Laptop", "LAP-BRE-001", "Bremen"));

        List<Product> result = productRepository.findByName("Laptop");

        assertThat(result).hasSize(2);
    }

    @Test
    void doesNotAllowSameNameSameLocation() {
        productRepository.save(createProduct("Laptop", "LAP-BER-001", "Berlin"));
        Product duplicate = createProduct("Laptop", "LAP-BER-002", "Berlin");

        try {
            productRepository.save(duplicate);
            fail("Expected exception was not thrown");
        }
        catch (Exception e) {
            assertThat(e).isInstanceOf(Exception.class);
        }
    }

}