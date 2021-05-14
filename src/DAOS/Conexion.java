/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author usuario
 */
public class Conexion {
      private Connection conexion;
  
  public Conexion(String url, String usuario, String password)
    throws DAOException
  {
    try
    {
      Class.forName("org.gjt.mm.mysql.Driver").newInstance();
      
      this.conexion = DriverManager.getConnection(url, usuario, password);
    }
    catch (Exception e)
    {
      throw new DAOException("Error al conectarse a la base de datos", e);
    }
  }
  
  public Connection getConexion()
  {
    return this.conexion;
  }
  
  public void close()
    throws DAOException
  {
    try
    {
      this.conexion.close();
    }
    catch (Exception e)
    {
      throw new DAOException("Error al cerrar la conexion con la base de datos", e);
    }
  }
    
}
