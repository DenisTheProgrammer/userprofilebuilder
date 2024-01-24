/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userprofilebuilder.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
public class MainViewer extends JFrame 
{
    
    public void myGui(ArrayList<User> myList)
    {
        JFrame appFrame = new JFrame("User Profile Builder");//initialise the frame
        appFrame.setLayout(new BorderLayout());//set the layout to Border
        
        /*JPanel topPan = new JPanel();
        appFrame.add(topPan);*/

        
        JTabbedPane tabs = new JTabbedPane();
        tabs.add("User Name", rootPane);
        appFrame.add(tabs, BorderLayout.PAGE_START); //tabbed pans, run app to see, this is the top User Name one
        
        
        JPanel midPan = new JPanel();
        midPan.setLayout(new GridBagLayout());
        appFrame.add(midPan, BorderLayout.CENTER);//create a panel that goes in the center of the frame and has GridBagLayout
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(5, 5, 5, 5); // these are the constraints for grid bag layout - play with in the future 
                                                               //to keep building knowledge
        
        Border border = BorderFactory.createTitledBorder("Name");
        midPan.setBorder(border);//this is how you set a titled border and add it to a panel or maybe even a frame
        
   
        ButtonGroup radButOns = new ButtonGroup();
              
        for(int i = 0; i < myList.size();i++)
        {
            JPanel butPanel = new JPanel();//create a pannel per button
            JRadioButton selButton = new JRadioButton(String.valueOf(myList.get(i)));
            JButton editButton = new JButton("Edit");
            JButton delButton = new JButton("Delete");//create the buttons
            butPanel.add(selButton);
            butPanel.add(editButton);
            butPanel.add(delButton);//add the buttons to the panel
            radButOns.add(selButton);//add the buttons to a group to make it easied for layout purposes(future)
            midPan.add(butPanel,gbc);//add the new pannel to the existing panel
        }      
        
        appFrame.setSize(600,400);
        appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        appFrame.setVisible(true);//remeber to always set these attributes AT THE END or else app will not display
        
 
        
    }
    
    
    
}
