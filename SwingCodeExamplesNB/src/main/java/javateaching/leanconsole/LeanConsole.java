/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javateaching.leanconsole;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author paul
 */
public class LeanConsole extends JPanel
{
    private JTextArea textarea = new JTextArea();
    
    public LeanConsole()
    {
        this.setLayout(new BorderLayout());
        JScrollPane scroll = new JScrollPane(textarea);
        this.add(scroll,BorderLayout.CENTER);
        textarea.setLineWrap(true); // otherwise everything is on one line
        textarea.setEditable(false); // otherwise people can type over the text
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
    
    public void clear()
    {
        this.getTextarea().setText("");
    }

    public JTextArea getTextarea() {
        return textarea;
    }   
}

