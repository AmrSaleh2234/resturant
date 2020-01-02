/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal_panals;

import GUI.buttoncustom;
import GUI.labelcustom;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.*;
import resturantmanagement.customers;
/**
 *
 * @author eslam
 */
public class update_customers extends JPanel{
    private buttoncustom Delete_customer;
    private labelcustom check;
    private labelcustom first_name;
    private JTextField first_name_customer;
    private labelcustom id;
    private JTextField id_customer;
    private labelcustom last_name;
    private JTextField last_name_customer;
    private buttoncustom search_customer;
    private JTextField search_of_customer;
    private buttoncustom update_customer1;
    customers c;
    public update_customers()
    {
        super(null);
        initComponents();
    }
    private void initComponents() {

        Delete_customer = new buttoncustom();
        first_name = new labelcustom("first name");
        last_name = new labelcustom("last name");
        first_name_customer = new JTextField();
        last_name_customer = new JTextField();
        this.setOpaque(false);
        id = new labelcustom("id");
        id_customer = new JTextField();
        update_customer1 = new buttoncustom("update");
        search_of_customer = new JTextField();
        search_customer = new buttoncustom("Search");
        check = new labelcustom("search by id.");

        Delete_customer.setText("Delete");
        first_name.setText("first name");
        last_name.setText("last name");
        id.setText("id");
        id_customer.setEditable(false);
        update_customer1.setText("update");
        
        this.add(search_of_customer);
        Dimension f1 = search_of_customer.getPreferredSize();
        search_of_customer.setBounds(180, 220, f1.width, f1.height);
        search_of_customer.setSize(150, 20);
        
        this.add(search_customer);
        Dimension f2 = search_customer.getPreferredSize();
        search_customer.setBounds(350, 220, f2.width, f2.height);
        search_customer.setSize(80, 20);
        
        this.add(id);
        Dimension f3 = id.getPreferredSize();
        id.setBounds(145, 265, f3.width, f3.height);
        
        this.add(id_customer);
        Dimension f4 = id_customer.getPreferredSize();
        id_customer.setBounds(180, 265, f4.width, f4.height);
        id_customer.setSize(150, 20);
        
        this.add(first_name);
        Dimension f5 = first_name.getPreferredSize();
        first_name.setBounds(100, 310, f5.width, f5.height);
        
        this.add(first_name_customer);
        Dimension f6 = first_name_customer.getPreferredSize();
        first_name_customer.setBounds(180, 310, f6.width, f6.height);
        first_name_customer.setSize(150, 20);
        
        this.add(last_name);
        Dimension f7 = last_name.getPreferredSize();
        last_name.setBounds(100, 355, f7.width, f7.height);
        
        this.add(last_name_customer);
        Dimension f8 = last_name_customer.getPreferredSize();
        last_name_customer.setBounds(180, 355, f8.width, f8.height);
        last_name_customer.setSize(150, 20);
        
        this.add(check);
        Dimension f9 = check.getPreferredSize();
        check.setBounds(180, 400, f9.width, f9.height);
        
        this.add(update_customer1);
        Dimension f10 = update_customer1.getPreferredSize();
        update_customer1.setBounds(180, 445, f10.width, f10.height);
        
        this.add(Delete_customer);
        Dimension f11 = Delete_customer.getPreferredSize();
        Delete_customer.setBounds(260, 445, f11.width, f11.height);
        
        Delete_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c = new customers();
                String id = id_customer.getText();
                if(!id.equals("") && id != null && id.matches("^[a-zA-Z1-9]*$"))
                {
                    if(c.delete(Integer.parseInt(id))) check.setText("deleted");
                    else check.setText("not deleted");
                }else check.setText("not deleted");
                
            }
        });
        update_customer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String first = first_name_customer.getText();
                String last = last_name_customer.getText();
                if(!first.equals("") && first != null && first.matches("^[a-zA-Z1-9]*$")
                && !last.equals("") && last != null && last.matches("^[a-zA-Z1-9]*$"))
                {
                    c = new customers(first, last);
                    if(c.update(Integer.parseInt(id_customer.getText()))) check.setText("update");
                    else check.setText("not update");
                }else check.setText("not update");
            }
        });

        search_customer.setText("search");
        search_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(!search_of_customer.getText().equals("") && search_of_customer.getText() != null && search_of_customer.getText().matches("^[1-9]*$"))
                {
                    c = new customers();
                    c = c.search(Integer.parseInt(search_of_customer.getText()));
                    id_customer.setText("" + c.getId());
                    first_name_customer.setText(c.getFname());
                    last_name_customer.setText(c.getLname());
                }
            }
        });
    }
    
    @Override
     public Dimension getPreferredSize()
     {
         return new Dimension(602, 550);
     }
}
