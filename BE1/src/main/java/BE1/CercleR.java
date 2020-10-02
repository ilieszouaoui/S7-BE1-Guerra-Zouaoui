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

    private Color color;    // couleur du pion
    private boolean dispo;  // vaut true si le pion n'a pas ete joue, false sinon
    private Ellipse2D oval; // objet Ellipse2D qui sera le cercle a creer
    private Affichage aff;  // l'affichage dans lequel est affiche le cercle

    // constructeur
    public CercleR(Color couleur, Affichage p) {
      aff = p;
      color = couleur;
      dispo = true;
      oval = new Ellipse2D.Double(0,0, 50,50);
    }


    // methode paintComponent qui affiche le cercle
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(color);
        g2d.fill(oval);
        addMouseListener(this);
    }


    // methode mouseClicked
    // agit lors du clic sur le cercle
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

        if (dispo==true){

            // on verifie que le joueur courant clique bien sur un de ses pions
            // le joueur 1 doit cliquer sur un pion rouge et le joueur 2 sur un pions noir
            // sinon on ne fait rien
            if(aff.getJoueurCourant()==1 && color==Color.RED){
                color=Color.GRAY;
            }
            if(aff.getJoueurCourant()==2 && color==Color.BLACK){
                color=Color.GRAY;
            }


            aff.pionDansLaMain(true); // le pion sur lequel il y a eu un clic passe dans la main du joueur
            this.repaint();           // on le peint en gris sur le cote du plateau
            this.dispo = false;       // il n'est donc plus disponible
        }


    }

    // les methodes suivantes ne sont pas utilisees ici
    // mais elles doivent etre ecrites pour que la classe implemente bien l'interface MouseListener

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
