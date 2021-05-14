/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import DAOS.Control;
import DAOS.DAOException;
import dominio.Reporte;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin Ibarra
 */
public class Servidor implements Runnable {

    private ArrayList<Socket> clientes;
    private Control c;

    private int puerto;

    public Servidor(int puerto) {
        this.puerto = puerto;
        this.clientes = new ArrayList();
        c = new Control();
    }

    @Override
    public void run() {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;

        try {
            //Creamos el socket del servidor
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");

            //Siempre estara escuchando peticiones
            while (true) {

                //Espero a que un cliente se conecte
                sc = servidor.accept();

                System.out.println("Cliente conectado");

                clientes.add(sc);

            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarInfo(String[] nombres, String[] valores) {

        for (Socket sock : clientes) {

            try {
                DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
                for (int i = 0; i < nombres.length; i++) {
                    dos.writeUTF(nombres[i]);
                    dos.writeUTF(valores[i]);
                }
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void agregarReporte() {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            Reporte reporte = new Reporte(dtf.format(now), clientes.size());

            c.agregarReporte(reporte);
        } catch (DAOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
