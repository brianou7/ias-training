package co.edu.ff.orders.product.domain.contracts;

import co.edu.ff.orders.product.domain.ProductCreated;

public interface ProductOperation {

    ProductCreated value();
    String failure();

    Boolean isValid();
}
