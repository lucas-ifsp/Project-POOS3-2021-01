package br.edu.class08.view;

import br.edu.class08.controller.SecondWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SecondWindow {

    public String show(String text) {
        String result = null;

        try {
            FXMLLoader loader = new FXMLLoader();
            Parent graph = loader.load(getClass().getResource("secondwindow.fxml").openStream());
            Scene scene = new Scene(graph, 190, 130);

            SecondWindowController controller = loader.getController();
            controller.setData(text);


            Stage stage =  new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

            result = controller.getData();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
