/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal_panals;

import GUI.*;
import resturantmanagement.*;
import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author mmmm
 */
public class internallogin extends JPanel {

    private JTextField Username;
    private JPasswordField password;
    private labelcustom LUsername;
    private labelcustom LPassword;
    private buttoncustom submit;
    private login l;
    public internallogin(login l) {
        // logn here to can close login window and open employee or admin window
        super(null);
        this.l = l;
        initComponents();
    }

    private void initComponents() {
        LUsername = new labelcustom("User Name");
        Username = new JTextField();
        LPassword = new labelcustom("Password");
        password = new JPasswordField();
        submit = new buttoncustom("SUBMIT");
        setOpaque(false);
        this.add(LUsername);
        Dimension f1 = LUsername.getPreferredSize();
        LUsername.setBounds(400, 200, f1.width, f1.height);
        this.add(Username);
        Dimension f2 = Username.getPreferredSize();
        Username.setBounds(400, 230, f2.width, f2.height);
        Username.setSize(150, 30);
        this.add(LPassword);
        Dimension f3 = LPassword.getPreferredSize();
        LPassword.setBounds(400, 270, f1.width, f1.height);

        Dimension f4 = password.getPreferredSize();
        password.setBounds(400, 300, f2.width, f2.height);
        password.setSize(150, 30);
        this.add(password);

        Dimension f5 = submit.getPreferredSize();
        submit.setBounds(400, 350, f2.width, f2.height);
        submit.setSize(150, 30);
        this.add(submit);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String user = Username.getText();
                String pass = password.getText();
                if (!user.equals("") && user != null && user.matches("^[a-zA-Z1-9]*$")
                        && !pass.equals("") && pass != null && pass.matches("^[a-zA-Z1-9]*$")) {
                    admin a = new admin();
                    Employee e = new Employee();
                    if (a.login(user, pass) != 0) {
                        
                               new AdminGui().setVisible(true);
                               l.setVisible(false);
                    } else if (e.login(user, pass) != -1) {
                        l.setVisible(false);
                        new employeeG(e.login(user, pass)).setVisible(true);
                    }else JOptionPane.showMessageDialog(null, "username or password uncorrect :(");
                }else JOptionPane.showMessageDialog(null, "only chars and numbers");
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 670);
    }

}
