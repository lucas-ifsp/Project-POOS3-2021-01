package br.edu.class09.controller;

import br.edu.class09.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManagementController {
    @FXML
    TableView<Product> tableProducts;
    @FXML
    TableColumn<Product, String> cName;
    @FXML
    TableColumn<Product, Double> cPrice;
    @FXML
    TableColumn<Product, Integer> cQuantity;
    @FXML
    TextField txtName;
    @FXML
    TextField txtPrice;
    @FXML
    TextField txtQuantity;

    private ObservableList<Product> products;
    private Product selectedProduct = null;

    @FXML
    private void initialize() {
        bindTableToModel();
        bindTableToDataSource();
        loadData();
    }

    private void bindTableToModel() {
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        cQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    }

    private void bindTableToDataSource() {
        products = FXCollections.observableArrayList();
        tableProducts.setItems(products);
    }

    private void loadData() {
        products.clear();
        products.setAll(readAll());
    }

    public void addProduct(ActionEvent actionEvent) {
        String name = txtName.getText();
        Double price = Double.valueOf(txtPrice.getText());
        Integer quantity = Integer.valueOf(txtQuantity.getText());

        if(selectedProduct != null){
            selectedProduct.setName(name);
            selectedProduct.setPrice(price);
            selectedProduct.setQuantity(quantity);
            update(selectedProduct);
        } else {
            save(new Product(name, price, quantity));
        }

        loadData();
        setFieldsData("", "", "");
        this.selectedProduct = null;
    }

    private void setFieldsData(String name, String price, String quantity) {
        txtName.setText(name);
        txtPrice.setText(price);
        txtQuantity.setText(quantity);
    }

    public void handleRowSelection(MouseEvent mouseEvent) {
        Product selectedProduct = tableProducts.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            setFieldsData(selectedProduct.getName(), String.valueOf(selectedProduct.getPrice()), String.valueOf(selectedProduct.getQuantity()));
            this.selectedProduct = selectedProduct;
        }else {
            this.selectedProduct = null;
        }
    }

    public void rmProduct(ActionEvent actionEvent) {
        Product selectedProduct = tableProducts.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            setFieldsData(selectedProduct.getName(), String.valueOf(selectedProduct.getPrice()), String.valueOf(selectedProduct.getQuantity()));
            //delete(selectedProduct.getCode());

            // aqui estamos forçando injeção de SQL na mão para fins didáticos. Como 1 = 1 é sempre verdade, a adição do OR
            // faz com que o WHERE retorne true independentemente do Code, afetando todas as linhas da tablela.
            // Se code fosse um campo como e-mail, digitado pelo usuário, teriamos sérios problemas de security na aplicação.
            // Imagine uma sql como essa: SELECT * FROM tabela_usuarios WHERE login = '123' AND senha = ' ' or '1' = '1'.
            // Nesse caso o usuário consegue acesso ao seu sistema mesmo senão tiver conta ou não souber senha.
            deleteWithStatement(selectedProduct.getCode() + "' OR '1'='1");
            loadData();
        }
        this.selectedProduct = null;
    }

    public void save(Product p) {
        String sql = "INSERT INTO product (code, name, price, quantity) values (?,?,?,?)";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getCode());
            stmt.setString(2, p.getName());
            stmt.setDouble(3, p.getPrice());
            stmt.setInt(4, p.getQuantity());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product read(String pKey) {
        Product p = null;
        String sql = "SELECT * FROM product WHERE code = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
             PreparedStatement stmt = conn.prepareStatement(sql)) {

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

    public List<Product> readAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
             PreparedStatement stmt = conn.prepareStatement(sql)) {

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

    public void update(Product p){
        String sql = "UPDATE product SET name = ?, quantity = ?, price = ? WHERE code = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getName());
            stmt.setInt(2, p.getQuantity());
            stmt.setDouble(3, p.getPrice());
            stmt.setString(4, p.getCode());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String pKey){
        String sql = "DELETE FROM product WHERE code = ?" ;
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pKey);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteWithStatement(String pKey){
        String sql = "DELETE FROM product WHERE code ='" + pKey + "'";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
