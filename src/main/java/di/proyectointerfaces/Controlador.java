/**
 * Clase: Controlador
 * Autor: Patricia Rosales
 * Fecha de creación: 2024
 * Descripción-Enunciado: Controlador principal para cargar cada opción
 */

package di.proyectointerfaces;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controlador implements Initializable {

    @FXML
    private Button dificil;

    @FXML
    private Button facil;

    @FXML
    private VBox fondo;

    @FXML
    private Button medio;



    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarImagenDeFondo();
    }


    private void cargarImagenDeFondo() {
        try {
            // Ajusta la ruta de la imagen según tu estructura de proyecto
            Image imagenFondo = new Image(getClass().getResourceAsStream("/di/proyectointerfaces/fondo.png"));

            BackgroundImage fondo1 = new BackgroundImage(imagenFondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background fondo2 = new Background(fondo1);

            fondo.setBackground(fondo2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**Método para cargar la opción de cinco letras*/
    @FXML
    void nivelFacil() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cinco.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));


            stage.show();

            ((Stage) facil.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**Método para cargar la opción de seis letras*/
    @FXML
    void nivelMedio() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("seis.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));


            stage.show();

            ((Stage) medio.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**Método para cargar la opción de siete letras*/
    @FXML
    void nivelDificil() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("siete.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));


            stage.show();

            ((Stage) dificil.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}