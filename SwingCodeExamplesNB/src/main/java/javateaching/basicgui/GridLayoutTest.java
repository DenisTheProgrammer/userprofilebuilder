/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javateaching.basicgui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author paul
 */
public class GridLayoutTest 
{
    public static void main(String[] args)
    {
        JFrame window = new JFrame("Grid Layout Test");
        window.setLayout(new GridLayout(6,7));
        for (int row = 1; row <= 6; row++)
        {
            for (int col = 1; col <= 7; col++)
            {
                JButton cell = new JButton(col+","+row+" ");
                window.add(cell);
            }
        }
        window.pack();
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
