/**
 * Clase: ControladorSeis
 * Autor: Patricia Rosales
 * Fecha de creación: 2024
 * Descripción-Enunciado: Controlador para la opción de seis letras
 */

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

public class ControladorSeis implements Initializable {
    private String palabraSecreta;
    private final int intentosMaximos = 5;
    private int intentosRealizados = 0;

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
    private VBox intentos;


    @FXML
    private HBox hboxBotones1;

    @FXML
    private HBox hboxBotones2;

    @FXML
    private HBox hboxBotones3;

    private Set<String> letrasPulsadas = new HashSet<>();


    @FXML
    private Button botonComprobar;

    @FXML
    private VBox fondo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarPalabraSecreta();
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


    /**Método para que se escriba la letra pulsada si la casilla está vacía*/
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
        }
    }


    public void cargarPalabraSecreta() {
        List<String> palabras = new ArrayList<>();

        // Ruta del archivo que contiene las palabras
        String archivoPalabras = "6.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoPalabras))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabrasEnLinea = linea.split(" ");
                for (String palabra : palabrasEnLinea) {
                    palabras.add(palabra);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Seleccionar una palabra aleatoria de la lista
        Random aleatoria = new Random();
        palabraSecreta = palabras.get(aleatoria.nextInt(palabras.size()));
        System.out.println(palabraSecreta);
    }


    /**Método para comprobar si la palabra es correcta o no*/
    @FXML
    private void comprobarPalabra() {
        // Verificar si se han alcanzado el máximo de intentos
        if (intentosRealizados == intentosMaximos) {
            mostrarMensaje("¡Lo siento!", "Has alcanzado el límite de intentos.\nLa palabra correcta era: " + palabraSecreta);
            return;
        }

        String palabraIngresada = l1.getText() + l2.getText() + l3.getText() + l4.getText() + l5.getText() + l6.getText();

        for (Node nodo : hboxBotones1.getChildren()) {
            if (nodo instanceof Button) {
                Button boton = (Button) nodo;
                String letraBoton = boton.getText();

                // Verificar si la letra del botón ha sido pulsada y cambia el color según esté o no en la palabra secreta
                if (letrasPulsadas.contains(letraBoton)) {
                    if (palabraSecreta.contains(letraBoton)) {
                        boton.setStyle("-fx-background-color: green; -fx-background-radius: 5px; -fx-border-radius: 5px; -fx-border-color: black;");
                    } else {
                        boton.setStyle("-fx-background-color: red; -fx-background-radius: 5px; -fx-border-radius: 5px; -fx-border-color: black;");
                    }
                }
            }
        }

        for (Node nodo : hboxBotones2.getChildren()) {
            if (nodo instanceof Button) {
                Button boton = (Button) nodo;
                String letraBoton = boton.getText();

                // Verificar si la letra del botón ha sido pulsada y cambia el color según esté o no en la palabra secreta
                if (letrasPulsadas.contains(letraBoton)) {
                    // Cambiar el color del botón según si la letra está en la palabra secreta o no
                    if (palabraSecreta.contains(letraBoton)) {
                        // La letra está en la palabra secreta, cambiar el color del botón a verde
                        boton.setStyle("-fx-background-color: green; -fx-background-radius: 5px; -fx-border-radius: 5px; -fx-border-color: black;");
                    } else {
                        // La letra no está en la palabra secreta, cambiar el color del botón a rojo
                        boton.setStyle("-fx-background-color: red; -fx-background-radius: 5px; -fx-border-radius: 5px; -fx-border-color: black;");
                    }
                }
            }
        }

        for (Node nodo : hboxBotones3.getChildren()) {
            if (nodo instanceof Button) {
                Button boton = (Button) nodo;
                String letraBoton = boton.getText();

                // Verificar si la letra del botón ha sido pulsada y cambia el color según esté o no en la palabra secreta
                if (letrasPulsadas.contains(letraBoton)) {
                    if (palabraSecreta.contains(letraBoton)) {
                        boton.setStyle("-fx-background-color: green; -fx-background-radius: 5px; -fx-border-radius: 5px; -fx-border-color: black;");
                    } else {
                        boton.setStyle("-fx-background-color: red; -fx-background-radius: 5px; -fx-border-radius: 5px; -fx-border-color: black;");
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
            l6.clear();

            Label intento = new Label(palabraIngresada);
            intentos.getChildren().add(intento);
            intentosRealizados++;
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


    /**Método para empezar una partida nueva, se deja como estaba al principio*/
    public void nuevaPartida() {
        l1.clear();
        l2.clear();
        l3.clear();
        l4.clear();
        l5.clear();
        l6.clear();

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
                botonComprobar.setStyle("-fx-background-color: none; -fx-border-radius: 5px; -fx-border-color: black; -fx-text-fill: white");
            }
        }
        cargarPalabraSecreta();
    }


    /**Método para volver al menú de inicio*/
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

}
