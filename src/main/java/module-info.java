module application {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;

    opens application to javafx.fxml;
    exports application;
}
