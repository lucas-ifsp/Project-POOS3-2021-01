module poos3{
    requires javafx.controls;
    requires javafx.fxml;

    opens br.edu.class07 to javafx.fxml;
    opens br.edu.class08.controller to javafx.fxml;
    opens br.edu.class08.model to javafx.base;
    opens br.edu.class09.controller to javafx.fxml;
    opens br.edu.class09.model to javafx.base;


    exports br.edu.class07;
    exports br.edu.class08.view to javafx.graphics;
    exports br.edu.class09.view to javafx.graphics;
}