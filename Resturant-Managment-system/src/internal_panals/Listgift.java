/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal_panals;

import GUI.buttoncustom;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import resturantmanagement.Employee;
import resturantmanagement.Gifs;

/**
 *
 * @author nice
 */
public class Listgift extends JPanel{
    
    buttoncustom Refresh = new buttoncustom("Refresh");
    JTable list_gift = new JTable();
    ArrayList<Gifs> l = (ArrayList<Gifs>) (Object) new Gifs().list();
     private JScrollPane jScrollPane1 = new JScrollPane();
     public Listgift ()
     {
         
         setLayout(null);
         setSize(700, 500);
        list_gift.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "gift","payment"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

        });
        jScrollPane1.setViewportView(list_gift);
        add(jScrollPane1);
        jScrollPane1.setBounds(200, 100, 300, 400);
        jScrollPane1.setVisible(true);
        this.setOpaque(false);
        Refresh.setBounds(400, 500, 100, 20);
        Refresh.setVisible(true);
        this.add(Refresh);
        Refresh.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addRowsTolist();
            }

             
        });

        addRowsTolist();
     }
     public void addRowsTolist() {
        DefaultTableModel model = (DefaultTableModel) list_gift.getModel();
        model.setNumRows(0);
        Object rowData[] = new Object[5];
        l = (ArrayList<Gifs>) (Object) new Gifs().list();

        for (Gifs x : l) {
            rowData[0] = x.getGift();
            rowData[1] = x.getPayment();
            
            model.addRow(rowData);
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(602, 550);
    }
    
}
