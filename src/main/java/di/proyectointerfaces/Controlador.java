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

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

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
    private VBox letras;

    @FXML
    private HBox hboxBotones1;

    @FXML
    private HBox hboxBotones2;

    @FXML
    private HBox hboxBotones3;

    private Set<String> letrasPulsadas = new HashSet<>();



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

    @FXML
    void inicio() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));


            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void pulsarTecla(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String letraPulsada = btn.getText();

        letrasPulsadas.add(letraPulsada);

        if (l1.getText().isEmpty()) {
            l1.setText(letraPulsada);
        } else if (l2.getText().isEmpty()) {
            l2.setText(letraPulsada);
        } else if (l3.getText().isEmpty()) {
            l3.setText(letraPulsada);
        } else if (l4.getText().isEmpty()) {
            l4.setText(letraPulsada);
        } else if (l5.getText().isEmpty()) {
            l5.setText(letraPulsada);
        } else if (l6.getText().isEmpty()) {
            l6.setText(letraPulsada);
        } else if (l7.getText().isEmpty()) {
            l7.setText(letraPulsada);
        }
    }


    @FXML
    private void comprobarPalabra(ActionEvent event) {
        palabraSecreta = "AUDIO";
        String palabraIngresada = l1.getText() + l2.getText() + l3.getText() + l4.getText() + l5.getText();

        // Iterar sobre cada botón
        for (Node nodo : hboxBotones1.getChildren()) {
            if (nodo instanceof Button) {
                Button boton = (Button) nodo;
                String letraBoton = boton.getText();

                // Verificar si la letra del botón ha sido pulsada
                if (letrasPulsadas.contains(letraBoton)) {
                    // Cambiar el color del botón según si la letra está en la palabra secreta o no
                    if (palabraSecreta.contains(letraBoton)) {
                        // La letra está en la palabra secreta, cambiar el color del botón a verde
                        boton.setStyle("-fx-background-color: green; -fx-border-radius: 5px; -fx-border-color: black;");
                    } else {
                        // La letra no está en la palabra secreta, cambiar el color del botón a rojo
                        boton.setStyle("-fx-background-color: red; -fx-border-radius: 5px; -fx-border-color: black;");
                    }
                }
            }
        }

        for (Node nodo : hboxBotones2.getChildren()) {
            if (nodo instanceof Button) {
                Button boton = (Button) nodo;
                String letraBoton = boton.getText();

                // Verificar si la letra del botón ha sido pulsada
                if (letrasPulsadas.contains(letraBoton)) {
                    // Cambiar el color del botón según si la letra está en la palabra secreta o no
                    if (palabraSecreta.contains(letraBoton)) {
                        // La letra está en la palabra secreta, cambiar el color del botón a verde
                        boton.setStyle("-fx-background-color: green; -fx-border-radius: 5px; -fx-border-color: black;");
                    } else {
                        // La letra no está en la palabra secreta, cambiar el color del botón a rojo
                        boton.setStyle("-fx-background-color: red; -fx-border-radius: 5px; -fx-border-color: black;");
                    }
                }
            }
        }

        for (Node nodo : hboxBotones3.getChildren()) {
            if (nodo instanceof Button) {
                Button boton = (Button) nodo;
                String letraBoton = boton.getText();

                // Verificar si la letra del botón ha sido pulsada
                if (letrasPulsadas.contains(letraBoton)) {
                    // Cambiar el color del botón según si la letra está en la palabra secreta o no
                    if (palabraSecreta.contains(letraBoton)) {
                        // La letra está en la palabra secreta, cambiar el color del botón a verde
                        boton.setStyle("-fx-background-color: green; -fx-border-radius: 5px; -fx-border-color: black;");
                    } else {
                        // La letra no está en la palabra secreta, cambiar el color del botón a rojo
                        boton.setStyle("-fx-background-color: red; -fx-border-radius: 5px; -fx-border-color: black;");
                    }
                }
            }
        }

        if (palabraIngresada.equals(palabraSecreta)) {
            mostrarMensaje("¡Felicidades!", "¡" + palabraSecreta + " es la palabra es correcta!");
        } else {
            l1.clear();
            l2.clear();
            l3.clear();
            l4.clear();
            l5.clear();

            Label intento = new Label(palabraIngresada);
            intentos.getChildren().add(intento);
        }
    }


    private void mostrarMensaje(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }


    public void salir() {
        Platform.exit();
    }


    public void nuevaPartida() {
        l1.clear();
        l2.clear();
        l3.clear();
        l4.clear();
        l5.clear();
        intentos.getChildren().clear();

        for (Node nodo : hboxBotones1.getChildren()) {
            if (nodo instanceof Button) {
                Button boton = (Button) nodo;
                boton.setStyle("-fx-background-color: none; -fx-border-radius: 5px; -fx-border-color: black;");
            }
        }
        for (Node nodo : hboxBotones2.getChildren()) {
            if (nodo instanceof Button) {
                Button boton = (Button) nodo;
                boton.setStyle("-fx-background-color: none; -fx-border-radius: 5px; -fx-border-color: black;");
            }
        }
        for (Node nodo : hboxBotones3.getChildren()) {
            if (nodo instanceof Button) {
                Button boton = (Button) nodo;
                boton.setStyle("-fx-background-color: none; -fx-border-radius: 5px; -fx-border-color: black;");
            }
        }
    }


}