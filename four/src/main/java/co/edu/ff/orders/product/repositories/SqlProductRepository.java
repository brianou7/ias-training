package co.edu.ff.orders.product.repositories;

import co.edu.ff.orders.product.domain.ProductCreated;
import co.edu.ff.orders.product.domain.ProductOperationRequest;
import co.edu.ff.orders.product.domain.fields.*;
import co.edu.ff.orders.product.repositories.contracts.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class SqlProductRepository implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    private final RowMapper<ProductCreated> rowMapper = (resultSet, i) -> {
        Id productId = Id.of(resultSet.getLong("id"));
        Name name = Name.of(resultSet.getString("name"));
        Description description = Description.of(resultSet.getString("description"));
        Price price = Price.of(resultSet.getBigDecimal("price"));
        TaxRate tax_rate = TaxRate.of(resultSet.getBigDecimal("tax_rate"));
        Status status =  Status.valueOf(resultSet.getString("status"));
        Stock stock = Stock.of(resultSet.getInt("stock"));
        return ProductCreated.from(productId, name, description, price, tax_rate, status, stock);
    };

    @Override
    public ProductCreated insertOne(ProductOperationRequest request) {
        String SQL = new StringBuilder().append("INSERT INTO PRODUCTS ")
                .append("(id, name, description, price, tax_rate, status, stock)")
                .append("VALUES (?, ?, ?, ?, ?, ?, ?)")
                .toString();

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, request.getName().getValue());
            ps.setString(2, request.getDescription().getValue());
            ps.setBigDecimal(3, request.getPrice().getValue());
            ps.setBigDecimal(4, request.getTaxRate().getValue());
            ps.setString(5, request.getStatus().toString());
            ps.setInt(6, request.getStock().getValue());

            return ps;
        }, keyHolder);

        Id productId = Id.of(keyHolder.getKey().longValue());
        return ProductCreated.from(request, productId);
    }

    /*@Override
    public ProductCreated insertOne(ProductOperationRequest request) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", request.getName().getValue());
        parameters.put("description", request.getDescription().getValue());
        parameters.put("price", request.getPrice().getValue());
        parameters.put("tax_rate", request.getTaxRate().getValue());
        parameters.put("status", request.getStatus().toString());
        parameters.put("stock", request.getStock().getValue());

        Number number = simpleJdbcInsert.executeAndReturnKey(parameters);
        Id productId = Id.of(number.longValue());
        return ProductCreated.from(request, productId);
    }*/

    @Override
    public Optional<ProductCreated> findById(Id productId) {
        String SQL = new StringBuilder()
                .append("SELECT id, name, description, price, tax_rate, status, stock")
                .append("FROM PRODUCTS WHERE id = ?")
                .toString();

        Object[] objects = {productId};

        try {
            ProductCreated product = jdbcTemplate.queryForObject(SQL, objects, rowMapper);
            return Optional.of(product);
        } catch (EmptyResultDataAccessException exception) {
            return Optional.empty();
        }
    }

    @Override
    public List<ProductCreated> findAll() {
        String SQL = new StringBuilder()
                .append("SELECT id, name, description, price, tax_rate, status, stock")
                .append("FROM PRODUCTS")
                .toString();

        return jdbcTemplate.query(SQL, rowMapper);
    }

    @Override
    public Optional<ProductCreated> updateOne(Id productId, ProductOperationRequest request) {
        return Optional.empty();
    }

    @Override
    public Optional<ProductCreated> deleteOne(Id productId) {
        return Optional.empty();
    }
}
