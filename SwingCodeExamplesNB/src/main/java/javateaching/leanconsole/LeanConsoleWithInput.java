/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javateaching.leanconsole;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author paul
 */
public class LeanConsoleWithInput extends JPanel
{
    private JTextArea textarea = new JTextArea();
    private JTextField inputfield = new JTextField();
    
    private boolean returnPressed = false;
    
    public LeanConsoleWithInput()
    {
        this.setLayout(new BorderLayout());
        JScrollPane scroll = new JScrollPane(textarea);
        this.add(scroll,BorderLayout.CENTER);
        textarea.setLineWrap(true); // otherwise everything is on one line
        textarea.setEditable(false); // otherwise people can type over the text
        // add input field at bottom
        this.add(inputfield,BorderLayout.SOUTH);
        inputfield.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                // while it might seem more natural to hook keyTyped,
                // apparently getKeyCode only returns values for
                // keyPressed and keyReleased.
                if (e.getKeyCode() == KeyEvent.VK_ENTER) returnPressed = true;
            }        
        });
    }
    
    public void print(String text)
    {
        String currentText = this.getTextarea().getText();
        currentText += text;
        this.getTextarea().setText(currentText);
        this.getTextarea().setCaretPosition(this.getTextarea().getDocument().getLength());
    }
    
    public void println(String text)
    {
        this.print(text+System.getProperty("line.separator"));
    }
    
    public String readln()
    {
        // clear any existing text
        inputfield.setText("");
        // put the cursor in the input field
        inputfield.requestFocusInWindow();
        this.returnPressed = false;
        
        // returnPressed is going to get set when the
        // user presses return on the KeyListener for
        // the input field. We wait until it is...
        while (!this.returnPressed)
        {
            // add in a brief pause to processing. Otherwise this loop would
            // peg the CPU at 100%
            try { Thread.sleep(200); } catch (InterruptedException ex) {}
        }
        String result = inputfield.getText();
        // we've pressed return, so clear the field
        inputfield.setText("");
        this.returnPressed = false;
        return result;        
    }
    
    public void clear()
    {
        this.getTextarea().setText("");
    }

    public JTextArea getTextarea() {
        return textarea;
    }   
}

