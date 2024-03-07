
package configuration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class Conexion {

    private Connection connection;
    private String usuario = "";
    private String contraseña = "";
    private String url = "";
    private String draiver = "";
    private static Conexion instancia;
   

    public static Conexion getInstance() {
        if (instancia == null) {
            instancia = new Conexion();
        }

        return instancia;
    }

    public void setDraiver(String draiver) {
        this.draiver = draiver;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConexion(Connection conexion) {
        this.connection = conexion;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getUrl() {
        return url;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void conectar() throws Exception {
        Class.forName(draiver).newInstance();
        connection = DriverManager.getConnection(url, usuario, contraseña);
    }

}