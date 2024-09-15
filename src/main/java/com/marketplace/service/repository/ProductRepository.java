package com.marketplace.service.repository;

import org.springframework.stereotype.Repository;

import com.marketplace.service.object.Product;

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
        String sql = "INSERT INTO productTable (name, description, price, stock) VALUES (?, ?, ?, ?)";
        jdbc.update(sql, product.getName(), product.getDescription(), product.getPrice(), product.getStock());
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
            rowObject.setStock(r.getBoolean("stock"));
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
            rowObject.setStock(r.getBoolean("stock"));
            return rowObject;
        };

        return jdbc.queryForObject(sql, productRowMapper, id);
    }

    // Обновление продукта.
    public Product updateById(Product product, int id) {
        String sql = "UPDATE productTable SET name = ?, description = ?, price = ?, stock = ? WHERE id = ?";
        jdbc.update(sql, product.getName(), product.getDescription(), product.getPrice(), product.getStock(), id);
        return product;
    }

    // Удаление продукта.
    public void deleteById(int id) {
        String sql = "DELETE FROM productTable WHERE id=?";
        jdbc.update(sql, id);
    }
    
}