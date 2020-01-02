package GUI;

import internal_frames.editEmployee;

import internal_panals.listEmployee;
import internal_panals.updateEmployee;
import internal_panals.AlterAdmin;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import GUI.buttoncustom;
import internal_frames.EditGifts;
import internal_panals.Addgifs;
import internal_panals.report_panal_C;
import internal_panals.report_panal_E;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class AdminGui extends JFrame {

    private buttoncustom Employee, Meal, report_E, report_C, alter,addGift,logout;
    private int show_r_E = 2, show_r_C = 2;
    AlterAdmin o = new AlterAdmin();
    mealsG p = new mealsG();
    editEmployee m = new editEmployee();
    private report_panal_E report_employees;
    private report_panal_C report_customers;
    EditGifts gift=new EditGifts();
    public AdminGui() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin");
        setResizable(false);
        setLayout(null);
        setSize(1000, 700);
        inintComponent();
        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(new File("hello.jpg"));
        } catch (Exception e) {
        }
        imagepanal background = new imagepanal(myImage);
        this.add(background, BorderLayout.CENTER);
        background.setSize(1000, 700);
        
        
        
    }

    public void inintComponent() {
        report_employees = new report_panal_E();
        add(report_employees);
        addGift=new buttoncustom("gift");
      logout=new buttoncustom("logout");
        report_employees.setBounds(10, 20, 200, 200);
        report_employees.setVisible(false);
        report_employees.get_reports();
        report_customers = new report_panal_C();
        add(report_customers);
        report_customers.setBounds(775, 20, 200, 200);
        logout.setBounds(130, 0, 100, 20);
        report_customers.setVisible(false);
        report_customers.get_reports();
        m.setOpaque(false);
        o.setOpaque(false);
        o.setVisible(false);
        m.setVisible(true);
        p.setOpaque(false);
        p.setVisible(false);
        gift.setOpaque(false);
        gift.setVisible(false);
        add(p);
        add(m);
        add(o);
        add(gift);
        add(logout);
        Employee = new buttoncustom("edit Employee");
        Meal = new buttoncustom("edit Meals");
        Employee.setBounds(350, 0, 130, 20);
        report_E = new buttoncustom("Report E");
        alter = new buttoncustom("Admin");
        add(report_E);
        report_E.setBounds(0, 0, 100, 20);
        report_E.setVisible(true);
        report_C = new buttoncustom("Report C");
        add(report_C);
        report_C.setBounds(890, 0, 100, 20);
        report_C.setVisible(true);
        Meal.setBounds(500, 0, 100, 20);
        alter.setBounds(630, 0, 100, 20);         
        addGift.setBounds(760, 0, 100, 20);
         add(addGift);
        add(Employee);
        add(alter);
        add(Meal);
        Employee.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                m.setVisible(true);
                p.setVisible(false);
                o.setVisible(false);
                gift.setVisible(false);

            }
        });
        Meal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                p.setVisible(true);
                m.setVisible(false);
                o.setVisible(false);
                gift.setVisible(false);

            }
        });
        
        report_E.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if((show_r_E % 2) == 0)
                {
                    report_employees.setVisible(true);
                    show_r_E++;
                }else
                {
                    report_employees.setVisible(false);
                    show_r_E--;
                }

            }
        });
        alter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                o.setVisible(true);
                p.setVisible(false);
                m.setVisible(false);
                gift.setVisible(false);
            }
        });
        
        report_C.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if((show_r_C % 2) == 0)
                {
                    report_customers.setVisible(true);
                    
                    show_r_C++;
                }else
                {
                    report_customers.setVisible(false);
                    show_r_C--;
                }

            }
        });
        addGift.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                o.setVisible(false);
                p.setVisible(false);
                m.setVisible(false);
                gift.setVisible(true);
            }
        });
        logout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new login().setVisible(true);
                setVisible(false);
            }
        });

    }

}
