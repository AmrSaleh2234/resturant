/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal_panals;
import GUI.buttoncustom;
import GUI.labelcustom;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import resturantmanagement.*;

/**
 *
 * @author mmmm
 */
public class internal_meals_for_log extends JPanel{
    private JTable meals;
    private buttoncustom get_profile;
    private JTextField tget_profile;
    private labelcustom check;
    public internal_meals_for_log()
    {
        super(null);
        initComponent();
        addRowsTolist();
    }

    private void initComponent() {
        check = new labelcustom("By id");
        get_profile = new buttoncustom("get profile");
        tget_profile = new JTextField();
        meals = new JTable();
        setOpaque(false);
        JTableHeader header = meals.getTableHeader();
        meals.setModel(new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Product name", "Cost", "Offer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        this.add(header);
        Dimension f1 = header.getPreferredSize();
        header.setBounds(300, 0, f1.width, f1.height);
        header.setSize(400, 20);
        
        this.add(meals);
        Dimension f2 = meals.getPreferredSize();
        meals.setBounds(300, 20, f2.width, f2.height);
        meals.setSize(400, 500);
        meals.setOpaque(false);
        
        this.add(get_profile);
        Dimension f3 = get_profile.getPreferredSize();
        get_profile.setBounds(350, 560, f3.width, f3.height);
        get_profile.setSize(100, 20);
        
        this.add(tget_profile);
        Dimension f4 = tget_profile.getPreferredSize();
        tget_profile.setBounds(460, 560, f4.width, f4.height);
        tget_profile.setSize(150, 20);
        
        this.add(check);
        Dimension f5 = check.getPreferredSize();
        check.setBounds(620, 560, f5.width, f5.height);
        
        get_profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String id_custom = tget_profile.getText();
                if(!id_custom.equals("") && id_custom != null && id_custom.matches("^[1-9]*$")){
                    Order o = new Order();
                    ArrayList<Order> oo = new ArrayList<>();
                    oo = o.customerProfile(Integer.parseInt(id_custom));
                    String profile = "";
                    int size = oo.size();
                    for(int i = 0; i < size; i++) profile += oo.get(i).getOrder() + " " + oo.get(i).getPrice() + "\n";
                    JOptionPane.showMessageDialog(tget_profile, profile);
                }
            }
        });
    }
    
    public void addRowsTolist() {
        DefaultTableModel model = (DefaultTableModel) meals.getModel();
        
        Object rowData[] = new Object[9];

        Meals c = new Meals();
        ArrayList<Meals> cc = new ArrayList<Meals>();

        cc = (ArrayList<Meals>) (Object)c.list();

        for (Meals x : cc) {
            rowData[0] = x.get_Product_Name();
            rowData[1] = x.getCost();
            rowData[2] = x.getOffer()*100;
            model.addRow(rowData);
        }
        

    }
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(1000, 670);
    }
}
