package co.edu.ff.orders.product.repositories;

import co.edu.ff.orders.product.domain.ProductCreated;
import co.edu.ff.orders.product.domain.ProductOperationFailure;
import co.edu.ff.orders.product.domain.ProductOperationRequest;
import co.edu.ff.orders.product.domain.ProductOperationSuccess;
import co.edu.ff.orders.product.domain.contracts.ProductOperation;
import co.edu.ff.orders.product.domain.fields.Id;
import co.edu.ff.orders.product.exceptions.ProductDoesNotExists;
import co.edu.ff.orders.product.repositories.contracts.ProductRepository;

import java.util.*;


public class InMemoryProductRepository implements ProductRepository {

    private final Map<Id, ProductCreated> state = new HashMap<>();

    @Override
    public ProductOperation insertOne(ProductOperationRequest request) {
        Id id = Id.of(state.size() + 1L);
        ProductCreated productCreated = ProductCreated.from(request, id);
        state.put(id, productCreated);
        return ProductOperationSuccess.of(productCreated);
    }

    @Override
    public ProductOperation findById(Id productId) {
        if (state.containsKey(productId)) {
            return ProductOperationSuccess.of(state.get(productId));
        }

        return ProductOperationFailure.of(ProductDoesNotExists.of(productId));
    }

    @Override
    public List<ProductCreated> findAll() {
        return new ArrayList<>(state.values());
    }

    @Override
    public ProductOperation updateOne(Id productId, ProductOperationRequest request) {
        ProductOperation productOperation = findById(productId);

        if (productOperation instanceof ProductOperationSuccess) {
            ProductCreated productUpdated = ProductCreated.from(request, productId);
            state.replace(productId, productOperation.value(), productUpdated);
        }

        return productOperation;
    }

    @Override
    public ProductOperation deleteOne(Id productId) {
        ProductOperation productOperation = findById(productId);

        if (productOperation instanceof ProductOperationSuccess) {
            state.remove(productId);
        }

        return productOperation;
    }
}
