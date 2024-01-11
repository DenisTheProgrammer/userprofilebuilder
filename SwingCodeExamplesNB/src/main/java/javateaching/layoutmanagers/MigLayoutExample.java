/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javateaching.layoutmanagers;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author 
 */
public class MigLayoutExample extends JPanel {
    private  JLabel component4;
    public MigLayoutExample()
    {
        MigLayout migL = new MigLayout("wrap 2");
        this.setLayout(migL);

        JLabel component1 = new JLabel("component 1");
        component1.setBackground(Color.YELLOW);
        component1.setOpaque(true);

        JLabel component2 = new JLabel("component 2");
        component2.setBackground(Color.GREEN);
        component2.setOpaque(true);

        JLabel component3 = new JLabel("component 3");
        component3.setBackground(Color.ORANGE);
        component3.setOpaque(true);

        component4 = new JLabel("component 4");
        component4.setBackground(Color.CYAN);
        component4.setOpaque(true);

        JLabel component5 = new JLabel("component 5");
        component5.setBackground(Color.WHITE);
        component5.setOpaque(true);
        
        this.add(component1,"width 70%");
        this.add(component2,"grow");
        this.add(component3);
        this.add(component4);
        this.add(component5,"span 2, width 100%");
    }
}
