package di.proyectointerfaces;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

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
        //cargarImagenDeFondo();

    }

    private void cargarImagenDeFondo() {
        try {
            // Ajusta la ruta de la imagen según tu estructura de proyecto
            Image imagenFondo = new Image(getClass().getResourceAsStream("/di/proyectointerfaces/fondo.jpg"));

            BackgroundImage fondo1 = new BackgroundImage(imagenFondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background fondo2 = new Background(fondo1);

            fondo.setBackground(fondo2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @FXML
    void nivelDificil() {

    }

    @FXML
    void nivelFacil() {

    }

    @FXML
    void nivelMedio() {

    }
}