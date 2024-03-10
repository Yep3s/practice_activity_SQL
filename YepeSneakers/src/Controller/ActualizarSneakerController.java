package Controller;

import Model.Zapato;
import controladoresSQL.Sql;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ActualizarSneakerController {

    @FXML
    private Button actualizarSneaker;

    @FXML
    private TextField brand;

    @FXML
    private TextField code;

    @FXML
    private TextField color;

    @FXML
    private Button comeback;

    @FXML
    private TextField model;

    @FXML
    private TextField price;

    @FXML
    private TextField quantity;

    @FXML
    private Button search;

    @FXML
    private TextField size;

    @FXML
    private Text textoCambiado;

    Sql sql = new Sql();
    Zapato Zapato = new Zapato();

    @FXML
    void searchBTN(ActionEvent event) {

        try {
            String codigo = code.getText();
            Zapato sneaker = sql.buscarSneakerPorCodigo(codigo);
            if (sneaker != null) {

                brand.setText(sneaker.getMarca());
                size.setText(sneaker.getTalla());
                model.setText(sneaker.getModelo());
                color.setText(sneaker.getColor());
                quantity.setText(String.valueOf(sneaker.getCantidad()));
                price.setText(String.valueOf(sneaker.getPrecio()));
            } else {
                brand.setText("");
                size.setText("");
                model.setText("");
                color.setText("");
                quantity.setText("");
                price.setText("");
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el sneaker: " + e.getMessage());
        }

    }

    @FXML
    void actualizarSneakerBTN(ActionEvent event) throws SQLException {

        try {
            String codigo = code.getText();
            String marca = brand.getText();
            String talla = size.getText();
            String modelo = model.getText();
            String colore = color.getText();
            int cantidad = Integer.parseInt(quantity.getText());
            int precio = Integer.parseInt(price.getText());
            Zapato sneaker = new Zapato(codigo, marca, talla, modelo, colore, cantidad, precio);
            sql.actualizarSneaker(sneaker);
            
                    try {
            // Cargar el archivo FXML de la segunda vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ActualizadoExito.fxml"));
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
            
            
            
        } catch (NumberFormatException e) {
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
