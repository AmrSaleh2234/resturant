/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal_panals;

import GUI.labelcustom;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.html.CSS;
import static javax.swing.text.html.CSS.Attribute.BORDER_RIGHT;
import resturantmanagement.Notification;

/**
 *
 * @author eslam
 */
public class notifications_panal extends JPanel{
    public notifications_panal()
    {
        setBackground(Color.ORANGE);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    
    public int get_notification()
    {
        Notification n = new Notification();
        ArrayList<Notification> nn = n.read();
        
        int size = nn.size();
        for(int i = 0; i < size; i++)
        {
            labelcustom l = new labelcustom("       " + nn.get(i).getNotification());
            l.setForeground(Color.WHITE);
            this.add(l);
            this.add(new JLabel("   _______________________"));
        }
        return size;
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setForeground(Color.BLUE);
        g.drawRect(0, 0, 199, 199);
    }
    
}
