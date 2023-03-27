package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConsultasProducto extends Conexion {

    public boolean registrar(Producto pro, Departamento dep, Clase cla, Familia fam) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO producto (sku, articulo, stock , cantidad, marca, modelo,fechaAlta, fechaBaja, descontinuado, departamento, clase, familia) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getSku());
            ps.setString(2, pro.getArticulo());
            ps.setInt(3, pro.getStock());
            ps.setInt(4, pro.getCantidad());
            ps.setString(5, pro.getMarca());
            ps.setString(6, pro.getModelo());
            ps.setString(7, pro.getFechaAlta());
            ps.setString(8, pro.getFechaBaja());
            ps.setInt(9, pro.getDescontinuado());
            ps.setInt(10, dep.getId());
            ps.setInt(11, cla.getId());
            ps.setInt(12, fam.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(Producto pro, Departamento dep, Clase cla, Familia fam) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE producto SET sku=?, articulo=?, stock=?, cantidad=?, marca=?, modelo=?, departamento=?, clase=?, familia=?,fechaBaja=?, descontinuado=? WHERE id=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getSku());
            ps.setString(2, pro.getArticulo());
            ps.setInt(3, pro.getStock());
            ps.setInt(4, pro.getCantidad());
            ps.setString(5, pro.getMarca());
            ps.setString(6, pro.getModelo());
            ps.setInt(7, dep.getId());
            ps.setInt(8, cla.getId());
            ps.setInt(9, fam.getId());
            ps.setString(10,pro.getFechaBaja());
            ps.setInt(11,pro.getDescontinuado());
            ps.setInt(12, pro.getId());
            
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(Producto pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM producto WHERE id=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean buscar(Producto pro, Departamento dep, Clase cla, Familia fam) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM producto WHERE sku=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getSku());
            rs = ps.executeQuery();

            if (rs.next()) {
                pro.setId(Integer.parseInt(rs.getString("id")));
                pro.setSku(rs.getString("sku"));
                pro.setArticulo(rs.getString("articulo"));
                pro.setMarca(rs.getString("marca"));
                pro.setModelo(rs.getString("modelo"));
                pro.setStock(Integer.parseInt(rs.getString("stock")));
                pro.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                pro.setFechaAlta(rs.getString("fechaAlta"));
                pro.setFechaBaja(rs.getString("fechaBaja"));
                dep.setId(Integer.parseInt(rs.getString("departamento")));
                cla.setId(Integer.parseInt(rs.getString("clase")));
                fam.setId(Integer.parseInt(rs.getString("familia")));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
