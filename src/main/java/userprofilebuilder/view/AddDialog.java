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
import userprofilebuilder.controller.FileManager;
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
    
    private JTextField profileInp = new JTextField();//you can use .getText() to get the input
    private JTextField titleInp = new JTextField();//you can use .getText() to get the input
    private JTextField fullNameInp = new JTextField();//you can use .getText() to get the input
    private JTextField emailInp = new JTextField();//you can use .getText() to get the input
    
    public AddDialog()
    {
        dialog.setLayout(new BorderLayout());
        midPan.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JLabel profile = new JLabel("Profile");
        profileInp.setPreferredSize(new Dimension(100,20));
        profilePan.add(profile);
        profilePan.add(profileInp);
        
        JLabel title = new JLabel("Title");
        titleInp.setPreferredSize(new Dimension(100,20));
        titlePan.add(title);
        titlePan.add(titleInp);
        
        JLabel fullName = new JLabel("Full Name");
        fullNameInp.setPreferredSize(new Dimension(100,20));
        namePan.add(fullName);
        namePan.add(fullNameInp);
        
        JLabel email = new JLabel("Email");
        emailInp.setPreferredSize(new Dimension(100,20));
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
                profileStr = profileInp.getText();
                titleStr = titleInp.getText();
                fullNameStr = fullNameInp.getText();
                emailStr = emailInp.getText();
                
                MainViewer view = MainViewer.getInstance();
                UserGroup uGroup = UserGroup.getInstance();
                System.out.println(profileStr);
                /*User u = new User(profileStr, titleStr, fullNameStr, emailStr);
                uGroup.addToUserGroup(u);
                System.out.println("the updated user group now contains " + uGroup.getUserGroup());*/
                FileManager fileManager = new FileManager();
                fileManager.writeNewUserToTemp(view.getOpenFile().getName(), profileStr, titleStr, fullNameStr, emailStr);
            }
        }
        
    }
    
}
