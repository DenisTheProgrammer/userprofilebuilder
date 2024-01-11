/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javateaching.layoutmanagers;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 
 */
public class FlowLayoutExample extends JPanel {
    public FlowLayoutExample()
    {
        FlowLayout fl = new FlowLayout();
        this.setLayout(fl);

        /*JLabel component1 = new JLabel("component 1");
        component1.setBackground(Color.YELLOW);
        component1.setOpaque(true); */

        JButton component1 = new JButton("click me");
        component1.setActionCommand("clickme");
        component1.addActionListener(Controller.getInstance());

        JLabel component2 = new JLabel("component 2");
        component2.setBackground(Color.GREEN);
        component2.setOpaque(true);

        JLabel component3 = new JLabel("component 3");
        component3.setBackground(Color.ORANGE);
        component3.setOpaque(true);

        JLabel component4 = new JLabel("component 4");
        component4.setBackground(Color.CYAN);
        component4.setOpaque(true);

        JLabel component5 = new JLabel("component 5");
        component5.setBackground(Color.WHITE);
        component5.setOpaque(true);
        
        this.add(component1);
        this.add(component2);
        this.add(component3);
        this.add(component4);
        this.add(component5);
    }
}
