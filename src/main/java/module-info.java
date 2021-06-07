module pratico02{
    requires javafx.controls;
    requires javafx.fxml;

    opens br.edu.class07 to javafx.fxml;
    exports br.edu.class07;
}