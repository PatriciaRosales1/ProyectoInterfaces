package di.proyectointerfaces;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controlador implements Initializable {
    private String palabraSecreta;

    @FXML
    private Button dificil;

    @FXML
    private Button facil;

    @FXML
    private VBox fondo;

    @FXML
    private Button medio;

    @FXML
    private Button inicio;

    @FXML
    private TextField l1;

    @FXML
    private TextField l2;

    @FXML
    private TextField l3;

    @FXML
    private TextField l4;

    @FXML
    private TextField l5;

    @FXML
    private TextField l6;

    @FXML
    private TextField l7;

    @FXML
    private VBox intentos;


    @FXML
    private HBox hboxBotones1;

    @FXML
    private HBox hboxBotones2;

    @FXML
    private HBox hboxBotones3;



    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //cargarImagenDeFondo();
    }


    private void cargarImagenDeFondo() {
        try {
            // Ajusta la ruta de la imagen según tu estructura de proyecto
            Image imagenFondo = new Image(getClass().getResourceAsStream("/di/proyectointerfaces/fondo.jpg"));

            BackgroundImage fondo1 = new BackgroundImage(imagenFondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background fondo2 = new Background(fondo1);

            fondo.setBackground(fondo2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



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