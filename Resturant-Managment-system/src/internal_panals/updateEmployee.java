package internal_panals;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUI.buttoncustom;
import GUI.labelcustom;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import resturantmanagement.Employee;

public class updateEmployee extends JPanel implements ActionListener {

    buttoncustom search, delete, update;
    JTextField searchEmp, Fname, Lname, userName, passWord;
    labelcustom Fnamelable, LnameLable, userNameLable, passWordLable, check;
    listEmployee l;
    public updateEmployee() {
        super(null);
        this.l = l;
        this.setOpaque(false);
        initComponents();
    }

    private void initComponents() {
        //Button initialize
        search = new buttoncustom("search");
        delete = new buttoncustom("delete");
        update = new buttoncustom("update");
        //textField initialize
        searchEmp = new JTextField();
        Fname = new JTextField();
        Lname = new JTextField();
        userName = new JTextField();
        passWord = new JTextField();
        //lable initialize

        Fnamelable = new labelcustom("first Name");
        LnameLable = new labelcustom("last Name");
        userNameLable = new labelcustom("user Name");
        passWordLable = new labelcustom("Password");
        check = new labelcustom("");
        //Locations
        setLayout(null);
        searchEmp.setBounds(250, 200, 120, 20);
        search.setBounds(400, 200, 100, 20);
        Fnamelable.setBounds(250, 250, 100, 20);
        LnameLable.setBounds(250, 300, 100, 20);
        userNameLable.setBounds(250, 350, 100, 20);
        passWordLable.setBounds(250, 400, 100, 20);
        ////////////////////////////////
        Fname.setBounds(400,250, 120, 20);
        Lname.setBounds(400, 300, 120, 20);
        userName.setBounds(400, 350, 120, 20);
        passWord.setBounds(400, 400, 120, 20);
        delete.setBounds(400, 450, 100, 20);
        update.setBounds(285, 450, 100, 20);
        check.setBounds(540, 450, 100, 30);
        check.setForeground(Color.red);
        add(searchEmp);
        add(search);
        add(Fname);
        add(Lname);
        add(userName);
        add(passWord);
        add(Fnamelable);
        add(LnameLable);
        add(userNameLable);
        add(passWordLable);
        add(delete);
        add(update);
        add(check);
        //actions
        search.addActionListener(this);
        delete.addActionListener(this);
        update.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Employee m;

        if (e.getSource() == search) {
            if (!searchEmp.equals("") && searchEmp != null && searchEmp.getText().matches("^[1-9]*$")) {

                m = new Employee().search(Integer.parseInt(searchEmp.getText()));
                Fname.setText(m.getFName());
                Lname.setText(m.getLName());
                userName.setText(m.getUserName());
                passWord.setText(m.getPassword());
                if (m.getFName() == null) {
                    check.setText("Not Found");
                } else {
                    check.setText("Founded");
                }
            } else {
                check.setText("Enter Id Please");
            }
        }
        if (e.getSource() == delete) {
            if (!searchEmp.getText().equals("")) {

                if (new Employee().delete(Integer.parseInt(searchEmp.getText()))) {
                    Fname.setText("");
                    Lname.setText("");
                    userName.setText("");
                    passWord.setText("");
                    check.setText("deleted");
                } else {
                    check.setText("not Deleted");
                }
            }

        }
        if (e.getSource() == update) {
            if (!searchEmp.getText().equals("") && !Fname.getText().equals("")) {
                m = new Employee(Fname.getText(), Lname.getText(), userName.getText(), passWord.getText());
                if (m.update(Integer.parseInt(searchEmp.getText()))) {
                    check.setText("Updated");
                } else {
                    check.setText("Not Updated");
                }

            } else {
                check.setText("not Updated");
            }

        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(602, 550);
    }
}
