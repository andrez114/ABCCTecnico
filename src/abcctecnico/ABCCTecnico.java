
package abcctecnico;

import Controlador.CtrlProducto;
import Modelo.ConsultasProducto;
import Modelo.Producto;
import Modelo.Departamento;
import Modelo.Clase;
import Modelo.Familia;
import Vista.frmProducto;
import Reporte.ExcelRep;
public class ABCCTecnico {

    
    public static void main(String[] args) {

        Producto mod = new Producto();
        ConsultasProducto modC = new ConsultasProducto();
        frmProducto frm = new frmProducto();
        Departamento dep = new Departamento();
        Clase cla = new Clase();
        Familia fam = new Familia();
        ExcelRep rep = new ExcelRep();

        CtrlProducto ctrl = new CtrlProducto(mod, modC, frm, dep, cla, fam, rep);
        ctrl.iniciar();
        frm.setVisible(true);
    }
    
}
