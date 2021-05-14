/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import dominio.Reporte;

/**
 *
 * @author usuario
 */
public class Reportes extends Tabla {
    
    public Reportes(String nomTabla) {
        super(nomTabla);
    }
    
    public void agregar(Reporte r) throws DAOException{
        String sql = "";
       sql = sql + "INSERT " + this.nomTabla;
       sql = sql + " SET tiempo = '" + r.getTiempo() + "'";
       sql = sql + ", cantidadusr = '" + r.getCantidad() + "';";
       actualiza(sql);
    }
    
}
