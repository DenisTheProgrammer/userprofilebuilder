/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userprofilebuilder.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import userprofilebuilder.model.User;

/**
 *
 * @author Denis
 */
public class panelBuilder {

  
    private ButtonGroup radButOns = new ButtonGroup();
    
    //getters and setters
    public ButtonGroup getRadButOns() {
        return radButOns;
    }

    public void setRadButOns(ButtonGroup radButOns) {
        this.radButOns = radButOns;
    }
    
    
    //methods
    public void borderSetUp(JPanel panel, String name)
    {
       Border border = BorderFactory.createTitledBorder(name);
       panel.setBorder(border);//this is how you set a titled border and add it to a panel
    }
    
    public void panSetUp(JPanel panel, String menu, ArrayList<User> userList)
    {
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(20, 20, 20, 20); // these are the constraints for grid bag layout - play with in the future 
        
        for(int i = 0; i < userList.size();i++)
        {
            if (menu.equals("fullName"))
            {
                JPanel butPanel = new JPanel();//create a pannel per button
                JRadioButton selButton = new JRadioButton(String.valueOf(userList.get(i).getFullName()));
                JButton editButton = new JButton("Edit");
                JButton delButton = new JButton("Delete");//create the buttons
                butPanel.add(selButton);
                butPanel.add(editButton);
                butPanel.add(delButton);//add the buttons to the panel
                radButOns.add(selButton);//add the buttons to a group to make it easied for layout purposes(future)
                panel.add(butPanel,gbc);//add the new pannel to the existing panel
            }
            
            if (menu.equals("title"))
            {
               JPanel butPanel = new JPanel();//create a pannel per button
                JRadioButton selButton = new JRadioButton(String.valueOf(userList.get(i).getUserTitle()));
                JButton editButton = new JButton("Edit");
                JButton delButton = new JButton("Delete");//create the buttons
                butPanel.add(selButton);
                butPanel.add(editButton);
                butPanel.add(delButton);//add the buttons to the panel
                radButOns.add(selButton);//add the buttons to a group to make it easied for layout purposes(future)
                panel.add(butPanel,gbc);//add the new pannel to the existing panel 
            }
            
            if(menu.equals("email"))
            {
                JPanel butPanel = new JPanel();//create a pannel per button
                JRadioButton selButton = new JRadioButton(String.valueOf(userList.get(i).getUserEmail()));
                JButton editButton = new JButton("Edit");
                JButton delButton = new JButton("Delete");//create the buttons
                butPanel.add(selButton);
                butPanel.add(editButton);
                butPanel.add(delButton);//add the buttons to the panel
                radButOns.add(selButton);//add the buttons to a group to make it easied for layout purposes(future)
                panel.add(butPanel,gbc);//add the new pannel to the existing panel
            }
        }
        
        
    }
    
}
