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
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import resturantmanagement.Employee;
import resturantmanagement.Notification;
import resturantmanagement.Order;
import resturantmanagement.customers;

/**
 *
 * @author eslam
 */
public class report_panal_C extends JPanel{
    public report_panal_C()
    {
        setBackground(Color.ORANGE);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    
    public void get_reports()
    {
        customers c = new customers();
        Order o = new Order();
        ArrayList<customers> cc = new ArrayList<customers>();
        cc =(ArrayList<customers>)(Object) c.list();
        
        int sizecc = cc.size();
        int sizeoo;
        for(int i = 0; i < sizecc; i++)
        {
            this.add(new JLabel(" customer name: "+cc.get(i).getFname() + " " + cc.get(i).getLname()));
            this.add(new JLabel("     all payment: " + o.allPayments(cc.get(i).getId())));
            this.add(new JLabel("   _______________________"));
        }
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setForeground(Color.BLUE);
        g.drawRect(0, 0, 199, 199);
    }
}
