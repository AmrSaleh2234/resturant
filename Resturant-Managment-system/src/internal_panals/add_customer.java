/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal_panals;
import GUI.buttoncustom;
import GUI.labelcustom;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import resturantmanagement.customers;
/**
 *
 * @author eslam
 */
public class add_customer extends JPanel{
    private buttoncustom add_customer;
    private labelcustom check;
    private labelcustom first_name;
    private JTextField first_name_customer;
    private labelcustom last_name;
    private JTextField last_name_customer;
    
    public add_customer()
    {
        super(null);
        initComponents();
    }
     private void initComponents() {
        
        first_name = new labelcustom();
        last_name = new labelcustom();
        first_name_customer = new JTextField();
        last_name_customer = new JTextField();
        add_customer = new buttoncustom("add");
        check = new labelcustom("only chars and numbers");
        this.setOpaque(false);
        first_name.setText("first name");
        last_name.setText("last name");
        add_customer.setText("add");
        
        this.add(first_name);
        Dimension f1 = first_name.getPreferredSize();
        first_name.setBounds(100, 300, f1.width, f1.height);
        
        this.add(first_name_customer);
        Dimension f2 = first_name_customer.getPreferredSize();
        first_name_customer.setBounds(180, 298, f2.width, f2.height);
        first_name_customer.setSize(150, 20);
        
        this.add(last_name);
        Dimension f3 = last_name.getPreferredSize();
        last_name.setBounds(100, 350, f3.width, f3.height);
        
        this.add(last_name_customer);
        Dimension f4 = last_name_customer.getPreferredSize();
        last_name_customer.setBounds(180, 348, f4.width, f4.height);
        last_name_customer.setSize(150, 20);
        
        this.add(check);
        Dimension f5 = check.getPreferredSize();
        check.setBounds(180, 380, f5.width, f5.height);
        
        this.add(add_customer);
        Dimension f6 = add_customer.getPreferredSize();
        add_customer.setBounds(180, 400, f6.width, f6.height);
        add_customer.setBorderPainted(true);
        
        
        add_customer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String fname = first_name_customer.getText();
                String lname = last_name_customer.getText();
                if(!fname.equals("") && fname != null && fname.matches("[a-zA-Z1-9]*$")
                        && !lname.equals("") && lname != null && lname.matches("[a-zA-Z1-9]*$"))
                {
                    customers c = new customers(fname, lname);
                    if(c.add()) {check.setText("added"); JOptionPane.showMessageDialog(add_customer, "id is " + c.getId());}
                    else check.setText("not add");
                    
                }else check.setText("not add");
            }
        });
        
     }
     @Override
     public Dimension getPreferredSize()
     {
         return new Dimension(602, 550);
     }
}
