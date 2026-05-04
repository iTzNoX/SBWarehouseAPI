package org.sbwarehouseapi.controller;

import org.sbwarehouseapi.dto.*;

import org.sbwarehouseapi.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // PATCH /api/products/{id}/stock
    @PatchMapping("/{id}/stock")
    public void updateStock(@PathVariable Long id, @RequestBody UpdateStockDTO dto) {
        productService.updateStock(id, dto);
    }

    // POST /api/products/transfer
    @PostMapping("/transfer")
    public void transferStock(@RequestBody TransferStockDTO dto) {
        productService.transferStock(dto);
    }

    // GET /api/products
    @GetMapping
    public List<ProductDTO> findAll() {
        return productService.findAllProducts();
    }

    // GET /api/products/{id}
    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    // POST /api/products
    @PostMapping
    public ProductDTO createProduct(@RequestBody CreateProductDTO dto) {
        return productService.createProduct(dto);
    }

    // PUT /api/products/{id}
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody UpdateProductDTO dto) {
        return productService.updateProduct(id, dto);
    }

    // DELETE /api/products/{id}
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}