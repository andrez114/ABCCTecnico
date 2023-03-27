package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Departamento {

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

    public Vector<Departamento> mostrarDepartamento() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        Vector<Departamento> datos = new Vector<Departamento>();
        Departamento dat = null;
        try {

            String sql = "SELECT * FROM t_departamento";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Departamento();
            dat.setId(0);
            dat.setNombre("Selecciona Departamento");
            datos.add(dat);

            while (rs.next()) {
                dat = new Departamento();
                dat.setId(rs.getInt("id_departamento"));
                dat.setNombre(rs.getString("departamento"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
}
