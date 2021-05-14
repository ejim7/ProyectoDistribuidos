/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin Ibarra
 */
public class Cliente extends Observable implements Runnable {

    private int puerto;

    public Cliente(int puerto) {
        this.puerto = puerto;
    }

    @Override
    public void run() {
            //Host del servidor
            //Cambiar la ip de ser posible/necesario
        final String HOST = "192.168.1.69";

        DataInputStream dis;
        try {
            //Creo el socket para conectarme con el cliente
            Socket sc = new Socket(HOST, puerto);
            dis = new DataInputStream(sc.getInputStream());
            String nombre;
            String valor;
            while (true) {

                nombre = dis.readUTF();
                
                this.setChanged();
                this.notifyObservers(nombre);
                this.clearChanged();
                
                valor = dis.readUTF();

                this.setChanged();
                this.notifyObservers(valor);
                this.clearChanged();
                
            }

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
