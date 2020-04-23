package co.edu.ff.orders.product.services;

import co.edu.ff.orders.product.domain.ProductCreated;
import co.edu.ff.orders.product.domain.ProductOperationFailure;
import co.edu.ff.orders.product.domain.ProductOperationRequest;
import co.edu.ff.orders.product.domain.ProductOperationSuccess;
import co.edu.ff.orders.product.domain.contracts.ProductOperation;
import co.edu.ff.orders.product.domain.fields.Id;
import co.edu.ff.orders.product.exceptions.ProductDoesNotExists;
import co.edu.ff.orders.product.repositories.contracts.ProductRepository;
import co.edu.ff.orders.user.domain.UserOperationFailure;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ProductServices {

    private final ProductRepository repository;

    public ProductOperation insertProduct(ProductOperationRequest newProduct) {
        ProductCreated product = repository.insertOne(newProduct);
        return ProductOperationSuccess.of(product);
    }

    public ProductOperation findById(Id productId) {
        Optional<ProductCreated> product = repository.findById(productId);
        return validateExistenceResponse(product, productId);
    }

    public List<ProductCreated> findAll() {
        return repository.findAll();
    }

    public ProductOperation updateById(Id productId, ProductOperationRequest request) {
        Optional<ProductCreated> product = repository.updateOne(productId, request);
        return validateExistenceResponse(product, productId);
    }

    public ProductOperation deleteById(Id productId) {
        Optional<ProductCreated> product = repository.deleteOne(productId);
        return validateExistenceResponse(product, productId);
    }

    private ProductOperation validateExistenceResponse(Optional<ProductCreated> optional, Id productId) {
        if (optional.isPresent()) {
            return ProductOperationSuccess.of(optional.get());
        }

        return ProductOperationFailure.of(ProductDoesNotExists.of(productId));
    }

}
