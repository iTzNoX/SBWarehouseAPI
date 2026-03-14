package org.sbwarehouseapi.controller;

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
    public String createProduct(@RequestBody String body) {
        return "temp";
    }

    // PUT /api/products/{id}
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody String body) {
        return "temp";
    }

    // DELETE /api/products/{id}
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
    }
}