/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladoresSQL;

import Model.Zapato;
import configuration.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luisa
 */
public class Sql {

    Conexion conexion = Conexion.getInstance();

    public void guardarSneaker(Zapato u) throws SQLException {

        PreparedStatement setencia = null;
        try {
            setencia = conexion.getConnection().prepareStatement("insert into zapatos (codigo, marca, talla, modelo, color, cantidad, precio) values(?,?,?,?,?,?,?)");
            setencia.setString(1, u.getCodigo());
            setencia.setString(2, u.getMarca());
            setencia.setString(3, u.getTalla());
            setencia.setString(4, u.getModelo());
            setencia.setString(5, u.getColor());
            setencia.setInt(6, u.getCantidad());
            setencia.setInt(7, u.getPrecio());
            setencia.execute();
        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al momento de registrar los datos \n" + e.getMessage());
        }

    }

    public ArrayList<Zapato> obtenerSneakers() throws SQLException {

        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        ArrayList<Zapato> sneakers = new ArrayList<Zapato>();

        try {
            sentencia = conexion.getConnection().prepareStatement("select codigo, marca, talla, modelo, color, cantidad, precio from zapatos");
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                sneakers.add(
                        new Zapato(
                                resultado.getString(1),
                                resultado.getString(2),
                                resultado.getString(3),
                                resultado.getString(4),
                                resultado.getString(5),
                                resultado.getInt(6),
                                resultado.getInt(7))
                );
            }
        } catch (SQLException e) {
            throw new SQLException("Ocurrio un error al momento de registrar los datos \n" + e.getMessage());
        }

        return sneakers;

    }

    public void eliminarSneaker(String codigo) throws SQLException {
        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.getConnection().prepareStatement("DELETE FROM zapatos WHERE codigo = ?");
            sentencia.setString(1, codigo);
            sentencia.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Ocurrió un error al intentar eliminar el sneaker \n" + e.getMessage());
        }
    }

    public Zapato buscarSneakerPorCodigo(String codigo) throws SQLException {
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        Zapato sneaker = null;
        try {
            sentencia = conexion.getConnection().prepareStatement("SELECT * FROM zapatos WHERE codigo = ?");
            sentencia.setString(1, codigo);
            resultado = sentencia.executeQuery();
            if (resultado.next()) {
                sneaker = new Zapato(
                        resultado.getString("codigo"),
                        resultado.getString("marca"),
                        resultado.getString("talla"),
                        resultado.getString("modelo"),
                        resultado.getString("color"),
                        resultado.getInt("cantidad"),
                        resultado.getInt("precio")
                );
            }
        } catch (SQLException e) {
            throw new SQLException("Ocurrió un error al intentar buscar el sneaker \n" + e.getMessage());
        }
        return sneaker;
    }

    public void actualizarSneaker(Zapato zapato) throws SQLException {
        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.getConnection().prepareStatement("UPDATE zapatos SET marca=?, talla=?, modelo=?, color=?, cantidad=?, precio=? WHERE codigo=?");
            sentencia.setString(1, zapato.getMarca());
            sentencia.setString(2, zapato.getTalla());
            sentencia.setString(3, zapato.getModelo());
            sentencia.setString(4, zapato.getColor());
            sentencia.setInt(5, zapato.getCantidad());
            sentencia.setInt(6, zapato.getPrecio());
            sentencia.setString(7, zapato.getCodigo());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Ocurrió un error al intentar actualizar el sneaker \n" + e.getMessage());
        }
    }

}
