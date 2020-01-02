/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import internal_frames.edit_customers;
import internal_frames.edit_orders;
import internal_panals.notifications_panal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author eslam
 */
public class employeeG extends JFrame{
    private buttoncustom customers;
    private employeeG ss = this;
    private JMenuItem exit;
    private JMenu jMenu2;
    private JMenuBar jMenuBar2;
    private JMenuItem jMenuItem1;
    private buttoncustom orders;
    private static buttoncustom notications =  new buttoncustom("NOTIFICATIONS");
    private final int id_employee;
    private int showno = 2; // to show notification if number even and close notification if number odd
    private JPanel dynamic;
    private static notifications_panal n;
    public employeeG(int id_employeee)
    {
        this.id_employee = id_employeee;
        initComponents();
        
        n = new notifications_panal();
        this.add(n);
        n.setBounds(10, 25, 200, 200);
        n.setVisible(false);
        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(new File("hello.jpg"));
        } catch (Exception e) {
        }
        imagepanal background = new imagepanal(myImage);
        this.add(background, BorderLayout.CENTER);
        background.setSize( 1000, 700);

    }
    public static int get_no() // static to when add_order get this fun to get notification directly 
    {
        return n.get_notification(); // return number of size to add order to check it and change the color no button
    }
    public static void change_color_no_b() // static to when add_order get this fun to change color notification button directly 
    {
        notications.setBackground(Color.red);
    }
    
    private void initComponents()
    {
        orders = new buttoncustom();
        customers = new buttoncustom();
        jMenuBar2 = new JMenuBar();
        jMenu2 = new JMenu();
        exit = new JMenuItem();
        jMenuItem1 = new JMenuItem();
        dynamic = new JPanel();
        dynamic.setOpaque(false); // to make panal شفافة
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("employee");
        setResizable(false);
        setSize(1000, 700);
        this.setLayout(null);
        this.add(dynamic);
        dynamic.setBounds(0, 0, 1000, 680);
        edit_orders o = new edit_orders(id_employee);
        dynamic.add(o);
        edit_customers c = new edit_customers();
        dynamic.add(c);
        orders.setText("orders");
        orders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
                o.setVisible(true);
                c.setVisible(false);
            }
        });
        
        customers.setText("customers");
        customers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
                c.setVisible(true);
                o.setVisible(false);
            }
        });


        this.add(orders);
        this.add(customers);
        this.add(notications);
        orders.setBounds(350, 0, 80, 20);
        customers.setBounds(550, 0, 100, 20);
        notications.setBounds(10, 0, 140, 20);
        jMenu2.setText("File");

        exit.setText("Exit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        
        notications.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
               notications.setBackground(Color.ORANGE);
                if((showno % 2) == 0)
                {
                    n.setVisible(true);
                    showno--;
                }else
                {
                    n.setVisible(false);
                    showno++;
                }
            }
        });
        jMenu2.add(exit);

        jMenuBar2.add(jMenu2);


        

        setJMenuBar(jMenuBar2);
        
    }
    
   
}
