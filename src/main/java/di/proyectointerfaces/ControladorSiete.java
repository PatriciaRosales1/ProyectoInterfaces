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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ControladorSiete implements Initializable {
    private String palabraSecreta;
    private final int MAX_INTENTOS = 5;
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
    private TextField l7;


    @FXML
    private VBox intentos;


    @FXML
    private HBox hboxBotones1;

    @FXML
    private HBox hboxBotones2;

    @FXML
    private HBox hboxBotones3;

    private Set<String> letrasPulsadas = new HashSet<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarPalabraSecreta();
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


    public void cargarPalabraSecreta() {
        List<String> palabras = new ArrayList<>();

        // Ruta del archivo que contiene las palabras
        String archivoPalabras = "7.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoPalabras))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Separar la línea en palabras individuales
                String[] palabrasEnLinea = linea.split(" ");
                // Agregar las palabras a la lista
                for (String palabra : palabrasEnLinea) {
                    palabras.add(palabra);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Seleccionar una palabra aleatoria de la lista
        Random rand = new Random();
        palabraSecreta = palabras.get(rand.nextInt(palabras.size()));
        System.out.println(palabraSecreta);
    }


    @FXML
    private void comprobarPalabra() {
        // Verificar si se han alcanzado el máximo de intentos
        if (intentosRealizados >= MAX_INTENTOS) {
            mostrarMensaje("¡Lo siento!", "Has alcanzado el límite de intentos.\nLa palabra correcta era: " + palabraSecreta);
            return;
        }

        String palabraIngresada = l1.getText() + l2.getText() + l3.getText() + l4.getText() + l5.getText() + l6.getText() + l7.getText();

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
            l6.clear();
            l7.clear();

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


    public void nuevaPartida() {
        l1.clear();
        l2.clear();
        l3.clear();
        l4.clear();
        l5.clear();
        l6.clear();
        l7.clear();

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
        cargarPalabraSecreta();
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

}
