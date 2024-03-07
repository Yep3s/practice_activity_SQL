package Main;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import configuration.Conexion;



public class Main extends Application {

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        try {

            try {

                Conexion conexion = Conexion.getInstance();
                conexion.setUsuario("root");
                conexion.setContraseña("Cartagena2023-");
                conexion.setUrl("jdbc:mysql://localhost:3306/tutoriales_bd");
                conexion.setDraiver("com.mysql.cj.jdbc.Driver");
                conexion.conectar();

                System.out.println("Conexion Exitosa");
            } catch (Exception e) {

                System.out.println("Error Al Conectar A La Base De Datos" + e.getMessage());

            }

            // Cargar el archivo FXML de la primera vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Menu.fxml"));
            Parent root = loader.load();

            // Configurar el controlador si es necesario
            // Ejemplo: PanelStart controller = loader.getController();
            // Crear una nueva escena y configurarla
            Scene scene = new Scene(root);

            // Configurar la escena en la etapa principal
            primaryStage.setScene(scene);
            primaryStage.setTitle("Sneaker Land"); // Puedes personalizar el título
            primaryStage.show(); //show es mostrar

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}