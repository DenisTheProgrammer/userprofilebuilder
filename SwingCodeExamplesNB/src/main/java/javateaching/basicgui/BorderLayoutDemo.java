/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javateaching.basicgui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


/**
 *
 * @author paul
 */
public class BorderLayoutDemo 
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Border Layout");
        frame.setLayout(new BorderLayout());
        frame.add(new JButton("North"),BorderLayout.NORTH);
        frame.add(new JButton("South"),BorderLayout.SOUTH);
        frame.add(new JButton("East"),BorderLayout.EAST);
        frame.add(new JButton("West"),BorderLayout.WEST);
        frame.add(new JButton("Center"),BorderLayout.CENTER);
               
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

