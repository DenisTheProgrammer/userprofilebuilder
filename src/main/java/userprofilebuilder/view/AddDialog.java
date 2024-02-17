/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userprofilebuilder.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import userprofilebuilder.model.User;
import userprofilebuilder.model.UserGroup;

/**
 *
 * @author ndeni
 */
public class AddDialog extends JDialog
{
    private JDialog dialog = new JDialog(new JFrame(),"Enter New User",true); 
    private JPanel midPan = new JPanel();
    private JPanel profilePan = new JPanel();
    private JPanel titlePan = new JPanel();
    private JPanel namePan = new JPanel();
    private JPanel emailPan = new JPanel();
    private JPanel endPan = new JPanel();
    
    private String profileStr;
    private String titleStr;
    private String fullNameStr;
    private String emailStr;
    
    public AddDialog()
    {
        dialog.setLayout(new BorderLayout());
        midPan.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JLabel profile = new JLabel("Profile");
        JTextField profileInp = new JTextField();//you can use .getText() to get the input
        profileInp.setPreferredSize(new Dimension(100,20));
        profileStr = profileInp.getText();
        profilePan.add(profile);
        profilePan.add(profileInp);
        
        JLabel title = new JLabel("Title");
        JTextField titleInp = new JTextField();//you can use .getText() to get the input
        titleInp.setPreferredSize(new Dimension(100,20));
        titleStr = titleInp.getText();
        titlePan.add(title);
        titlePan.add(titleInp);
        
        JLabel fullName = new JLabel("Full Name");
        JTextField fullNameInp = new JTextField();//you can use .getText() to get the input
        fullNameInp.setPreferredSize(new Dimension(100,20));
        fullNameStr = fullNameInp.getText();
        namePan.add(fullName);
        namePan.add(fullNameInp);
        
        JLabel email = new JLabel("Email");
        JTextField emailInp = new JTextField();//you can use .getText() to get the input
        emailInp.setPreferredSize(new Dimension(100,20));
        emailStr = emailInp.getText();
        emailPan.add(email);
        emailPan.add(emailInp);
        
        JButton ok = new JButton("OK");
        ok.addActionListener(new DialogListener());
        ok.setActionCommand("ok");
        
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new DialogListener());
        cancel.setActionCommand("cancel");
        
        endPan.add(ok);
        endPan.add(cancel);
        
        dialog.add(midPan, BorderLayout.CENTER);
        dialog.add(endPan, BorderLayout.PAGE_END);
        
        midPan.add(profilePan, gbc);
        midPan.add(titlePan, gbc);
        midPan.add(namePan, gbc);
        midPan.add(emailPan, gbc);
               
        dialog.setSize(400,300);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
    
    private class DialogListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if (e.getActionCommand().equals("cancel"))
            {
                dialog.dispose();
            }
            
            else if(e.getActionCommand().equals("ok"))
            {
                UserGroup uGroup = UserGroup.getInstance();
                User u = new User(profileStr, titleStr, fullNameStr, emailStr);
                uGroup.addToUserGroup(u);
                System.out.println("the updated user group now contains " + uGroup.getUserGroup());
            }
        }
        
    }
    
}
