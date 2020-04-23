package co.edu.ff.orders.product.repositories;

import co.edu.ff.orders.product.domain.ProductCreated;
import co.edu.ff.orders.product.domain.ProductOperationRequest;
import co.edu.ff.orders.product.domain.fields.Id;
import co.edu.ff.orders.product.repositories.contracts.ProductRepository;

import java.util.*;


public class InMemoryProductRepository implements ProductRepository {

    private final Map<Id, ProductCreated> state = new HashMap<>();

    @Override
    public ProductCreated insertOne(ProductOperationRequest request) {
        Id id = Id.of(state.size() + 1L);
        ProductCreated productCreated = ProductCreated.from(request, id);
        state.put(id, productCreated);
        return productCreated;
    }

    @Override
    public Optional<ProductCreated> findById(Id productId) {
        return Optional.ofNullable(state.get(productId));
    }

    @Override
    public List<ProductCreated> findAll() {
        return new ArrayList<>(state.values());
    }

    @Override
    public Optional<ProductCreated> updateOne(Id productId, ProductOperationRequest request) {
        if (state.containsKey(productId)) {
            Id id = Id.of(state.size() + 1L);
            ProductCreated productUpdated = ProductCreated.from(request, id);
            state.replace(productId, productUpdated);
            return Optional.of(productUpdated);
        }

        return Optional.empty();
    }

    @Override
    public Optional<ProductCreated> deleteOne(Id productId) {
        if (state.containsKey(productId)) {
            ProductCreated productRemoved = state.get(productId);
            state.remove(productId);
            return Optional.of(productRemoved);
        }

        return Optional.empty();
    }
}
