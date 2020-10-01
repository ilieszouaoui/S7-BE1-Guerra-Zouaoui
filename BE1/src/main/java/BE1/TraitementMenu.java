/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE1;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author User
 */
public class TraitementMenu implements ActionListener {
    private int type;
    private Affichage fenetre;

    TraitementMenu(int i,Affichage fen) {
        type=i;
        fenetre=fen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(type) {
            //case 1: fenetre.remove(fenetre);

            //    break;
            case 2: JOptionPane.showMessageDialog(fenetre, "But du jeu : aligner trois pions sur le plateau.\nRegles du jeu :\n1) Chacun votre tour, positionnez vos pions sur le plateau.\n2) Lorsque tous les pions ont ete places sur le plateau, a  votre tour vous pouvez deplacer un de vos pions sur une des cases adjacentes vides.");
                break;
            case 3: fenetre.dispatchEvent(new WindowEvent(fenetre, WindowEvent.WINDOW_CLOSING));
                break;
        }
    }
}
