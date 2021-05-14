/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author usuario
 */
public class imgPanel extends JPanel {

    BufferedImage bimg;
    private Graphics2D grp2;
    private ArrayList<Ellipse2D> lista;
    Ellipse2D.Double ellipse;
    boolean color = false;

    @Override
    protected void paintComponent(Graphics grphcs) {
        try {
            super.paintComponent(grphcs);
            BufferedImage bimg = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\imgs\\minaimg.jpg"));
            Graphics2D g2 = bimg.createGraphics();
            grp2 = (Graphics2D) grphcs;

            grp2.drawImage(bimg, 0, 0, 350, 460, null);
            
            if (color) {
                grp2.setPaint(Color.RED);
                color =false;
            } else{
               grp2.setPaint(Color.GREEN); 
               color = true;
            }
            
            ellipse = new Ellipse2D.Double(150, 300, 40, 40);
            grp2.fill(ellipse);
            grp2.setStroke(new BasicStroke(2.0f));
            grp2.draw(ellipse);
            
            grp2.dispose();

        } catch (IOException ex) {
            Logger.getLogger(imgPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
