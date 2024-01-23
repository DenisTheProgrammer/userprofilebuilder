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
        JFrame appFrame = new JFrame("User Profile Builder");
        appFrame.setLayout(new BorderLayout());
        
        /*JPanel topPan = new JPanel();
        appFrame.add(topPan);*/

        
        JTabbedPane tabs = new JTabbedPane();
        tabs.add("User Name", rootPane);
        appFrame.add(tabs, BorderLayout.PAGE_START);
        
        
        JPanel midPan = new JPanel();
        midPan.setLayout(new GridBagLayout());
        appFrame.add(midPan, BorderLayout.CENTER);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        Border border = BorderFactory.createTitledBorder("Name");
        midPan.setBorder(border);
        
        
       
        
        
        ButtonGroup radButOns = new ButtonGroup();
              
        for(int i = 0; i < myList.size();i++)
        {
            JPanel butPanel = new JPanel();
            JRadioButton selButton = new JRadioButton(String.valueOf(myList.get(i)));
            JButton editButton = new JButton("Edit");
            JButton delButton = new JButton("Delete");
            butPanel.add(selButton);
            butPanel.add(editButton);
            butPanel.add(delButton);
            radButOns.add(selButton);
            midPan.add(butPanel,gbc);
        }      
        
        appFrame.setSize(600,400);
        appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        appFrame.setVisible(true);
        
 
        
    }
    
    
    
}
