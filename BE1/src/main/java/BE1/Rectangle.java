/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE1;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

/**
 *
 * @author User
 */
public class Rectangle extends JPanel implements MouseListener{
    private boolean remplissage;

    public Rectangle() {
        this.remplissage = false;
    }

    

    // le constructeur par dÃ©faut appel celui de la classe mÃ¨re
    // Ici rien Ã  faire de plus. Donc pas de constructeur (explicit)

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double rect = new Rectangle2D.Double(0,0,80,80);
        g2d.setPaint(Color.WHITE);
        g2d.fill(rect);
        g2d.setPaint(Color.BLACK);
        g2d.draw(rect);
        addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            System.out.println("Coucou");
    }

    @Override
    public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
    }
}
