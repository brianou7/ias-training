package co.edu.ff.orders.product.domain;

import co.edu.ff.orders.product.domain.contracts.ProductOperation;
import co.edu.ff.orders.product.exceptions.ProductException;
import lombok.Value;

@Value(staticConstructor = "of")
public class ProductOperationFailure implements ProductOperation {

    ProductException productException;

    @Override
    public ProductCreated value() { return null; }

    @Override
    public String failure() { return productException.getMessage(); }

    @Override
    public Boolean isValid() { return false; }
}
