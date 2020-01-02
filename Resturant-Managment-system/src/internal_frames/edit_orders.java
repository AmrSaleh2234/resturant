/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal_frames;

import GUI.buttoncustom;
import internal_panals.add_order;
import internal_panals.last_order;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author eslam
 */
public class edit_orders extends JPanel{
    private buttoncustom add_order;
    private JPanel dynamic_panal;
    private buttoncustom last_order;
    private add_order addo;
    private last_order listo;
    private GridBagLayout layout = new GridBagLayout();
    private int id_employee;
    
    public edit_orders(int id_employeee) {
        initComponents();
        this.id_employee = id_employeee;
        addo = new add_order(id_employee);
        listo = new last_order();
        dynamic_panal.setLayout(layout);
       GridBagConstraints c = new GridBagConstraints();
        
        dynamic_panal.add(addo, c);
        dynamic_panal.add(listo, c);
        
        
        addo.setVisible(true);
        listo.setVisible(false);
    }
    
    private void initComponents() {

        add_order = new buttoncustom("add order");
        last_order = new buttoncustom("last order");
        dynamic_panal = new JPanel();
        this.setOpaque(false);
        dynamic_panal.setOpaque(false);
        
//        setClosable(true);
        
        this.setSize(800, 650);
//        setTitle("edit orders");
        last_order.setText("last order");
        add_order.setText("add order");
        JPanel panal = new JPanel();
        panal.setOpaque(false);
        this.add(panal, BorderLayout.WEST);
        this.add(dynamic_panal, BorderLayout.CENTER);
        panal.setLayout(new BoxLayout(panal, BoxLayout.Y_AXIS));
        panal.add(Box.createHorizontalStrut(50));
        panal.add(add_order);
        panal.add(Box.createVerticalStrut(50));
        panal.add(last_order);
        panal.add(Box.createHorizontalStrut(100));
        
        
        add_order.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addo.setVisible(true);
                listo.setVisible(false);
            }
        });
        
        last_order.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addo.setVisible(false);
                listo.setVisible(true);
            }
        });
    }
    
}
