package br.edu.class08.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MyApp extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent graph = FXMLLoader.load(getClass().getResource("myapp.fxml"));
        Scene scene = new Scene(graph, 150, 90);
        stage.setScene(scene);
        stage.show();
    }


}
