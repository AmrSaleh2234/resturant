/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import internal_panals.addEmployee;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author eslam
 */
public class labelcustom extends JLabel{

    
    public labelcustom() {
        custom();
    }
    public labelcustom(String text) {
        super(text);
        custom();
    }
    
    private void custom()
    {
        setForeground(Color.white);
    }

    
    
}
