/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal_panals;

import GUI.buttoncustom;
import GUI.labelcustom;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.OptionPaneUI;
import resturantmanagement.admin;

/**
 *
 * @author nice
 */
public class AlterAdmin extends JPanel {

    labelcustom user, pass, Fname, Lname;
    JTextField userName, passWord, firstName, lastName;
    buttoncustom alter;

    public AlterAdmin() {

        setLayout(null);
        setSize(1000, 700);
        initComponent();

    }

    public void initComponent() {
        user = new labelcustom("new User Name");
        pass = new labelcustom("new Pass Word");
        Fname = new labelcustom("new first Name");
        Lname = new labelcustom("new last Name");
        userName = new JTextField();
        passWord = new JTextField();
        firstName = new JTextField();
        lastName = new JTextField();
        alter = new buttoncustom("alter");
        Fname.setBounds(100, 150, 100, 20);
        firstName.setBounds(220, 150, 140, 20);
        Lname.setBounds(100, 190, 100, 20);
        lastName.setBounds(220, 190, 140, 20);
        user.setBounds(100, 230, 100, 20);
        userName.setBounds(220, 230, 140, 20);
        pass.setBounds(100, 270, 100, 20);
        passWord.setBounds(220, 270, 140, 20);
        alter.setBounds(250, 315, 80, 30);
        add(user);
        add(userName);
        add(pass);
        add(passWord);
        add(alter);
        add(Fname);
        add(Lname);
        add(firstName);
        add(lastName);
        
        ArrayList<admin>k=new admin().list();
        firstName.setText(k.get(0).getFName());
        lastName.setText(k.get(0).getLName());
        passWord.setText(k.get(0).getPassword());
        userName.setText(k.get(0).getUserName());
        alter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (firstName.getText().equals("") || lastName.getText().equals("") || userName.getText().equals("") || passWord.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "You should full all the input fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    
                    admin q = new admin(firstName.getText(), lastName.getText(), userName.getText(), passWord.getText());
                    JOptionPane.showMessageDialog(null, "Updated Successfully ^_^", "Success", JOptionPane.INFORMATION_MESSAGE);
                    q.update();
                    firstName.setText("");
                    lastName.setText("");
                    passWord.setText("");
                    userName.setText("");
                }
                

            }
        });
    }
}
