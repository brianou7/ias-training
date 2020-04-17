package co.edu.ff.orders.product.repositories.contracts;

import co.edu.ff.orders.product.domain.ProductCreated;
import co.edu.ff.orders.product.domain.ProductOperationRequest;
import co.edu.ff.orders.product.domain.contracts.ProductOperation;
import co.edu.ff.orders.product.domain.fields.Id;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {

    ProductOperation insertOne(ProductOperationRequest request);

    ProductOperation findById(Id productId);

    List<ProductCreated> findAll();

    ProductOperation updateOne(Id productId, ProductOperationRequest request);

    ProductOperation deleteOne(Id productId);

}
