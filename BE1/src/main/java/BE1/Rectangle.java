/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE1;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.List;
import java.awt.GraphicsEnvironment;

/**
 *
 * @author User
 */
public class Rectangle extends JPanel implements MouseListener{
    private boolean remplissage;
    private Affichage aff;
    private String couleur;
    private JPanel panel;

    public Rectangle(Affichage a,JPanel p) {
        aff = a;
        panel = p;
        remplissage = false;
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

        //if (remplissage==false) {
        int j=aff.getJoueurCourant();
        System.out.println(j);
        if (j==1) {
            couleur="rouge";
        }
        else {
            couleur="noir";
        }
        System.out.println(couleur);
        //CercleR c = new CercleR(e.getX(),e.getY(),couleur,aff);
        panel.add(new CercleR(e.getX(),e.getY(),couleur,aff));
        //c.repaint(e.getX(),e.getY(),50,50);
        //}
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
