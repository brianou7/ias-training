package co.edu.ff.orders.product.configuration;

import co.edu.ff.orders.product.repositories.InMemoryProductRepository;
import co.edu.ff.orders.product.repositories.contracts.ProductRepository;
import co.edu.ff.orders.user.repositories.ImMemoryUserRepository;
import co.edu.ff.orders.user.repositories.SqlUserRepository;
import co.edu.ff.orders.user.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

@Configuration
public class ProductRepositoryConfiguration {

    @Bean
    @Profile({"dev",  "test"})
    public ProductRepository productRepository() {
        return new InMemoryProductRepository();
    }

}
