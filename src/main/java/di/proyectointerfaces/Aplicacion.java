/**
 * Clase: Aplicacion
 * Autor: Patricia Rosales
 * Fecha de creación: 2024
 * Descripción-Enunciado: Clase para ejecutar el proyecto
 */

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
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("Palabra del dia");
        stage.setMinHeight(600);
        stage.setMaxHeight(600);
        stage.setMinWidth(900);
        stage.setMaxWidth(900);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}