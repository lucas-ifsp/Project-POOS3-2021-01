package br.edu.class09.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProductManagementApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent graph = FXMLLoader.load(getClass().getResource("product_management.fxml"));
        Scene scene = new Scene(graph, 730, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gerenciador de Estoque");
        primaryStage.show();
    }
}
