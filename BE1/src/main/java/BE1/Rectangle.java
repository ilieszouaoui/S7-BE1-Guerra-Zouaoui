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
    private Color couleur;
    private JPanel panel;
    private static int compteur=0;

    public Rectangle(Affichage a,JPanel p) {
        aff = a;
        panel = p;
        remplissage = false;
        couleur =Color.WHITE;
    }



    // le constructeur par dÃ©faut appel celui de la classe mÃ¨re
    // Ici rien Ã  faire de plus. Donc pas de constructeur (explicit)

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double rect = new Rectangle2D.Double(0,0,80,80);
        g2d.setPaint(couleur);
        g2d.fill(rect);
        g2d.setPaint(Color.BLACK);
        g2d.draw(rect);
        addMouseListener(this);
    }

    public Color getCouleur(){
        return this.couleur;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        int j=aff.getJoueurCourant();
        //System.out.println("c'est deja ca");



        // PHASE 1
        if (remplissage==false && aff.getPionDansLaMain()==true) {
            System.out.println("NON.");

            if (j==1) {
                couleur=Color.RED;
                aff.setJoueurCourant(2);
            }
            else {
                couleur=Color.BLACK;
                aff.setJoueurCourant(1);
            }

        this.remplissage=true;
        this.repaint();
        compteur+=1;
        //System.out.println("nombre de jetons joues : " + compteur);
        aff.pionDansLaMain(false);
        aff.Victoire();
        }


        /// PHASE 2
        else if (remplissage==true && aff.getPionDansLaMain()==false && compteur>5) {
            System.out.println("OUI.");
            couleur=Color.WHITE;
            this.remplissage=false;
            aff.pionDansLaMain(true);
            this.repaint();
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
