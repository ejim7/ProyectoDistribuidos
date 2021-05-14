/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

/**
 *
 * @author usuario
 */
public class DAOException
        extends Exception {

    public DAOException() {
    }

    public DAOException(String msj) {
        super(msj);
    }

    public DAOException(String msj, Throwable causa) {
        super(msj, causa);
    }

    public DAOException(Throwable causa) {
        super(causa);
    }
}
