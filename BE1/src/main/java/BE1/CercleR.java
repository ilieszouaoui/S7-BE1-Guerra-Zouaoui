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

/**
 *
 * @author User
 */
public class CercleR extends JComponent implements MouseListener{

    private Color color;
    private boolean dispo;
    private Ellipse2D oval;
    // le constructeur par dÃ©faut appel celui de la classe mÃ¨re
    // Ici rien Ã  faire de plus. Donc pas de constructeur (explicit)
    private Affichage aff;
    private double x,y;

    public CercleR(double x_user, double y_user,String couleur, Affichage p) {
      System.out.println("on cree le cercle");
      x=x_user;
      y=y_user;
      aff = p;
      if (couleur=="rouge"){
        color = Color.RED;
      }
      else {
        color = Color.BLACK;
      }
      dispo = true;
      oval = new Ellipse2D.Double(x,y, 50,50);
      this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {

        System.out.println("ça rentre dans le paintcomponent");
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(color);
        g2d.fill(oval);
        addMouseListener(this);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
//        if (oval.contains(e.getX(), e.getY()) ) {
//        System.out.println(e.getX());
//        }
        System.out.println("Clicked");
        //rendre le cercle indisponible
        if (dispo==true){
            aff.pionDansLaMain(true);
            if (color==Color.RED) {
                aff.setJoueurCourant(1);
            }
            else {
                aff.setJoueurCourant(2);
            }
            System.out.println(aff.getJoueurCourant());

            color=Color.GRAY;//pas moyen de mettre a jour la couleur du cercle
            this.repaint();
            //dispo = false;



        }


    }

    @Override
    public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            System.out.println("Pressed");
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
