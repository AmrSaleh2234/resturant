package internal_frames;


   
import GUI.buttoncustom;
import internal_panals.addEmployee;
import internal_panals.listEmployee;
import internal_panals.listEmployee;
import internal_panals.updateEmployee;
import internal_panals.updateEmployee;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import resturantmanagement.Employee;

public class editEmployee extends JPanel {

    private addEmployee addEmployeePanel = new addEmployee();
    private listEmployee showEmployeepanel = new listEmployee();
    private updateEmployee editEmployeePanal = new updateEmployee();
    private JPanel staticPanal, dynamicPanal;
    private buttoncustom addEmployee, editEmplopyee, showEmployee;
    private GridBagLayout layout = new GridBagLayout();

    public editEmployee() {
        dynamicPanal = new JPanel();
        dynamicPanal.setLayout(layout);
        dynamicPanal.add(addEmployeePanel);
        dynamicPanal.add(showEmployeepanel);
        dynamicPanal.add(editEmployeePanal);
       
        addEmployeePanel.setVisible(true);
        showEmployeepanel.setVisible(false);
        editEmployeePanal.setVisible(false);
        initComponent();
        
    }

    private void initComponent() {
        
        
        this.setSize(800, 650);
        //initialize panal
        staticPanal = new JPanel();
        //initialize buttoncustom
        addEmployee = new buttoncustom();
        editEmplopyee = new buttoncustom();
        showEmployee = new buttoncustom();
         setLayout(new BorderLayout());
        dynamicPanal.setOpaque(false);
        staticPanal.setOpaque(false);
        this.add(dynamicPanal, BorderLayout.EAST);
        this.setSize(800, 650);
        this.add(staticPanal, BorderLayout.CENTER);
        staticPanal.setLayout(new BoxLayout(staticPanal, BoxLayout.Y_AXIS));
        staticPanal.add(Box.createVerticalStrut(230));
        staticPanal.add(addEmployee);
        staticPanal.add(Box.createHorizontalStrut(10));
        staticPanal.add(showEmployee);
        staticPanal.add(Box.createHorizontalStrut(10));
        staticPanal.add(editEmplopyee);
        staticPanal.add(Box.createHorizontalStrut(190));
        addEmployee.setText("add Employee");
        showEmployee.setText("list Employee");
        editEmplopyee.setText("update Employee");
        addEmployee.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployeePanel.setVisible(true);
                editEmployeePanal.setVisible(false);
                showEmployeepanel.setVisible(false);
            }
        });
        showEmployee.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 addEmployeePanel.setVisible(false);
                editEmployeePanal.setVisible(false);
                showEmployeepanel.setVisible(true);
            }
        });
        editEmplopyee.addActionListener(new  ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 addEmployeePanel.setVisible(false);
                editEmployeePanal.setVisible(true);
                showEmployeepanel.setVisible(false);
            }
        });
    }
    
}
