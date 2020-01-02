/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal_panals;

import GUI.buttoncustom;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import resturantmanagement.Order;
import resturantmanagement.customers;
/**
 *
 * @author eslam
 */
public class list_customers extends JPanel{
    private JTextField Tget_profile;
    private buttoncustom get_profile;
    private JScrollPane jScrollPane1;
    private JTable list_customers;
    private buttoncustom Refresh;
    
    public list_customers()
    {
        super(null);
        initComponents();
        addRowsTolist();
    }
    
    private void initComponents() {
    
        Refresh = new buttoncustom("Refresh");
        jScrollPane1 = new JScrollPane();
        list_customers = new JTable();
        get_profile = new buttoncustom("get profile");
        Tget_profile = new JTextField();
        jScrollPane1.setViewportView(list_customers);
        this.setOpaque(false);
        JTableHeader header = list_customers.getTableHeader();
        JScrollPane scroll = new JScrollPane(list_customers);
        
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        list_customers.setModel(new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "id", "first name", "last name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        this.add(scroll);
        Dimension f1 = scroll.getPreferredSize();
        scroll.setBounds(20, 250, f1.width, f1.height);
        scroll.setSize(550, 200);
        scroll.setOpaque(true);
        
        this.add(header);
        Dimension f2 = header.getPreferredSize();
        header.setBounds(20, 230, f2.width, f2.height);
        header.setSize(602, 20);
        
        this.add(get_profile);
        Dimension f3 = get_profile.getPreferredSize();
        get_profile.setBounds(120, 470, f3.width, f3.height);
        get_profile.setSize(95, 20);
        
        this.add(Tget_profile);
        Dimension f4 = Tget_profile.getPreferredSize();
        Tget_profile.setBounds(225, 470, f3.width, f3.height);
        Tget_profile.setSize(150, 20);
        
        this.add(Refresh);
        Dimension f5 = Refresh.getPreferredSize();
        Refresh.setBounds(120, 500, f5.width, f5.height);
        Refresh.setSize(95, 20);
        
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultTableModel model = (DefaultTableModel) list_customers.getModel();
                model.setNumRows(0);
                addRowsTolist();
            }
        });
    
        
        get_profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String id_custom = Tget_profile.getText();
                if(!id_custom.equals("") && id_custom != null && id_custom.matches("^[1-9]*$")){
                    Order o = new Order();
                    ArrayList<Order> oo = new ArrayList<>();
                    oo = o.customerProfile(Integer.parseInt(id_custom));
                    String profile = "";
                    int size = oo.size();
                    for(int i = 0; i < size; i++) profile += oo.get(i).getOrder() + " " + oo.get(i).getPrice() + "\n";
                    JOptionPane.showMessageDialog(Tget_profile, profile);
                }
            }
        });
    }
    
    public void addRowsTolist() {
        DefaultTableModel model = (DefaultTableModel) list_customers.getModel();
        
        Object rowData[] = new Object[3];

        customers c = new customers();
        ArrayList<customers> cc = new ArrayList<customers>();

        cc = (ArrayList<customers>) (Object)c.list();

        for (customers x : cc) {
            rowData[0] = x.getId();
            rowData[1] = x.getFname();
            rowData[2] = x.getLname();
            model.addRow(rowData);
        }
        

    }
    
    @Override
     public Dimension getPreferredSize()
     {
         return new Dimension(602, 550);
     }
}
