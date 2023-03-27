package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Familia {

    int id;
    String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public Vector<Familia> mostrarFamilia(int idClase) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        Vector<Familia> datos = new Vector<Familia>();
        Familia dat = null;

        try {

            String sql = "SELECT * FROM t_familia WHERE id_clase=" + idClase;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Familia();
            dat.setId(0);
            dat.setNombre("Seleccionar Familia");
            datos.add(dat);

            while (rs.next()) {
                dat = new Familia();
                dat.setId(rs.getInt("id_familia"));
                dat.setNombre(rs.getString("familia"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
}
