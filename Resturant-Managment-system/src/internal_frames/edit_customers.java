/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal_frames;

import GUI.buttoncustom;
import internal_panals.add_customer;
import internal_panals.list_customers;
import internal_panals.update_customers;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BrokenBarrierException;
import javax.swing.*;
/**
 *
 * @author eslam
 */
public class edit_customers extends JPanel{
    private buttoncustom add_customer;
    private JPanel dynamic_panal;
    private buttoncustom list_customers;
    private JPanel list_panal;
    private buttoncustom update_customers;
    private JPanel panal;
    private add_customer addc;
    private list_customers listc;
    private update_customers udc;
    private GridBagLayout layout = new GridBagLayout();
    
    public edit_customers() {
//        super("f", true, true, false, true);
//        setResizable(false);
        initComponents();
        addc = new add_customer();
        listc = new list_customers();
        udc = new update_customers();
        dynamic_panal.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();
        
        dynamic_panal.add(addc, c);
        dynamic_panal.add(listc, c);
        dynamic_panal.add(udc, c);
        addc.setVisible(true);
        listc.setVisible(false);
        udc.setVisible(false);
    }
    private void initComponents() {
        
        setLocation(0, 0);
        panal = new JPanel();
        list_panal = new JPanel();
        add_customer = new buttoncustom();
        list_customers = new buttoncustom();
        update_customers = new buttoncustom();
        dynamic_panal = new JPanel();
        this.setLayout(new BorderLayout());
        panal.setOpaque(false);
        dynamic_panal.setOpaque(false);
        this.setOpaque(false);
        this.add(dynamic_panal, BorderLayout.EAST);
        this.setSize(800, 650);
//        setTitle("edit customers");
        this.add(panal, BorderLayout.CENTER);
        panal.setLayout(new BoxLayout(panal, BoxLayout.Y_AXIS));
        panal.add(Box.createVerticalStrut(230));
        panal.add(add_customer);
        add_customer.setPreferredSize(new Dimension(300, 20));
        panal.add(Box.createHorizontalStrut(10));
        panal.add(list_customers);
        list_customers.setPreferredSize(new Dimension(300, 20));
        panal.add(Box.createHorizontalStrut(10));
        panal.add(update_customers);
        update_customers.setPreferredSize(new Dimension(300, 20));
        panal.add(Box.createHorizontalStrut(190));
        add_customer.setText("  add customers ");
        list_customers.setText(" list customers ");
        update_customers.setText("update customers");
        
        
        add_customer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
                addc.setVisible(true);
                listc.setVisible(false);
                udc.setVisible(false);
            }
        });

        list_customers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addc.setVisible(false);
                listc.setVisible(true);
                udc.setVisible(false);
            }
        });

        update_customers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addc.setVisible(false);
                listc.setVisible(false);
                udc.setVisible(true);
            }
        });

    }
}
