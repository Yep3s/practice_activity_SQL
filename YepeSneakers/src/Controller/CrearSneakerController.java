package Controller;

import Model.Zapato;
import controladoresSQL.Sql;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CrearSneakerController {

    @FXML
    private TextField brand;

    @FXML
    private TextField code;

    @FXML
    private TextField color;

    @FXML
    private Button comeback;

    @FXML
    private Button crearNuevoSneaker;

    @FXML
    private TextField model;

    @FXML
    private TextField price;

    @FXML
    private TextField quantity;

    @FXML
    private TextField size;

    @FXML
    void nuevoSneakerBtn(ActionEvent event) {

        try {
            Sql controlador = new Sql();
            Zapato zapato = new Zapato();

            controlador.guardarSneaker(
                    new Zapato(code.getText(),
                            brand.getText(),
                           size.getText(),
                            model.getText(),
                            color.getText(),
                            Integer.parseInt(quantity.getText()),
                            Integer.parseInt(price.getText())));

            // Cargar el archivo FXML de la segunda vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Guardado.fxml"));
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
    void volverBTN(ActionEvent event) {

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
