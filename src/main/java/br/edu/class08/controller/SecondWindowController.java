package br.edu.class08.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SecondWindowController {

    @FXML
    private Button btnClose;
    @FXML
    private Label lbParameter;
    @FXML
    private TextField txtResult;

    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    public void setData(String text) {
        lbParameter.setText(text);
    }

    public String getData() {
        return txtResult.getText();
    }
}
