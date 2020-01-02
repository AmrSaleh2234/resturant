/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal_panals;

import GUI.buttoncustom;
import GUI.labelcustom;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import resturantmanagement.Order;

/**
 *
 * @author eslam
 */
public class last_order extends JPanel{
    
    private labelcustom check;
    private buttoncustom delete;
    private buttoncustom get_last_order;
    private JTextField id_customer;
    private JTextField id_employee;
    private labelcustom jLabel1;
    private labelcustom jLabel2;
    private labelcustom jLabel3;
    private labelcustom jLabel4;
    private JTextField price;
    private JComboBox<String> product;
    
    public last_order() {
        super(null);
        initComponents();
    }
    
    private void initComponents() {

        jLabel1 = new labelcustom("id customer");
        jLabel2 = new labelcustom("products name");
        jLabel3 = new labelcustom("final price");
        jLabel4 = new labelcustom("id employee");
        get_last_order = new buttoncustom("get last order");
        delete = new buttoncustom("delete");
        price = new JTextField();
        id_customer = new JTextField();
        id_employee = new JTextField();
        product = new JComboBox<>();
        check = new labelcustom("search by id");
        this.setOpaque(false);
        price.setEditable(false);
        id_employee.setEditable(false);

        
        this.add(jLabel1);
        Dimension f1 = jLabel1.getPreferredSize();
        jLabel1.setBounds(100, 220, f1.width, f1.height);
        
        this.add(id_customer);
        Dimension f2 = id_customer.getPreferredSize();
        id_customer.setBounds(210, 220, f2.width, f2.height);
        id_customer.setSize(150, 20);
        
        this.add(get_last_order);
        Dimension f3 = get_last_order.getPreferredSize();
        get_last_order.setBounds(380, 220, f3.width, f3.height);
        get_last_order.setSize(120, 20);
        
        this.add(jLabel2);
        Dimension f4 = jLabel2.getPreferredSize();
        jLabel2.setBounds(100, 270, f4.width, f4.height);
        
        this.add(product);
        Dimension f5 = product.getPreferredSize();
        product.setBounds(210, 270, f5.width, f5.height);
        product.setSize(150, 20);
        
        this.add(jLabel3);
        Dimension f6 = jLabel3.getPreferredSize();
        jLabel3.setBounds(100, 320, f6.width, f6.height);
        
        this.add(price);
        Dimension f7 = price.getPreferredSize();
        price.setBounds(210, 320, f7.width, f7.height);
        price.setSize(150, 20);
        
        this.add(jLabel4);
        Dimension f8 = jLabel4.getPreferredSize();
        jLabel4.setBounds(100, 370, f8.width, f8.height);
        
        this.add(id_employee);
        Dimension f9 = id_employee.getPreferredSize();
        id_employee.setBounds(210, 370, f9.width, f9.height);
        id_employee.setSize(150, 20);
        
        this.add(check);
        Dimension f10 = check.getPreferredSize();
        check.setBounds(210, 400, f10.width, f10.height);
        
        this.add(delete);
        Dimension f11 = delete.getPreferredSize();
        delete.setBounds(210, 430, f11.width, f11.height);
        
        get_last_order.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                id_employee.setText("");
                price.setText("" );
                product.removeAllItems();
                Order o = new Order();
                String id_custom = id_customer.getText();
                if(!id_custom.equals("") && id_custom != null && id_custom.matches("^[1-9]*$"))
                {
                    o = (Order)o.getLastOrder(Integer.parseInt(id_custom));
                    if(o != null) 
                    {
                        check.setText("found");
                        id_employee.setText("" + o.getCustomerId());
                        price.setText("" + o.getPrice());
                        ArrayList<String> products = o.getOrder();
                        int sizemm = products.size();
                        for(int i = 0; i < sizemm; i++)
                        {
                            product.addItem(products.get(i));
                        }

                    }
                    else check.setText("not found");
                }else check.setText("not found");
            }
        });

        
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Order o = new Order();
                String id_custom = id_customer.getText();
                if(!id_custom.equals("") && id_custom != null && id_custom.matches("^[a-zA-Z1-9]*$"))
                {
                    if(o.deleteOrder(Integer.parseInt(id_custom))) check.setText("deleted");
                    else check.setText("not deleted");
                }else check.setText("not deleted");
            }
        });

        

    }
    
    @Override
     public Dimension getPreferredSize()
     {
         return new Dimension(602, 550);
     }
    
}
