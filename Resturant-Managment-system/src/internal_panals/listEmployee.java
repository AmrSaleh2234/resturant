package internal_panals;

import GUI.buttoncustom;
import java.awt.Dimension;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import resturantmanagement.Employee;
import resturantmanagement.customers;

public class listEmployee extends JPanel {

    buttoncustom Refresh = new buttoncustom("Refresh");
    JTable list_employee = new JTable();
    ArrayList<Employee> l = (ArrayList<Employee>) (Object) new Employee().list();
    private JScrollPane jScrollPane1 = new JScrollPane();

    public listEmployee() {
        super(null);

        list_employee.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "id", "first name", "last name", "password", "username"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

        });
        jScrollPane1.setViewportView(list_employee);
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
        DefaultTableModel model = (DefaultTableModel) list_employee.getModel();
        model.setNumRows(0);
        Object rowData[] = new Object[5];
        l = (ArrayList<Employee>) (Object) new Employee().list();

        for (Employee x : l) {
            rowData[0] = x.getId();
            rowData[1] = x.getFName();
            rowData[2] = x.getLName();
            rowData[3] = x.getPassword();
            rowData[4] = x.getUserName();
            model.addRow(rowData);
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(602, 550);
    }
}
