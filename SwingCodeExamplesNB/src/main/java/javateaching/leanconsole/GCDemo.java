/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javateaching.leanconsole;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author paul
 */
public class GCDemo 
{    
    public static void main(String[] args) throws InterruptedException
    {
        JFrame ourwindow = new JFrame("Yay! Window");
        ourwindow.setLayout(new BorderLayout());
        
        LeanConsoleWithInput console = new LeanConsoleWithInput();        
        ourwindow.add(console,BorderLayout.CENTER);        
        
        ourwindow.setSize(500,400);
        ourwindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ourwindow.setVisible(true);
        
        console.println("Hello everyone!");
        
        for (int i = 1; i <= 200; i++)
        {
            console.println("Hello times "+i);
        }
        
        console.println("What is your name?");
        String name = console.readln();
        console.println("Hello, "+name);
        console.println("*** end of program ***");
    }
}

