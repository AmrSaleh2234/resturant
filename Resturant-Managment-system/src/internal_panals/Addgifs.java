/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal_panals;

import GUI.buttoncustom;
import GUI.labelcustom;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import resturantmanagement.Gifs;

/**
 *
 * @author nice
 */
public class Addgifs extends JPanel{
    labelcustom pay,gift;
    JTextField payment,giftTxt;
    buttoncustom enter;
    public Addgifs()
    {
        super(null);
        setSize(800, 650);
        setBackground(Color.red);
        setOpaque(false);
        initComponent();
        
        
    }
    public void initComponent()
    {
        pay=new labelcustom("Payment");
        gift =new labelcustom("gift");
        payment=new JTextField();
        giftTxt=new JTextField();
        enter=new buttoncustom("add gifit");
        pay.setBounds(100, 250, 100, 20);
        payment.setBounds(220, 250, 140, 20);
        gift.setBounds(100, 310, 100, 20);
        giftTxt.setBounds(220,310, 140, 20);
        enter.setBounds(220, 371, 80, 20); 
        add(pay);
        add(payment);
        add(gift);
        add(giftTxt);
        add(enter);
       
        enter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!payment.getText().equals("")&&!giftTxt.getText().equals("")){
                    
               Gifs m=new Gifs(giftTxt.getText(),Integer.parseInt(payment.getText()));
                    m.add();
                    JOptionPane.showMessageDialog(null,"added");
                  }
                else
                    
                {
                   JOptionPane.showMessageDialog(null,"error");
               
                }
            }
        });
        
    }
    @Override
     public Dimension getPreferredSize()
     {
         return new Dimension(602, 550);
     }
}
