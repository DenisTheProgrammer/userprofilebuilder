/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javateaching.layoutmanagers;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 
 */
public class CombiningLayouts {
    public static void main(String[] args) {
JFrame frame = new JFrame();
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
middlePanel.add(new JButton("4"));
frame.add(middlePanel,BorderLayout.CENTER);

frame.setSize(400,400);
frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
}
