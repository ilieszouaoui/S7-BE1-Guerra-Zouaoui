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
    private JPanel p1,p2,p3,p4;     // JPanels qui creent l'interface
    private int joueur_courant;     // vaut 1 ou 2 : designe le joueur courant (celui qui doit jouer)
    private boolean pion;           // vaut true si le pion est dans la main du joueur, false sinon
    private JLabel l1;              // JLabel qui sera modifie au cours du jeu
    private Rectangle[] rect_grille = new Rectangle[9]; // grille correspondant au plateau de jeu, utilisee dans victoire()

    // constructeur
    public Affichage(){

        // initilisation du JFrame
        setTitle("Jeu de l'araignee");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(370,350));
        setLocationRelativeTo(null);


        // création du menu
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Jeu");
        JMenuItem regles = new JMenuItem("Regles du jeu");
        menu.add(regles);
        JMenuItem quit = new JMenuItem("Quitter");
        menu.add(quit);
        menubar.add(menu);
        setJMenuBar(menubar);

        // ajout des ActionListener sur les elements du menu
        regles.addActionListener(new TraitementMenu("regles",this));
        quit.addActionListener(new TraitementMenu("quit",this));


        // creation du JPanel p1
        // il contient le JLabel indiquant le joueur qui doit agir
        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        // le JLabel est un attribut de la classe car il sera modifie au fur et a mesure du jeu
        l1=new JLabel("Joueur 1, c'est à vous.");
        p1.add(l1);


        // creation du JPanel p2
        // il contient le JLabel "J1" et les trois pions rouges du joueur 1
        p2 = new JPanel();
        p2.setPreferredSize(new Dimension(50,200));
        p2.setLayout(new BoxLayout(p2,BoxLayout.PAGE_AXIS));
        p2.add(new JLabel("J1"));
        // pions crees avec la classe CercleR
        p2.add(new CercleR(Color.RED,this));
        p2.add(new CercleR(Color.RED,this));
        p2.add(new CercleR(Color.RED,this));


        // creation du JPanel p3
        // il contient le JLabel "J2" et les trois pions noirs du joueur 2
        p3 = new JPanel();
        p3.setPreferredSize(new Dimension(50,200));
        p3.setLayout(new BoxLayout(p3,BoxLayout.PAGE_AXIS));
        p3.add(new JLabel("J2"));

        // pions crees avec la classe CercleR
        p3.add(new CercleR(Color.BLACK,this));
        p3.add(new CercleR(Color.BLACK,this));
        p3.add(new CercleR(Color.BLACK,this));


        // creation du JPanel p4
        // il contient 9 carres qui forment le plateau de jeu
        p4 = new JPanel();
        p4.setPreferredSize(new Dimension(260,300));
        p4.setLayout(new GridLayout(3,3));

        // carres crees avec la classe Rectangle
        for (int k=0;k<9;k++) {
            p4.add(rect_grille[k] = new Rectangle(this));
        }


        // ajout et positionnement des 4 JPanel dans le JFrame
        setLayout(new BorderLayout());
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.WEST);
        add(p3,BorderLayout.EAST);
        add(p4,BorderLayout.CENTER);


        // initialisation du jeu
        // on debute par le joueur 1
        setJoueurCourant(1);

        pack();

    }



    // getter pour l'attribut pion
    public boolean getPionDansLaMain() {
        return pion;
    }

    // setter pour l'attribut pion
    public void pionDansLaMain(boolean jeton) {
        pion=jeton;
    }




    // getter pour l'attribut joueur_courant
    public int getJoueurCourant() {
        return joueur_courant;
    }

    // setter pour l'attribut joueur_courant
    public void setJoueurCourant(int j) {
        joueur_courant=j;
        if (j==1) {
            l1.setText("Joueur 1, c'est a vous.");
        }
        if (j==2) {
            l1.setText("Joueur 2, c'est a vous.");
        }
    }




    // methode qui agit lors de la victoire d'un des deux joueurs
    public void Victoire(){

        if (rect_grille[0].getCouleur()==rect_grille[1].getCouleur() && rect_grille[1].getCouleur()==rect_grille[2].getCouleur() && rect_grille[0].getCouleur()==Color.RED ||
            rect_grille[3].getCouleur()==rect_grille[4].getCouleur() && rect_grille[4].getCouleur()==rect_grille[5].getCouleur() && rect_grille[3].getCouleur()==Color.RED||
            rect_grille[6].getCouleur()==rect_grille[7].getCouleur() && rect_grille[7].getCouleur()==rect_grille[8].getCouleur() && rect_grille[6].getCouleur()==Color.RED||
            rect_grille[0].getCouleur()==rect_grille[3].getCouleur() && rect_grille[3].getCouleur()==rect_grille[6].getCouleur() && rect_grille[0].getCouleur()==Color.RED||
            rect_grille[1].getCouleur()==rect_grille[4].getCouleur() && rect_grille[4].getCouleur()==rect_grille[7].getCouleur() && rect_grille[1].getCouleur()==Color.RED||
            rect_grille[2].getCouleur()==rect_grille[5].getCouleur() && rect_grille[5].getCouleur()==rect_grille[8].getCouleur() && rect_grille[2].getCouleur()==Color.RED||
            rect_grille[0].getCouleur()==rect_grille[4].getCouleur() && rect_grille[4].getCouleur()==rect_grille[8].getCouleur() && rect_grille[0].getCouleur()==Color.RED||
            rect_grille[2].getCouleur()==rect_grille[4].getCouleur() && rect_grille[4].getCouleur()==rect_grille[6].getCouleur() && rect_grille[2].getCouleur()==Color.RED){
            l1.setText("FELICITATIONS JOUEUR 1 ! VICTOIRE !");
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
            l1.setText("FELICITATIONS JOUEUR 2 ! VICTOIRE !");
            JOptionPane.showMessageDialog(this,"Bravo, le joueur 2 a gagne !");
        }
    }


}
