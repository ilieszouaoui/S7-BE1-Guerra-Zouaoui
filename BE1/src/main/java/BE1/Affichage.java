/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE1;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author ili?s
 */
public class Affichage extends JFrame{
    private JPanel p1,p2,p3,p4;
    private int joueur_courant;
    private boolean main;
    private JLabel l1;
    private Rectangle[] rect_grille = new Rectangle[9];

     public Affichage(){
        setTitle("Jeu de l'araignee");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(370,350));
        setLocationRelativeTo(null);
        joueur_courant = 1;

        // menu
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Jeu");
        //JMenuItem njeu = new JMenuItem("Nouveau jeu");
        //menu.add(njeu);
        JMenuItem regles = new JMenuItem("Regles du jeu");
        menu.add(regles);
        JMenuItem quit = new JMenuItem("Quitter");
        menu.add(quit);
        menubar.add(menu);
        setJMenuBar(menubar);
        //njeu.addActionListener(new TraitementMenu(1,this));
        regles.addActionListener(new TraitementMenu(2,this));
        quit.addActionListener(new TraitementMenu(3,this));

        // cr√©ation des JPanel
        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        l1=new JLabel("Joueur 1, c'est √† vous.");
        p1.add(l1);

        // jetons j1
        p2 = new JPanel();
        p2.setPreferredSize(new Dimension(50,200));
        p2.setLayout(new BoxLayout(p2,BoxLayout.PAGE_AXIS));
        p2.add(new JLabel("J1"));
        p2.add(new CercleR(Color.RED,this));
        p2.add(new CercleR(Color.RED,this));
        p2.add(new CercleR(Color.RED,this));

        // jetons j2
        p3 = new JPanel();
        p3.setPreferredSize(new Dimension(50,200));
        p3.setLayout(new BoxLayout(p3,BoxLayout.PAGE_AXIS));
        p3.add(new JLabel("J2"));
        p3.add(new CercleR(Color.BLACK,this));
        p3.add(new CercleR(Color.BLACK,this));
        p3.add(new CercleR(Color.BLACK,this));

        // jeu
        p4 = new JPanel();
        p4.setPreferredSize(new Dimension(260,300));
        p4.setLayout(new GridLayout(3,3));


        for (int k=0;k<9;k++) {
            p4.add(rect_grille[k] = new Rectangle(this));
        }

        setLayout(new BorderLayout());
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.WEST);
        add(p3,BorderLayout.EAST);
        add(p4,BorderLayout.CENTER);
        setJoueurCourant(1);// Initialisation du jeu en debutant par le joueur 1
        pack();

    }
    public int getJoueurCourant() {
        return joueur_courant;
    }

    public boolean getPionDansLaMain() {
        return main;
    }

    public void setJoueurCourant(int j) {
        joueur_courant=j;
        if (main) {
            l1.setText("Posez votre pion.");
        }
        if (j==1) {
            l1.setText("Joueur 1, c'est a† vous.");
        }
        if (j==2) {
            l1.setText("Joueur 2, c'est a† vous.");
        }

    }

    public void pionDansLaMain(boolean pion) {
        main = pion;
        //System.out.println("Pion dans la main = "+main);
        }

    public void Victoire(){

        if (rect_grille[0].getCouleur()==rect_grille[1].getCouleur() && rect_grille[1].getCouleur()==rect_grille[2].getCouleur() && rect_grille[0].getCouleur()==Color.RED ||
            rect_grille[3].getCouleur()==rect_grille[4].getCouleur() && rect_grille[4].getCouleur()==rect_grille[5].getCouleur() && rect_grille[3].getCouleur()==Color.RED||
            rect_grille[6].getCouleur()==rect_grille[7].getCouleur() && rect_grille[7].getCouleur()==rect_grille[8].getCouleur() && rect_grille[6].getCouleur()==Color.RED||
            rect_grille[0].getCouleur()==rect_grille[3].getCouleur() && rect_grille[3].getCouleur()==rect_grille[6].getCouleur() && rect_grille[0].getCouleur()==Color.RED||
            rect_grille[1].getCouleur()==rect_grille[4].getCouleur() && rect_grille[4].getCouleur()==rect_grille[7].getCouleur() && rect_grille[1].getCouleur()==Color.RED||
            rect_grille[2].getCouleur()==rect_grille[5].getCouleur() && rect_grille[5].getCouleur()==rect_grille[8].getCouleur() && rect_grille[2].getCouleur()==Color.RED||
            rect_grille[0].getCouleur()==rect_grille[4].getCouleur() && rect_grille[4].getCouleur()==rect_grille[8].getCouleur() && rect_grille[0].getCouleur()==Color.RED||
            rect_grille[2].getCouleur()==rect_grille[4].getCouleur() && rect_grille[4].getCouleur()==rect_grille[6].getCouleur() && rect_grille[2].getCouleur()==Color.RED){
            l1.setText("FELICITATION JOUEUR 1 ! VICOTIRE !");
            JOptionPane.showMessageDialog(this,"Bravo, le joueur 1 a gagne !");
        }

        if (rect_grille[0].getCouleur()==rect_grille[1].getCouleur() && rect_grille[1].getCouleur()==rect_grille[2].getCouleur() && rect_grille[0].getCouleur()==Color.BLACK ||
            rect_grille[3].getCouleur()==rect_grille[4].getCouleur() && rect_grille[4].getCouleur()==rect_grille[5].getCouleur() && rect_grille[3].getCouleur()==Color.BLACK||
            rect_grille[6].getCouleur()==rect_grille[7].getCouleur() && rect_grille[7].getCouleur()==rect_grille[8].getCouleur() && rect_grille[6].getCouleur()==Color.BLACK||
            rect_grille[0].getCouleur()==rect_grille[3].getCouleur() && rect_grille[3].getCouleur()==rect_grille[6].getCouleur() && rect_grille[0].getCouleur()==Color.BLACK||
            rect_grille[1].getCouleur()==rect_grille[4].getCouleur() && rect_grille[4].getCouleur()==rect_grille[7].getCouleur() && rect_grille[1].getCouleur()==Color.BLACK||
            rect_grille[2].getCouleur()==rect_grille[5].getCouleur() && rect_grille[5].getCouleur()==rect_grille[8].getCouleur() && rect_grille[2].getCouleur()==Color.BLACK||
            rect_grille[0].getCouleur()==rect_grille[4].getCouleur() && rect_grille[4].getCouleur()==rect_grille[8].getCouleur() && rect_grille[0].getCouleur()==Color.BLACK||
            rect_grille[2].getCouleur()==rect_grille[4].getCouleur() && rect_grille[4].getCouleur()==rect_grille[6].getCouleur() && rect_grille[2].getCouleur()==Color.BLACK){
            l1.setText("FELICITATION JOUEUR 2 ! VICOTIRE !");
            JOptionPane.showMessageDialog(this,"Bravo, le joueur 2 a gagne !");
        }
    }


}
