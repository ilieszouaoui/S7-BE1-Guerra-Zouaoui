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

    private String type;        // selectionne le type d'action qu'on va effectuer
    private Affichage fenetre;  // l'affichage dans lequel se trouve le menu

    // constructeur
    TraitementMenu(String att,Affichage fen) {
        type=att;
        fenetre=fen;
    }

    // methode actionPerformed qui permet d'agir
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(type) {
            // si on a clique sur l'item "Regles du jeu", on affiche une popup avec les regles du jeu
            case "regles": JOptionPane.showMessageDialog(fenetre, "But du jeu : aligner trois pions sur le plateau.\nRègles du jeu :\n1) Chacun votre tour, positionnez vos pions sur le plateau.\n2) Lorsque tous les pions ont été placés sur le plateau, à votre tour vous pouvez déplacer un de vos pions sur une des cases adjacentes vides.");
                break;
            // si on a clique sur l'item "quitter", on ferme la fenetre
            case "quit": fenetre.dispatchEvent(new WindowEvent(fenetre, WindowEvent.WINDOW_CLOSING));
                break;
        }
    }
}
