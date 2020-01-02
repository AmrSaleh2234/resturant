/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal_panals;

import GUI.buttoncustom;
import GUI.employeeG;
import GUI.labelcustom;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.*;
import resturantmanagement.Gifs;
import resturantmanagement.Meals;
import resturantmanagement.Order;

/**
 *
 * @author eslam
 */
public class add_order extends JPanel {

    private Meals m = new Meals();
    private Order o;
    private int id_employee;
    ArrayList<String> orders = new ArrayList<>();
    private buttoncustom add;
    private JTextField all_payment;
    private labelcustom check;
    private JTextField id_customer;
    private labelcustom jLabel1;
    private labelcustom jLabel2;
    private JMenu jMenu1;
    private labelcustom jmeals;
    private JComboBox<String> meals;
    private buttoncustom pay;
    private buttoncustom reset;
    private JTextField price;

    public add_order(int id_employee) {

        super(null);
        this.id_employee = id_employee;
        initComponents();
        ArrayList<Meals> mm = new ArrayList<>();
        mm = (ArrayList<Meals>) (Object) m.list();
        int sizemm = mm.size();
        for (int i = 0; i < sizemm; i++) {
            meals.addItem(mm.get(i).get_Product_Name());
        }

        meals.setMaximumRowCount(3);

    }

    private void initComponents() {

        reset = new buttoncustom("Reset");
        jMenu1 = new JMenu();
        jmeals = new labelcustom("meals");
        meals = new JComboBox<>();
        price = new JTextField();
        add = new buttoncustom("add order");
        jLabel1 = new labelcustom();
        all_payment = new JTextField();
        pay = new buttoncustom();
        jLabel2 = new labelcustom();
        id_customer = new JTextField();
        check = new labelcustom("add id customer first");
        this.setOpaque(false);
        jMenu1.setText("jMenu1");
        jmeals.setText("meals");
        jLabel1.setText("all payment");

        all_payment.setEditable(false);
        all_payment.setText("0");

        pay.setText("pay");
        price.setEditable(false);

        add.setText("add");
        jLabel2.setText("id customer");

        this.add(jmeals);
        Dimension f1 = jmeals.getPreferredSize();
        jmeals.setBounds(100, 220, f1.width, f1.height);

        this.add(meals);
        Dimension f2 = meals.getPreferredSize();
        meals.setBounds(210, 220, f2.width, f2.height);
        meals.setSize(100, 20);

        this.add(price);
        Dimension f3 = price.getPreferredSize();
        price.setBounds(320, 220, f3.width, f3.height);
        price.setSize(150, 20);

        this.add(add);
        Dimension f4 = add.getPreferredSize();
        add.setBounds(210, 280, f4.width, f4.height);

        this.add(all_payment);
        Dimension f5 = all_payment.getPreferredSize();
        all_payment.setBounds(210, 320, f5.width, f5.height);
        all_payment.setSize(100, 20);

        this.add(jLabel2);
        Dimension f6 = jLabel2.getPreferredSize();
        jLabel2.setBounds(100, 350, f6.width, f6.height);

        this.add(id_customer);
        Dimension f7 = id_customer.getPreferredSize();
        id_customer.setBounds(210, 350, f7.width, f7.height);
        id_customer.setSize(100, 20);

        this.add(pay);
        Dimension f8 = pay.getPreferredSize();
        pay.setBounds(210, 380, f8.width, f8.height);

        this.add(check);
        Dimension f9 = check.getPreferredSize();
        check.setBounds(275, 387, f9.width, f9.height);

        this.add(reset);
        Dimension f10 = pay.getPreferredSize();
        reset.setBounds(210, 420, f10.width, f10.height);
        reset.setSize(100, 30);
        
        meals.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                Meals mm;
                if (meals.getSelectedItem() != null) {
                    mm = (Meals) m.search(meals.getSelectedItem().toString());
                    price.setText("" + mm.getCost());
                }
            }
        });
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String order = meals.getSelectedItem().toString();
                orders.add(order);
                m = (Meals) m.search(order);
                Double payment = Double.parseDouble(all_payment.getText()) + (m.getCost());
                all_payment.setText("" + payment);
            }
        });
        
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                orders.clear();
                all_payment.setText("0");
            }
        });
        
        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String id_custom = id_customer.getText();
                if (!id_custom.equals("") && id_custom != null && id_custom.matches("^[1-9]*$") && orders.size() > 0) {
                    o = new Order(orders, Integer.parseInt(id_custom), id_employee);
                    int sizeoforder = orders.size();
                    String details = "";
                    for (int i = 0; i < sizeoforder; i++) {
                        details += orders.get(i) + ", ";
                    }
                    details += "\nprice after discount= " + o.getPrice();

                    if (o.add()) {
                        check.setText("order added");
                        JOptionPane.showMessageDialog(all_payment, details);
                        all_payment.setText("0");
                        orders.clear();
                        Gifs g = new Gifs();
                        g.customerGift(o.getPrice());
                        if (employeeG.get_no() > 0) {
                            employeeG.change_color_no_b(); // to write in notification and change color
                        }
                    } else {
                        check.setText("not add");
                    }
                } else {
                    check.setText("not add");
                }
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(602, 550);
    }
}
