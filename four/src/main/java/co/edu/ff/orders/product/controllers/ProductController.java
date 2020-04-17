package co.edu.ff.orders.product.controllers;

import co.edu.ff.orders.product.domain.ProductCreated;
import co.edu.ff.orders.product.domain.ProductOperationRequest;
import co.edu.ff.orders.product.domain.contracts.ProductOperation;
import co.edu.ff.orders.product.domain.fields.Id;
import co.edu.ff.orders.product.services.ProductServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServices services;

    private ResponseEntity<ProductOperation> response(ProductOperation operation) {
        if(operation.isValid()) {
            return ResponseEntity.ok(operation);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(operation);
    }

    @PostMapping
    public ResponseEntity<ProductOperation> createProduct(@RequestBody ProductOperationRequest newProduct) {
        ProductOperation productOperation = services.insertProduct(newProduct);
        return response(productOperation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductOperation> getProductById(@PathVariable Id productId) {
        ProductOperation productOperation = services.findById(productId);
        return response(productOperation);
    }

    @GetMapping
    public ResponseEntity<List<ProductCreated>> getAll() {
        return ResponseEntity.ok(services.findAll());
    }


}
