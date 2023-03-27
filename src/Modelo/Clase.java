package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Clase {

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

    public Vector<Clase> mostrarClase(int idDepartamento) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        Vector<Clase> datos = new Vector<Clase>();
        Clase dat = null;
        try {

            String sql = "SELECT * FROM t_clase WHERE id_departamento=" + idDepartamento;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Clase();
            dat.setId(0);
            dat.setNombre("Seleccionar Clase");
            datos.add(dat);

            while (rs.next()) {
                dat = new Clase();
                dat.setId(rs.getInt("id_clase"));
                dat.setNombre(rs.getString("clase"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
}
