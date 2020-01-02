/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author eslam
 */
public class buttoncustom extends JButton {

    public buttoncustom() {
        custom();
    }

    public buttoncustom(String text) {
        super(text);
        custom();
        
    }
    private void custom()
    {
        setBackground(Color.orange);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(true);
        //setBorder(BorderFactory.create);
        
    }
//    protected void paintComponent(Graphics g) {
//      // if the button is pressed and ready to be released
//      if (getModel().isArmed()) {
//         g.setColor(Color.lightGray);
//      } else {
//         g.setColor(getBackground());
//      }
//  
//      g.fillOval(0, 0, getSize().width-1, getSize().height-1);
//  
//      super.paintComponent(g);
//   }
//    protected void paintBorder(Graphics g) {
//      g.setColor(getForeground());
//      g.drawOval(0, 0, getSize().width, getSize().height);
//   }
}
