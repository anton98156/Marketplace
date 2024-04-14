package com.marketplace.service.repository;

import com.marketplace.service.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

@Repository
public class ProductRepository {
    
    // Взаимодействие с БД.
    private final JdbcTemplate jdbc;
    public ProductRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Сохранение нового товара.
    public Product save(Product product) {
        String sql = "INSERT INTO productTable (name, description, price) VALUES (?, ?, ?)";
        jdbc.update(sql, product.getName(), product.getDescription(), product.getPrice());
        return product;
    }

    // Вывод всех товаров.
    public List<Product> findAll() {
        String sql = "SELECT * FROM productTable";
        RowMapper<Product> productRowMapper = (r, i) -> {
            Product rowObject = new Product();
            rowObject.setId(r.getInt("id"));
            rowObject.setName(r.getString("name"));
            rowObject.setDescription(r.getString("description"));
            rowObject.setPrice(r.getInt("price"));
            return rowObject;
        };

        return jdbc.query(sql, productRowMapper);
    }

    // Поиск товара по ID.
    public Product findById(int id) {
        String sql = "SELECT * FROM productTable WHERE id = ?";
        RowMapper<Product> productRowMapper = (r, i) -> {
            Product rowObject = new Product();
            rowObject.setId(r.getInt("id"));
            rowObject.setName(r.getString("name"));
            rowObject.setDescription(r.getString("description"));
            rowObject.setPrice(r.getInt("price"));
            return rowObject;
        };

        return jdbc.queryForObject(sql, productRowMapper, id);
    }

    // Обновление продукта.
    public Product updateById(Product product, int id) {
        String sql = "UPDATE productTable SET name = ?, description = ?, price = ? WHERE id = ?";
        jdbc.update(sql, product.getName(), product.getDescription(), product.getPrice(), id);
        return product;
    }

    // Удаление продукта.
    public void deleteById(int id) {
        String sql = "DELETE FROM productTable WHERE id=?";
        jdbc.update(sql, id);
    }
    
}