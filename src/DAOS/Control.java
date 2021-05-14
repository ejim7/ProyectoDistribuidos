/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import dominio.Reporte;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Control {

    private static final String url = "jdbc:mysql://localhost/mineria";
    private static final String user = "root";
    private static final String password = "sesamo";
    private Reportes reportes;

    public Control() {
        this.reportes = new Reportes("reportes");
    }

    public void agregarReporte(Reporte r) throws DAOException {
        Conexion conexion = null;
        try {
            conexion = new Conexion("jdbc:mysql://localhost/mineria", "root", "sesamo");
            Connection conn = conexion.getConexion();
            this.reportes.setConexion(conn);
            this.reportes.agregar(r);
        } catch (DAOException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (DAOException pe) {
                throw new DAOException("No se puede agregar el reporte", pe);
            }
        }

    }
}
