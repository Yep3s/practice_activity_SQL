package Controller;

import Model.Zapato;
import controladoresSQL.Sql;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class VerSneakerController implements Initializable {

    @FXML
    private TableColumn<Zapato, Integer> QuantityColumn;

    @FXML
    private TableColumn<Zapato, String> brandColumn;

    @FXML
    private TableColumn<Zapato, String> codeColumn;

    @FXML
    private TableColumn<Zapato, String> colorColumn;

    @FXML
    private Button comeback;

    @FXML
    private TableColumn<Zapato, String> modelColumn;

    @FXML
    private TableColumn<Zapato, Integer> priceColumn;

    @FXML
    private TableColumn<Zapato, String> sizeColumn;

    @FXML
    private TableView<Zapato> sneakersTable;

    Sql sql = new Sql();
    ObservableList<Zapato> sneakersList = null;

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
@Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ArrayList<Zapato> sneakers = sql.obtenerSneakers();
            System.out.println("sneakers" + sneakers);
            sneakersList = FXCollections.observableArrayList(sneakers);
            codeColumn.setCellValueFactory(new PropertyValueFactory<Zapato, String>("Codigo"));
            brandColumn.setCellValueFactory(new PropertyValueFactory<Zapato, String>("Marca"));
            sizeColumn.setCellValueFactory(new PropertyValueFactory<Zapato, String>("Talla"));
            modelColumn.setCellValueFactory(new PropertyValueFactory<Zapato, String>("Modelo"));
            colorColumn.setCellValueFactory(new PropertyValueFactory<Zapato, String>("Color"));
            QuantityColumn.setCellValueFactory(new PropertyValueFactory<Zapato, Integer>("Cantidad"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<Zapato, Integer>("Precio"));
            sneakersTable.setItems(sneakersList);
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }
    }

}
