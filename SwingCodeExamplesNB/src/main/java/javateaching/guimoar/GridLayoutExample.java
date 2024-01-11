/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javateaching.guimoar;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author paulneve
 */
public class GridLayoutExample extends JPanel {
    
    private JLabel component1 = new JLabel("component 1",JLabel.CENTER);
    private JLabel component2 = new JLabel("component 2", JLabel.CENTER);
    private JLabel component3 = new JLabel("component 3");
    private JLabel component4 = new JLabel("component 4");
    private JLabel component5 = new JLabel("<html><h1>component 5 with BIGNESS</h1></html>");
    private JLabel component6 = new JLabel("component 6");
    
    public GridLayoutExample()
    {
        GridLayout gl = new GridLayout(0,3);
        this.setLayout(gl);
        
        component1.setBackground(Color.YELLOW);
        component1.setOpaque(true);
        
        component2.setBackground(Color.GREEN);
        component2.setOpaque(true);
        
        component3.setBackground(Color.ORANGE);
        component3.setOpaque(true);
        
        component4.setBackground(Color.CYAN);
        component4.setOpaque(true);
        
        component5.setBackground(Color.WHITE);
        component5.setOpaque(true);
        
        component4.setBackground(Color.CYAN);
        component4.setOpaque(true);
        
        this.add(component1);
        this.add(component2);
        this.add(component3);
        this.add(component4);
        this.add(component5);
        this.add(component6);
    }
}
