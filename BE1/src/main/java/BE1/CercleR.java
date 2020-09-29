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
    private Ellipse2D oval = new Ellipse2D.Double(0,0, 50, 50);
    // le constructeur par dÃ©faut appel celui de la classe mÃ¨re
    // Ici rien Ã  faire de plus. Donc pas de constructeur (explicit)

    public CercleR(String couleur) {
      if (couleur=="rouge"){
        color = Color.RED;
      }
      else {
        color = Color.BLACK;
      }
      this.dispo = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(color);
        g2d.fill(oval);
        addMouseListener(this);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
//        if (oval.contains(e.getX(), e.getY()) ) {
//        System.out.println(e.getX());
//        }
        
        //rendre le cercle indisponible
        if (this.dispo=true){
            this.color=Color.PINK;//pas moyen de mettre a jour la couleur du cercle
            this.dispo = false;
            
        }
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            System.out.println("Pressed");
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
