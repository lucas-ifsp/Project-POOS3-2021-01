package br.edu.class07;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ViewReverter extends Application {

    private TextField tfInput; //Campo de texto
    private Label lbResult, lbInput; // Rótulo, não editável
    private Button btnExecute; // Botão
    private ViewReverterController ctrl = new ViewReverterController(this);

    public static void main (String[] args){
        launch(args); //método launch de Application
    }

    @Override
    public void start(Stage stage) throws Exception {
        lbInput = new Label("Input:");
        tfInput = new TextField();
        tfInput.setPromptText("Input text"); //Dica de texto para tfInput
        btnExecute = new Button("Revert");
        btnExecute.setOnAction(e -> ctrl.reverse());

        lbResult = new Label("Result:");

        HBox layout = new HBox(); //layout horizontal
        layout.setSpacing(10); //espaçamento entre componentes
        layout.setPadding(new Insets(10, 10, 10, 10)); //espaçamento interno
        layout.setAlignment(Pos.BASELINE_LEFT); //alinhamento dos componentes
        layout.getChildren().addAll(lbInput, tfInput, btnExecute, lbResult); //add elementos

        Scene scene = new Scene(layout, 600, 80); //cria uma cena com layout e tamanho

        stage.setTitle("String Reverter"); //título do stage/palco/janela
        stage.setScene(scene); //indica qual cena acontecerá no palco
        stage.show(); //exibe a janela
    }

    public String getInput() {
       return tfInput.getText();
    }

    public void setText(String s) {
        lbResult.setText(s);
    }
}