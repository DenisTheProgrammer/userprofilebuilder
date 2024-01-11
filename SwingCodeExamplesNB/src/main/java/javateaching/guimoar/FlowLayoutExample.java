/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javateaching.guimoar;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author paulneve
 */
public class FlowLayoutExample extends JPanel {
    
    private JButton component1 = new JButton("click me");
    private JLabel component2 = new JLabel("component 2");
    private JLabel component3 = new JLabel("component 3");
    private JLabel component4 = new JLabel("component 4");
    private JLabel component5 = new JLabel("component 5");
    
    public FlowLayoutExample()
    {
        FlowLayout fl = new FlowLayout();
        this.setLayout(fl);
        
        component2.setBackground(Color.GREEN);
        component2.setOpaque(true);
        
        component3.setBackground(Color.ORANGE);
        component3.setOpaque(true);
        
        component4.setBackground(Color.CYAN);
        component4.setOpaque(true);
        
        component5.setBackground(Color.WHITE);
        component5.setOpaque(true);
        
        this.add(component1);
        this.add(component2);
        this.add(component3);
        this.add(component4);
        this.add(component5);
    }
}
