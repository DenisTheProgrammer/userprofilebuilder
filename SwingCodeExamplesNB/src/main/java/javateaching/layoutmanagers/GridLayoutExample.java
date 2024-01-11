/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javateaching.layoutmanagers;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 
 */
public class GridLayoutExample extends JPanel {
    public GridLayoutExample()
    {
        GridLayout gl = new GridLayout(2,3);
        this.setLayout(gl);

        JLabel component1 = new JLabel("component 1",JLabel.CENTER);
        component1.setBackground(Color.YELLOW);
        component1.setOpaque(true);

        JLabel component2 = new JLabel("component 2", JLabel.CENTER);
        component2.setBackground(Color.GREEN);
        component2.setOpaque(true);

        JLabel component3 = new JLabel("component 3");
        component3.setBackground(Color.ORANGE);
        component3.setOpaque(true);

        JLabel component4 = new JLabel("component 4");
        component4.setBackground(Color.CYAN);
        component4.setOpaque(true);

        JLabel component5 = new JLabel("<html><h1>component 5 with BIGNESS</h1></html>");
        component5.setBackground(Color.WHITE);
        component5.setOpaque(true);

        JLabel component6 = new JLabel("component 6");
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
