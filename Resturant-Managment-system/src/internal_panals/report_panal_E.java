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

/**
 *
 * @author eslam
 */
public class report_panal_E extends JPanel{
    public report_panal_E()
    {
        setBackground(Color.ORANGE);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    
    public void get_reports()
    {
        Employee e = new Employee();
        Order o = new Order();
        ArrayList<Employee> ee = new ArrayList<Employee>();
        ArrayList<Order> oo = new ArrayList<Order>();
        ee =(ArrayList<Employee>)(Object) e.list();
        
        int sizeee = ee.size();
        int sizeoo;
        for(int i = 0; i < sizeee; i++)
        {
            this.add(new JLabel(" employee name: "+ee.get(i).getFName()));
            oo.clear();
            oo = (ArrayList<Order>)(Object) o.report(ee.get(i).getId());
            sizeoo = oo.size();
            for(int j = 0; j < sizeoo; j++)
            {
                this.add(new JLabel("   order number: " + (j+1)+", price " + oo.get(j).getPrice()));
            }
            this.add(new JLabel("   _______________________"));
        }
        
        
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setForeground(Color.BLUE);
        g.drawRect(0, 0, 199, 199);
    }
}
