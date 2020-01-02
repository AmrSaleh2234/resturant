/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal_frames;

import GUI.buttoncustom;
import internal_panals.Addgifs;
import internal_panals.Listgift;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author nice
 */
public class EditGifts extends JPanel {
    private JPanel staticPanal, dynamicPanal;
    Listgift m=new Listgift();
    Addgifs l =new Addgifs();
    private buttoncustom addGifs,showGifs;
    private GridBagLayout layout = new GridBagLayout();
    public EditGifts()
    {
        dynamicPanal = new JPanel();
        dynamicPanal.setLayout(layout);
        dynamicPanal.add(l);
        dynamicPanal.add(m);
        l.setVisible(true);
        m.setVisible(false);
        initComponent();
    }
    private void initComponent() {
        
        
        this.setSize(800, 650);
        //initialize panal
        staticPanal = new JPanel();
        //initialize buttoncustom
        addGifs = new buttoncustom();
        showGifs = new buttoncustom();
         setLayout(new BorderLayout());
        dynamicPanal.setOpaque(false);
        staticPanal.setOpaque(false);
        this.add(dynamicPanal, BorderLayout.EAST);
        this.add(staticPanal, BorderLayout.CENTER);
        staticPanal.setLayout(new BoxLayout(staticPanal, BoxLayout.Y_AXIS));
        staticPanal.add(Box.createVerticalStrut(260));
        staticPanal.add(addGifs);
        staticPanal.add(Box.createHorizontalStrut(10));
        staticPanal.add(showGifs);
        staticPanal.add(Box.createHorizontalStrut(190));
        addGifs.setText("add Gifts");
        showGifs.setText("list Gifts");
        addGifs.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                l.setVisible(true);
                m.setVisible(false);
            }
        });
        showGifs.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                m.setVisible(true);
                l.setVisible(false);
                
            }
        });
        
    }@Override
     public Dimension getPreferredSize()
     {
         return new Dimension(602, 550);
     }
}
