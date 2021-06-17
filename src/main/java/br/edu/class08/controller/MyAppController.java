package br.edu.class08.controller;

import br.edu.class08.view.SecondWindow;
import javafx.event.ActionEvent;

public class MyAppController {

    public void handleTouch(ActionEvent actionEvent) {
        SecondWindow newWindow = new SecondWindow();
        String result = newWindow.show("Novo texto");
        System.out.println(result);
    }
}
