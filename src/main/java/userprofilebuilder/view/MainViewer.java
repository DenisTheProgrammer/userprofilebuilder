/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userprofilebuilder.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import userprofilebuilder.model.User;


/**
 *
 * @author 
 * This might be useful for defining you Main App Viewer e.g. a JFrame
 */
public class MainViewer extends JFrame implements ActionListener
{
    private JPanel namePan = new JPanel();
    private JPanel titlePan = new JPanel();
    private JPanel emailPan = new JPanel();
    private ButtonGroup radButOns = new ButtonGroup();
    
    
    //getters and setters

    public JPanel getNamePan() {
        return namePan;
    }

    public void setNamePan(JPanel namePan) {
        this.namePan = namePan;
    }

    public JPanel getTitlePan() {
        return titlePan;
    }

    public void setTitlePan(JPanel titlePan) {
        this.titlePan = titlePan;
    }

    public JPanel getEmailPan() {
        return emailPan;
    }

    public void setEmailPan(JPanel emailPan) {
        this.emailPan = emailPan;
    }
    
    public ButtonGroup getRadButOns() {
        return radButOns;
    }

    public void setRadButOns(ButtonGroup radButOns) {
        this.radButOns = radButOns;
    }
    
    //methods
    
    
    public void myGui(ArrayList<User> myList)
    {
        JFrame appFrame = new JFrame("User Profile Builder");//initialise the frame
        appFrame.setLayout(new BorderLayout());//set the layout to Border
        
        /*JPanel topPan = new JPanel();
        appFrame.add(topPan);*/
  
        
        namePan.setLayout(new GridBagLayout());
        appFrame.add(namePan,BorderLayout.CENTER);//create a panel that goes in the center of the frame and has GridBagLayout
        
        titlePan.setLayout(new GridBagLayout());
        appFrame.add(titlePan,BorderLayout.CENTER);//create a panel that goes in the center of the frame and has GridBagLayout
         
        emailPan.setLayout(new GridBagLayout());
        appFrame.add(emailPan,BorderLayout.CENTER);//create a panel that goes in the center of the frame and has GridBagLayout
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(20, 20, 20, 20); // these are the constraints for grid bag layout - play with in the future 
        
        Border border = BorderFactory.createTitledBorder("Name");
        namePan.setBorder(border);//this is how you set a titled border and add it to a panel or maybe even a frame
        
        Border border2 = BorderFactory.createTitledBorder("Title");
        titlePan.setBorder(border2);//this is how you set a titled border and add it to a panel or maybe even a frame
        
        Border border3 = BorderFactory.createTitledBorder("Email");
        emailPan.setBorder(border3);//this is how you set a titled border and add it to a panel or maybe even a frame
        
   
        
              
        for(int i = 0; i < myList.size();i++)
        {
            JPanel butPanel = new JPanel();//create a pannel per button
            JRadioButton selButton = new JRadioButton(String.valueOf(myList.get(i).getFullName()));
            JButton editButton = new JButton("Edit");
            JButton delButton = new JButton("Delete");//create the buttons
            butPanel.add(selButton);
            butPanel.add(editButton);
            butPanel.add(delButton);//add the buttons to the panel
            radButOns.add(selButton);//add the buttons to a group to make it easied for layout purposes(future)
            namePan.add(butPanel,gbc);//add the new pannel to the existing panel
        }
        
        
        for(int i = 0; i < myList.size();i++)
        {
            JPanel butPanel = new JPanel();//create a pannel per button
            JRadioButton selButton = new JRadioButton(String.valueOf(myList.get(i).getUserTitle()));
            JButton editButton = new JButton("Edit");
            JButton delButton = new JButton("Delete");//create the buttons
            butPanel.add(selButton);
            butPanel.add(editButton);
            butPanel.add(delButton);//add the buttons to the panel
            radButOns.add(selButton);//add the buttons to a group to make it easied for layout purposes(future)
            titlePan.add(butPanel,gbc);//add the new pannel to the existing panel
        }    
        
        
        for(int i = 0; i < myList.size();i++)
        {
            JPanel butPanel = new JPanel();//create a pannel per button
            JRadioButton selButton = new JRadioButton(String.valueOf(myList.get(i).getUserEmail()));
            JButton editButton = new JButton("Edit");
            JButton delButton = new JButton("Delete");//create the buttons
            butPanel.add(selButton);
            butPanel.add(editButton);
            butPanel.add(delButton);//add the buttons to the panel
            radButOns.add(selButton);//add the buttons to a group to make it easied for layout purposes(future)
            emailPan.add(butPanel,gbc);//add the new pannel to the existing panel
        }    
         
        
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Title", titlePan);
        tabs.addTab("User Name", namePan);
        tabs.addTab("Email", emailPan);
        appFrame.add(tabs, BorderLayout.PAGE_START); //tabbed pans, run app to see, added all 3 tabs
        
       
        
        appFrame.setSize(600,400);
        appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        appFrame.setVisible(true);//remeber to always set these attributes AT THE END or else app will not display

 
     
    }
    
       @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
    
}
