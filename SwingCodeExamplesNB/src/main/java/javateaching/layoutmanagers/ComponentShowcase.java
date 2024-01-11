/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javateaching.layoutmanagers;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author 
 */
public class ComponentShowcase {

    public static void main(String[] args)
    {
        // add top level window
        JFrame ourWindow = new JFrame("Component showcase");
        // set layout
        ourWindow.setLayout(new FlowLayout());

        // create components
        JButton buttonOK = new JButton("OK");
        JLabel label = new JLabel("Enter your name");
        JTextField text = new JTextField("Bill Bloggs");
        JCheckBox chbox = new JCheckBox("Option A");
        JRadioButton rbut = new JRadioButton("Option 1");
        JComboBox cbox = new JComboBox(new String [] {"red", "green", "blue"});
       JList jlist = new JList(new String [] {"red", "green", "blue"});

        // add components
        ourWindow.add(buttonOK);
        ourWindow.add(label);
        ourWindow.add(text);
        ourWindow.add(chbox);
        ourWindow.add(rbut);
        ourWindow.add(cbox);
       ourWindow.add(jlist);
        

        // set size
        ourWindow.setSize(650,60); //ourWindow.pack();
        // set visibility
        ourWindow.setVisible(true);
        ourWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

