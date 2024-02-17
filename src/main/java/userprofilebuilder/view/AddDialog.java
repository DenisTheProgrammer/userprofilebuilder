/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userprofilebuilder.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ndeni
 */
public class AddDialog extends JDialog
{
    JDialog dialog = new JDialog(new JFrame(),"Dialog",true); 
    JPanel midPan = new JPanel();
    JPanel profilePan = new JPanel();
    JPanel titlePan = new JPanel();
    JPanel namePan = new JPanel();
    JPanel emailPan = new JPanel();
    
    public void initialiseDialog()
    {
        dialog.setLayout(new BorderLayout());
        midPan.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JLabel profile = new JLabel("Profile");
        JTextField profileInp = new JTextField("Enter your profile name");//you can use .getText() to get the input
        profilePan.add(profile);
        profilePan.add(profileInp);
        
        JLabel title = new JLabel("Title");
        JTextField titleInp = new JTextField("Enter your title");//you can use .getText() to get the input
        titlePan.add(title);
        titlePan.add(titleInp);
        
        JLabel fullName = new JLabel("Full Name");
        JTextField fullNameInp = new JTextField("Enter your name");//you can use .getText() to get the input
        namePan.add(fullName);
        namePan.add(fullNameInp);
        
        JLabel email = new JLabel("Email");
        JTextField emailInp = new JTextField("Enter your email");//you can use .getText() to get the input
        emailPan.add(email);
        emailPan.add(emailInp);
        
        dialog.add(midPan, BorderLayout.CENTER);
        
        midPan.add(profilePan, gbc);
        midPan.add(titlePan, gbc);
        midPan.add(namePan, gbc);
        midPan.add(emailPan, gbc);
               
        dialog.setSize(400,300);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
    
}
