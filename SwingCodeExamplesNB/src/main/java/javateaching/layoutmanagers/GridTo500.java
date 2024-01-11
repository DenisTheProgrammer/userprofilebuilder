/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javateaching.layoutmanagers;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 
 */
public class GridTo500 extends JPanel {
    public GridTo500()
    {
        GridLayout gl = new GridLayout(0,15);
        this.setLayout(gl);

        for (int i = 1; i < 501; i++)
        {
            JLabel numberJL = new JLabel(String.valueOf(i+" "));
            numberJL.setOpaque(true);
            numberJL.setBackground(Color.getHSBColor(new Random().nextFloat(), 1.0F, 1.0F ));
            this.add(numberJL);
        }
        JButton button = new JButton("spling");
       // button.setActionCommand("abc");
       button.setActionCommand("clickme");
        button.addActionListener(Controller.getInstance());
        this.add(button);
    }
}
