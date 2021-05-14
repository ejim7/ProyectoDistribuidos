/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author usuario
 */
public class Tabla {
    
    protected String nomTabla;
    private Connection conexion;
    private Statement sentencia;
    private ResultSet respuesta;

    public Tabla(String nomTabla) {
        this.nomTabla = nomTabla;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public void consulta(String sql)
            throws DAOException {
        try {
            this.sentencia = this.conexion.createStatement();

            this.respuesta = this.sentencia.executeQuery(sql);
        } catch (SQLException se) {
            throw new DAOException("No se puede consultar a la base de datos", se);
        }
    }

    public ResultSet obtenRenglon()
            throws DAOException {
        try {
            if (this.respuesta.next()) {
                return this.respuesta;
            }
            this.respuesta.close();
            this.sentencia.close();
            return null;
        } catch (SQLException se) {
            throw new DAOException("No se puede consultar a la base de datos", se);
        }
    }

    public void actualiza(String sql)
            throws DAOException {
        try {
            this.sentencia = this.conexion.createStatement();

            int i = this.sentencia.executeUpdate(sql);

            this.sentencia.close();
        } catch (SQLException se) {
            throw new DAOException("No se puede actualizar a la base de datos", se);
        }
    }
}
