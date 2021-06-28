package br.edu.class10.controller;

import br.edu.class10.dao.ProductDAO;
import br.edu.class10.model.Product;
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
        products.setAll(ProductDAO.readAll());
    }

    public void addProduct(ActionEvent actionEvent) {
        String name = txtName.getText();
        Double price = Double.valueOf(txtPrice.getText());
        Integer quantity = Integer.valueOf(txtQuantity.getText());

        if(selectedProduct != null){
            selectedProduct.setName(name);
            selectedProduct.setPrice(price);
            selectedProduct.setQuantity(quantity);
            ProductDAO.update(selectedProduct);
        } else {
            ProductDAO.save(new Product(name, price, quantity));
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
            ProductDAO.delete(selectedProduct.getCode());
            loadData();
        }
        this.selectedProduct = null;
    }
}
