/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE1;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

/**
 *
 * @author User
 */
public class CercleR extends JPanel {
    

    // le constructeur par dÃ©faut appel celui de la classe mÃ¨re
    // Ici rien Ã  faire de plus. Donc pas de constructeur (explicit)

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint clr = new GradientPaint(0,0,Color.RED,100, 0,Color.RED);
        g2d.setPaint(clr);
        g2d.fill (new Ellipse2D.Double(0,0, 50, 50));
    }


}
