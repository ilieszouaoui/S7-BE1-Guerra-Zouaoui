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

    public CercleR(Color couleur, Affichage p) {
      // System.out.println("on cree le cercle");
      aff = p;
      color = couleur;
      dispo = true;
      oval = new Ellipse2D.Double(0,0, 50,50);
      this.repaint();
    }



    @Override
    public void paintComponent(Graphics g) {

        // System.out.println("ça rentre dans le paintcomponent");
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(color);
        g2d.fill(oval);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        //rendre le cercle indisponible
        if (dispo==true){
            //System.out.println("Joueur courant = "+aff.getJoueurCourant());

            if(aff.getJoueurCourant()==1 && this.color==Color.RED){
                color=Color.GRAY;
            }

            if(aff.getJoueurCourant()==2 && this.color==Color.BLACK){
                color=Color.GRAY;
            }

            aff.pionDansLaMain(true);
            this.repaint();
            this.dispo = false;
        }


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
