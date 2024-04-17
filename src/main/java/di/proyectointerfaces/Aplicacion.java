package di.proyectointerfaces;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Aplicacion extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 550);
        stage.setTitle("Palabra del dia");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}