package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private Button VerSneakers;

    @FXML
    private Button actualizarSneakers;

    @FXML
    private Button crearNuevoSneaker;

    @FXML
    private Button eliminarSneakers;

    @FXML
    void actualizarSneakerBtn(ActionEvent event) {

    }

    @FXML
    void eliminarSneakerBtn(ActionEvent event) {

    }

    @FXML
    void nuevoSneakerBtn(ActionEvent event) {

        try {
            // Cargar el archivo FXML de la segunda vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CrearUnNuevoSneaker.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la segunda vista
            // Si es necesario realizar acciones en el controlador de la segunda vista, obtén el controlador aquí
            // Ejemplo: SegundoControlador controller = loader.getController();
            // Crear una nueva escena y configurarla
            Scene scene = new Scene(root);

            // Crear una nueva ventana
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Sneaker Land"); // Puedes personalizar el título

            // Mostrar la nueva ventana
            stage.show();

        // Cerrar la ventana actual (opcional)
            ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void verSneakerBtn(ActionEvent event) {

         try {
            // Cargar el archivo FXML de la segunda vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/VerSneakers.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la segunda vista
            // Si es necesario realizar acciones en el controlador de la segunda vista, obtén el controlador aquí
            // Ejemplo: SegundoControlador controller = loader.getController();
            // Crear una nueva escena y configurarla
            Scene scene = new Scene(root);

            // Crear una nueva ventana
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Sneaker Land"); // Puedes personalizar el título

            // Mostrar la nueva ventana
            stage.show();

        // Cerrar la ventana actual (opcional)
            ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

}
