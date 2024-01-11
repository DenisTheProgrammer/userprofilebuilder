/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javateaching.basicgui;

import javateaching.leanconsole.LeanConsole;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author paul
 */
public class ComboLayout 
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Combo Layout");
        frame.setLayout(new BorderLayout());
        frame.add(new JButton("North"),BorderLayout.NORTH);
        frame.add(new JButton("South"),BorderLayout.SOUTH);
        frame.add(new JButton("East"),BorderLayout.EAST);
        frame.add(new JButton("West"),BorderLayout.WEST);

        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new GridLayout(2,2));
        middlePanel.add(new JButton("1"));
        middlePanel.add(new JButton("2"));
        middlePanel.add(new JButton("3"));
        //middlePanel.add(new JButton("4"));
        
        LeanConsole gc = new LeanConsole();
        middlePanel.add(gc);
        
        for (int i = 0; i < 100; i++)
        {
            gc.println("Hello from the console");
        }
        
        frame.add(middlePanel,BorderLayout.CENTER);

        frame.setSize(400,400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

