package co.edu.ff.orders.product.controllers;

import co.edu.ff.orders.product.domain.ProductCreated;
import co.edu.ff.orders.product.domain.ProductOperationFailure;
import co.edu.ff.orders.product.domain.ProductOperationRequest;
import co.edu.ff.orders.product.domain.contracts.ProductOperation;
import co.edu.ff.orders.product.domain.fields.*;
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

        if (operation instanceof ProductOperationFailure) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(operation);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<ProductOperation> createProduct(@RequestBody ProductOperationRequest newProduct) {
        return response(services.insertProduct(newProduct));
    }

    @GetMapping
    public ResponseEntity<List<ProductCreated>> getAll() {
        return ResponseEntity.ok(services.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductOperation> getProductById(@PathVariable Id productId) {
        return response(services.findById(productId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductOperation> updateProduct(@PathVariable Id productId, @RequestBody ProductOperationRequest request) {
        return response(services.updateById(productId, request));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<ProductOperation> deleteProduct(@PathVariable Id productId) {
        return response(services.deleteById(productId));
    }

}
