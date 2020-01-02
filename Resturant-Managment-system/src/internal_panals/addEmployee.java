/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal_panals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUI.buttoncustom;
import GUI.labelcustom;
import javax.swing.JPanel;
import javax.swing.JTextField;
import resturantmanagement.Employee;

/**
 *
 * @author nice
 */
public class addEmployee extends JPanel implements ActionListener{
    JTextField  userName  ;
    labelcustom Name;
    labelcustom check;
    JTextField  passWord  ;
    labelcustom pass;
    JTextField  FName ;
    labelcustom firstName;
    JTextField  LName  ;
    labelcustom lastName;
    buttoncustom addEmp;

    public addEmployee() {
        super(null);
        setBackground(Color.red);
        //data Employee add
        userName =new JTextField();
         this.setOpaque(false);
        Name =new labelcustom("UserName");
        passWord =new JTextField();
        pass =new labelcustom("Password");
        FName =new JTextField();
        check=new labelcustom();
        firstName =new labelcustom("First Name");
        LName =new JTextField();
        lastName =new labelcustom("Last Name");
        addEmp=new buttoncustom("submit");
        // Location of Component
        Name.setBounds(200, 200, 60, 20);
        userName.setBounds(300, 200, 120, 20);
        pass.setBounds(200, 250, 60, 20);
        passWord.setBounds(300, 250, 120, 20);
        firstName.setBounds(200, 300, 120, 20);
         FName.setBounds(300, 300, 120, 20);
          lastName.setBounds(200, 350, 120, 20);
         LName.setBounds(300, 350, 120, 20);
         addEmp.setBounds(200, 400, 80, 30);
         check.setBounds(300, 400, 80, 30);
       
        // add component to panal
        add(Name);add(userName);add(pass);add(passWord);
        add(FName);add(firstName);
        add(LName);add(lastName);
        add(addEmp);add(check);
        addEmp.addActionListener(this);
      
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addEmp)
        {
            String firstN=FName.getText();
            String lastN=LName.getText();
            String user=userName.getText();
            String passW=passWord.getText();
            if(!firstN.equals("")&&!lastN.equals("")&&!user.equals("")&&!passW.equals(""))
            {
                Employee m=new Employee(firstN, lastN, user, passW);
                if(m.add())
                {
                    check.setText("added");
                }
                else
                {
                    check.setText("failed");
                }
           }
            else
            {
                check.setText("full all data");
            }
        }
    }
    @Override
     public Dimension getPreferredSize()
     {
         return new Dimension(602, 550);
     }
}

