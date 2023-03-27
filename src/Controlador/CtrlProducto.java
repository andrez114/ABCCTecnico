package Controlador;

import Reporte.ExcelRep;
import Modelo.ConsultasProducto;
import Modelo.Producto;
import Modelo.Departamento;
import Modelo.Clase;
import Modelo.Familia;
import Vista.frmProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class CtrlProducto implements ActionListener {

    private final Producto modelo;
    private final Departamento departamento;
    private final Clase clase;
    private final Familia familia;
    private final ExcelRep reporte;
    private final ConsultasProducto consultas;
    private final frmProducto vista;

    public CtrlProducto(Producto modelo, ConsultasProducto consultas, frmProducto vista, Departamento departamento,
    Clase clase, Familia familia, ExcelRep reporte) {
        this.reporte = reporte;
        this.modelo = modelo;
        this.departamento = departamento;
        this.clase = clase;
        this.familia = familia;
        this.consultas = consultas;
        this.vista = vista;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnReporte.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Productos");
        vista.setLocationRelativeTo(null);
        vista.txtId.setVisible(false);
        
    }
    
    public static String fechaActual(){
    Date fecha = new Date();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-YYYY");
            return formatoFecha.format(fecha);
    }
    
   

    @Override
    public void actionPerformed(ActionEvent e) {
        

        if (e.getSource() == vista.btnGuardar) {
              
          if(vista.txtSku.getText().isEmpty()||vista.txtArticulo.getText().isEmpty()|| vista.txtMarca.getText().isEmpty()||vista.txtModelo.getText().isEmpty()){
              
              JOptionPane.showMessageDialog(null, "Favor de rellenar todos los campos");
          
          }else{
              
              
          if(Integer.parseInt(vista.txtCantidad.getText())>Integer.parseInt(vista.txtStock.getText())){
              
              JOptionPane.showMessageDialog(null, "la cantidad debe ser menor al stock");
              
          }else{
          modelo.setSku(vista.txtSku.getText());
            modelo.setArticulo(vista.txtArticulo.getText());
            modelo.setMarca(vista.txtMarca.getText());
            modelo.setModelo(vista.txtModelo.getText());
            modelo.setStock(Integer.parseInt(vista.txtStock.getText()));
            modelo.setCantidad(Integer.parseInt(vista.txtCantidad.getText()));
            modelo.setFechaAlta(fechaActual());
            if(vista.chkDescontinuado.isSelected()){
                modelo.setFechaBaja(fechaActual());
                modelo.setDescontinuado(1);
            }else{
            modelo.setFechaBaja("1900-01-01");
            modelo.setDescontinuado(0);
            }
            departamento.setId(vista.cbxDepartamento.getSelectedIndex());
            clase.setId(vista.cbxClase.getSelectedIndex());
            familia.setId(vista.cbxFamilia.getSelectedIndex());
            

            if (consultas.registrar(modelo,departamento,clase, familia)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
                }
              
            }
          }
        }
         if (e.getSource() == vista.btnReporte) {
         reporte.reporte();
         JOptionPane.showMessageDialog(null, "reporte generado");
         
         }

        if (e.getSource() == vista.btnModificar) {
            
            if(vista.txtSku.getText().isEmpty()||vista.txtArticulo.getText().isEmpty()|| vista.txtMarca.getText().isEmpty()||vista.txtModelo.getText().isEmpty()){
              
              JOptionPane.showMessageDialog(null, "Favor de rellenar todos los campos");
          
          }else{
              
              
          if(Integer.parseInt(vista.txtCantidad.getText())>Integer.parseInt(vista.txtStock.getText())){
              
              JOptionPane.showMessageDialog(null, "la cantidad debe ser menor al stock");
              
          }else{
            
            modelo.setId(Integer.parseInt(vista.txtId.getText()));
            modelo.setSku(vista.txtSku.getText());
            modelo.setArticulo(vista.txtArticulo.getText());
            modelo.setMarca(vista.txtMarca.getText());
            modelo.setModelo(vista.txtModelo.getText());
            modelo.setStock(Integer.parseInt(vista.txtStock.getText()));
            modelo.setCantidad(Integer.parseInt(vista.txtCantidad.getText()));
            departamento.setId(vista.cbxDepartamento.getSelectedIndex());
            if(vista.chkDescontinuado.isSelected()){
                modelo.setFechaBaja(fechaActual());
                modelo.setDescontinuado(1);
            }else{
            modelo.setFechaBaja("1900-01-01");
            modelo.setDescontinuado(0);
            }
            clase.setId(vista.cbxClase.getSelectedIndex());
            familia.setId(vista.cbxFamilia.getSelectedIndex());

            if (consultas.modificar(modelo,departamento, clase, familia)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
            }
        }

        if (e.getSource() == vista.btnEliminar) {
            modelo.setId(Integer.parseInt(vista.txtId.getText()));

            if (consultas.eliminar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnBuscar) {
            modelo.setSku(vista.txtSku.getText());

            if (consultas.buscar(modelo,departamento, clase, familia)) {
                vista.txtId.setText(String.valueOf(modelo.getId()));
                vista.txtSku.setText(modelo.getSku());
                vista.txtArticulo.setText(modelo.getArticulo());
                vista.txtMarca.setText(modelo.getMarca());
                vista.txtModelo.setText(modelo.getModelo());
                vista.txtStock.setText(String.valueOf(modelo.getStock()));
                vista.txtCantidad.setText(String.valueOf(modelo.getCantidad()));
                vista.txtFechaAlta.setText(modelo.getFechaAlta());
                vista.txtFechaBaja.setText(modelo.getFechaBaja());
                vista.cbxDepartamento.setSelectedIndex(departamento.getId());
                vista.cbxClase.setSelectedIndex(clase.getId());
                vista.cbxFamilia.setSelectedIndex(familia.getId());


            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }

        
    }

    public void limpiar() {
        vista.txtId.setText(null);
        vista.txtSku.setText(null);
        vista.txtArticulo.setText(null);
        vista.txtMarca.setText(null);
        vista.txtModelo.setText(null);
        vista.txtStock.setText(null);
        vista.txtCantidad.setText(null);
        vista.txtFechaAlta.setText(null);
        vista.txtFechaBaja.setText(null);
        vista.cbxDepartamento.setSelectedIndex(0);
        vista.chkDescontinuado.setSelected(false);
    }
}
