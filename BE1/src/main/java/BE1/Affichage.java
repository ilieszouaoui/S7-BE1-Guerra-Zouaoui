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
 * @author ili�s
 */
public class Affichage extends JFrame{
    JPanel p1,p2,p3,p4;

     public Affichage(){
        setTitle("Jeu de l'araignée");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(500,500));
        setLocationRelativeTo(null);

        // menu
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Jeu");
        JMenuItem njeu = new JMenuItem("Nouveau jeu");
        menu.add(njeu);
        JMenuItem regles = new JMenuItem("Règles du jeu");
        menu.add(regles);
        JMenuItem quit = new JMenuItem("Quitter");
        menu.add(quit);
        menubar.add(menu);
        setJMenuBar(menubar);

        // création des JPanel
        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        JLabel l1 = new JLabel("Joueur 1, c'est à vous.");
        p1.add(l1);

        p2 = new JPanel();
        p2.setPreferredSize(new Dimension(50,200));
        p2.setLayout(new BoxLayout(p2,BoxLayout.PAGE_AXIS));
        p2.add(new JLabel("J1"));
        p2.add(new CercleR("rouge"));
        p2.add(new CercleR("rouge"));
        p2.add(new CercleR("rouge"));

        p3 = new JPanel();
        p2.setPreferredSize(new Dimension(50,200));
        p3.setLayout(new BoxLayout(p3,BoxLayout.PAGE_AXIS));
        p3.add(new JLabel("J2"));
        p3.add(new CercleR("noir"));
        p3.add(new CercleR("noir"));
        p3.add(new CercleR("noir"));



        //public void paint (Graphics g) {
        //    Graphics2D g2 = (Graphics2D) g;
        //}


        setLayout(new BorderLayout());
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.WEST);
        add(p3,BorderLayout.EAST);
        pack();
    }

}
