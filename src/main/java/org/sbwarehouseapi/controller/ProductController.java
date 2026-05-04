package org.sbwarehouseapi.controller;

import org.sbwarehouseapi.dto.UpdateProductDTO;
import org.sbwarehouseapi.dto.CreateProductDTO;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // GET /api/products
    @GetMapping
    public List<String> findAll() {
        return List.of("temp");
    }

    // GET /api/products/{id}
    @GetMapping("/{id}")
    public String findById(@PathVariable Long id) {
        return "temp";
    }

    // POST /api/products
    @PostMapping
    public String createProduct(@RequestBody CreateProductDTO dto) {
        return "temp";
    }

    // PUT /api/products/{id}
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody UpdateProductDTO dto) {
        return "temp";
    }

    // DELETE /api/products/{id}
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
    }
}