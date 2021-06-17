package br.edu.class08.controller;

import br.edu.class08.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class TableExampleController {
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
        products.add(new Product("Paiero", 5.0, 3));
        products.add(new Product("Crystal", 2.0, 2));
        products.add(new Product("Berenice", 5000.0, 1));
    }

    public void addProduct(ActionEvent actionEvent) {
        String name = txtName.getText();
        Double price = Double.valueOf(txtPrice.getText());
        Integer quantity = Integer.valueOf(txtQuantity.getText());
        Product product = new Product(name, price, quantity);
        products.add(product);
    }

    public void handleRowSelection(MouseEvent mouseEvent) {
        Product selectedProduct = tableProducts.getSelectionModel().getSelectedItem();
        if (selectedProduct != null)
            products.remove(selectedProduct);
    }
}
