/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javateaching.basicgui;

import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author paul
 */
public class BasicGUITest {
    public static void main(String[] args)
    {
        JFrame ourwindow = new JFrame("Yay! Window");
        ourwindow.setLayout(new FlowLayout());
        
        JLabel label = new JLabel("Enter your name");
        JTextField text = new JTextField("Bill Bloggs");
        JCheckBox cbox = new JCheckBox("Enable");
        
        JRadioButton rbut = new JRadioButton("Leave");
        JRadioButton rbut2 = new JRadioButton("Remain");
        ButtonGroup brexit = new ButtonGroup();
        brexit.add(rbut);
        brexit.add(rbut2);
        
        String[] comboOptions = {"red","green","blue"};
        JComboBox comboBox = new JComboBox(comboOptions);
                
        JButton buttonOK = new JButton("OK");
        
        ourwindow.add(label);
        ourwindow.add(text);
        ourwindow.add(cbox);
        ourwindow.add(rbut);
        ourwindow.add(rbut2);
        ourwindow.add(comboBox);
        ourwindow.add(buttonOK);
        
        for (int i = 0; i < 50; i++) ourwindow.add(new JButton("Button"));
        
        ourwindow.setSize(600,400);
        
        ourwindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        ourwindow.setVisible(true);
        
        System.out.println("I am testing git");
    }
}

