/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE1;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ili�s
 */
public class Affichage extends JFrame{
     public Affichage(){
        setTitle("Jeu Araign�e");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);

        JPanel p = (JPanel) getContentPane();
        JLabel text = new JLabel("Jeu de l'araignee");
        p.add("North", text);
        pack();
    }

}
