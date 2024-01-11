/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javateaching.basicgui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 *
 * @author paul
 */
public class LeanGui
{
    public static void main(String[] args) throws InterruptedException 
    {
        JFrame ourwindow = new JFrame("Yay! Window");
        ourwindow.setLayout(new BorderLayout());
        JTextArea text = new JTextArea();        
        text.setLineWrap(true); // otherwise everything is on one line
        text.setEditable(false); // otherwise people can type over the text
        ourwindow.add(text,BorderLayout.CENTER);        
        
        ourwindow.setSize(500,400);
        ourwindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ourwindow.setVisible(true);
        
        // the next code is to illustrate "printing"
        while (true) // repeat forever
        {
            String currentText = text.getText();
            currentText += "Hello! ";
            text.setText(currentText);
            Thread.sleep(10); // add a delay just so you can see it build up
        }
    }
}