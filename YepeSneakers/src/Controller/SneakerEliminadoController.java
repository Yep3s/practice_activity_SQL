package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SneakerEliminadoController {

    @FXML
    private Button aceptar;

    @FXML
    void aceptarBTN(ActionEvent event) {
        try {
            // Cargar el archivo FXML de la segunda vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Menu.fxml"));
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
