/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import internal_panals.internal_meals_for_log;
import internal_panals.internallogin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import resturantmanagement.Order;

/**
 *
 * @author mmmm
 */
public class login extends JFrame {

    private buttoncustom log;
    private buttoncustom meals;
    private JPanel dynamicpanel;
    private GridBagLayout layout = new GridBagLayout();
    private internallogin logpanel = new internallogin(this);
    private internal_meals_for_log meals_log = new internal_meals_for_log();

    public login() {
        initComponents();
        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(new File("hello.jpg"));
        } catch (Exception e) {
        }
        imagepanal background = new imagepanal(myImage);
        this.add(background, BorderLayout.CENTER);
        background.setSize(1000, 700);
    }
    
    private void initComponents() {
        setSize(1000, 700);
        setResizable(false);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        log = new buttoncustom("login");
        meals = new buttoncustom("meals");
        dynamicpanel = new JPanel();
        setLayout(null);
        log.setBounds(350, 5, 100, 20);
        meals.setBounds(500, 5, 100, 20);
        dynamicpanel.setBounds(0, 30, 1000, 670);
        dynamicpanel.setOpaque(false);
        this.add(dynamicpanel);
        this.add(log);
        this.add(meals);
        dynamicpanel.setLayout(layout);
        dynamicpanel.add(logpanel);
        logpanel.setVisible(true);
        dynamicpanel.add(meals_log);
        meals_log.setVisible(false);

        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                logpanel.setVisible(true);
                meals_log.setVisible(false);
            }

        });

        meals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                logpanel.setVisible(false);
                meals_log.setVisible(true);
            }

        });
        
        

    }
}
