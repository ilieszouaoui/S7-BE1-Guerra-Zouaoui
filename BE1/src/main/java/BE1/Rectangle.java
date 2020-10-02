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
public class Rectangle extends JComponent implements MouseListener{

    private boolean remplissage;    // vaut true si la case contient un pion, false sinon
    private Affichage aff;          // l'affichage dans lequel est affiche le rectangle
    private Color couleur;          // la couleur du rectangle
    private static int compteur=0;  // compteur qui compte le nombre de pions poses sur le plateau

    // constructeur
    public Rectangle(Affichage p) {
        aff = p;
        remplissage = false;
        couleur = Color.WHITE;
    }


    // methode paintComponent qui affiche le rectangle
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double rect = new Rectangle2D.Double(0,0,80,80);
        // on remplit le rectangle
        g2d.setPaint(couleur);
        g2d.fill(rect);
        // puis on fait un contour noir autour
        g2d.setPaint(Color.BLACK);
        g2d.draw(rect);
        addMouseListener(this);
    }

    // getter pour la couleur du rectangle (attribut couleur)
    public Color getCouleur(){
        return couleur;
    }

    // methode mouseClicked
    // agit lors du clic sur le cercle
    @Override
    public void mouseClicked(MouseEvent e) {
        int j=aff.getJoueurCourant();// On recupere l'information du joueur actif
        // PHASE 1
        if (remplissage==false && aff.getPionDansLaMain()==true) {// On verifie que la
                                    //case est vide et qu'on a bien selectionner un pion
            if (j==1) {//Si c'est le joueur 1
                couleur=Color.RED;// On selectionne la bonne couleur et on passe au joueur suivant
                aff.setJoueurCourant(2);
            }
            else {// de meme pour le joueur 2
                couleur=Color.BLACK;
                aff.setJoueurCourant(1);
            }

        this.remplissage=true;
        this.repaint();// On met a jour la case
        compteur+=1;
        aff.pionDansLaMain(false);// On depose le pion
        aff.Victoire();// on verifie si un joueur a gagne
        }


        /// PHASE 2
        else if (remplissage==true && aff.getPionDansLaMain()==false && compteur>5) {
            couleur=Color.WHITE;
            this.remplissage=false;
            aff.pionDansLaMain(true);
            this.repaint();
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
