package co.edu.ff.orders.product.services;

import co.edu.ff.orders.product.domain.ProductCreated;
import co.edu.ff.orders.product.domain.ProductOperationRequest;
import co.edu.ff.orders.product.domain.contracts.ProductOperation;
import co.edu.ff.orders.product.domain.fields.Id;
import co.edu.ff.orders.product.repositories.contracts.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServices {

    private final ProductRepository repository;

    public ProductOperation insertProduct(ProductOperationRequest newProduct) {
        return repository.insertOne(newProduct);
    }

    public ProductOperation findById(Id productId) {
        return repository.findById(productId);
    }

    public List<ProductCreated> findAll() {
        return repository.findAll();
    }

    public ProductOperation updateById(Id productId, ProductOperationRequest request) {
        return repository.updateOne(productId, request);
    }

    public ProductOperation deleteById(Id productId) {
        return repository.deleteOne(productId);
    }

}
