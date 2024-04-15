module di.proyectointerfaces {
    requires javafx.controls;
    requires javafx.fxml;


    opens di.proyectointerfaces to javafx.fxml;
    exports di.proyectointerfaces;
}