package co.edu.ff.orders.product.repositories.contracts;

import co.edu.ff.orders.product.domain.ProductCreated;
import co.edu.ff.orders.product.domain.ProductOperationRequest;
import co.edu.ff.orders.product.domain.fields.Id;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository {

    ProductCreated insertOne(ProductOperationRequest request);

    Optional<ProductCreated> findById(Id productId);

    List<ProductCreated> findAll();

    Optional<ProductCreated> updateOne(Id productId, ProductOperationRequest request);

    Optional<ProductCreated> deleteOne(Id productId);

}
