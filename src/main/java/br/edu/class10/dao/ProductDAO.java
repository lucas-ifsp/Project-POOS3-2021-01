package br.edu.class10.dao;

import br.edu.class10.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private ProductDAO(){

    }

    public static void save(Product p) {
        String sql = "INSERT INTO product (code, name, price, quantity) values (?,?,?,?)";

        try (var stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setString(1, p.getCode());
            stmt.setString(2, p.getName());
            stmt.setDouble(3, p.getPrice());
            stmt.setInt(4, p.getQuantity());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Product read(String pKey) {
        Product p = null;
        String sql = "SELECT * FROM product WHERE code = ?";

        try (var stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setString(1, pKey);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                p = new Product(rs.getString("code"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"));

        } catch (SQLException e){
            e.printStackTrace();

        }
        return p;
    }

    public static List<Product> readAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try (var stmt = ConnectionFactory.createPreparedStatement(sql) ){
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                products.add(new Product(rs.getString("code"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")));

        } catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    public static synchronized void update(Product p){
        String sql = "UPDATE product SET name = ?, quantity = ?, price = ? WHERE code = ?";
        try (var stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setString(1, p.getName());
            stmt.setInt(2, p.getQuantity());
            stmt.setDouble(3, p.getPrice());
            stmt.setString(4, p.getCode());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(String pKey){
        String sql = "DELETE FROM product WHERE code = ?" ;
        try (var stmt = ConnectionFactory.createPreparedStatement(sql)) {
            stmt.setString(1, pKey);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
