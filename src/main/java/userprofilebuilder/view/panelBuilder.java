/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userprofilebuilder.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import userprofilebuilder.controller.FileManager;
import userprofilebuilder.model.User;
import userprofilebuilder.model.UserGroup;

/**
 *
 * @author Denis
 */
public class panelBuilder
{
    private ButtonGroup radButOns = new ButtonGroup();
    private ArrayList<JPanel> butPanStorer = new ArrayList<>();
    
    //getters and setters   
    public ButtonGroup getRadButOns() {
        return radButOns;
    }

    public void setRadButOns(ButtonGroup radButOns) {
        this.radButOns = radButOns;
    }
    
    public ArrayList<JPanel> getButPanStorer() {
        return butPanStorer;
    }

    public void setButPanStorer(ArrayList<JPanel> butPanStorer) {
        this.butPanStorer = butPanStorer;
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
            JPanel butPanel = new JPanel();//create a pannel per button
            butPanStorer.add(butPanel); //add the panel that holds the buttons to a list to not lose the reference
            JRadioButton selButton = null;//initiate selButton
            
            if (menu.equals("fullName"))
            {
                selButton = new JRadioButton(String.valueOf(userList.get(i).getFullName()));         
            }
            
            if (menu.equals("title"))
            {    
                selButton = new JRadioButton(String.valueOf(userList.get(i).getUserTitle()));
            }
            
            if(menu.equals("email"))
            {
                selButton = new JRadioButton(String.valueOf(userList.get(i).getUserEmail()));
            }
            
            JButton editButton = new JButton("Edit");//create the edit button
            JButton delButton = new JButton("Delete");//create the delete button
            
            editButton.addActionListener(new MyListener(selButton, editButton, delButton));//link the listener to the MyListener class
            editButton.setActionCommand("edit");//set command name
            
            delButton.addActionListener(new MyListener(selButton, editButton, delButton));//link the listener to the MyListener Class
            delButton.setActionCommand("delete");//set command name
            
            butPanel.add(selButton);
            butPanel.add(editButton);
            butPanel.add(delButton);//add the buttons to the panel
            
            radButOns.add(selButton);//add the buttons to a group to make it easied for layout purposes(future)
            panel.add(butPanel,gbc);//add the new pannel to the existing panel
        }
        
        
        
    }
    
    private class MyListener implements ActionListener //inner class to handle action listeners
    {
        private JRadioButton selButton;
        private JButton editButton;
        private JButton delButton;
        
        //getters and setters
        public JRadioButton getSelButton() {
            return selButton;
        }

        public void setSelButton(JRadioButton selButton) {
            this.selButton = selButton;
        }
        
        //constructors
        public MyListener(JRadioButton selButton, JButton editButton, JButton delButton)//constructor that takes a parameter, see edit button
        {
            this.selButton = selButton;
            this.editButton = editButton;
            this.delButton = delButton;
        }
        
        //methods
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if (e.getActionCommand().equals("edit"))//edit action handled
            {
                String input = JOptionPane.showInputDialog("Enter new text:",selButton.getText());//create a JOptionPane that allows user input
                                                                                                          //and displays the existing radio text
                //System.out.println(input);
                FileManager fileManager = new FileManager();
                fileManager.tempCreator(input, selButton.getText(),"modify"); //this function writes to the temporary file
                fileManager.overwriterFromTemp();

                selButton.setText(input);
                
                UserGroup uGroup = UserGroup.getInstance();//get the current instance of the user group
                uGroup.getUserGroup().clear();//clear the current ArrayList, getting it ready for an updated version 
                
                fileManager.fileInitialiser();
   
                    //MainViewer app = MainViewer.getInstance();
                    //app.validate();
                
            }
            
            else if (e.getActionCommand().equals("delete"))
            {
                UserGroup uGroup = UserGroup.getInstance(); //get the current instance of UserGroup
                /*System.out.println("Before " + uGroup.getUserGroup());
                for (int i = 0 ; i < uGroup.getUserGroup().size(); i++)//loop through all the elements inside the ArrayList
                {
                    if (uGroup.getUserGroup().get(i).getFullName().equals(selButton.getText()))//these if statements are used to figure out what type of attribute has been deleted
                    {
                        uGroup.getUserGroup().removeIf(obj -> obj.getFullName().equals(selButton.getText()));//this statement simply uses the type of attribute to delete the whole object
                    }
                    else if (uGroup.getUserGroup().get(i).getUserTitle().equals(selButton.getText()))
                    {
                        uGroup.getUserGroup().removeIf(obj -> obj.getUserTitle().equals(selButton.getText()));
                    }
                    else if (uGroup.getUserGroup().get(i).getUserEmail().equals(selButton.getText()))
                    {
                        uGroup.getUserGroup().removeIf(obj -> obj.getUserEmail().equals(selButton.getText()));
                    }
                }
                System.out.println("After " + uGroup.getUserGroup());*/
                FileManager fileManager = new FileManager();//create a new instance of our fresh class
                fileManager.tempCreator(selButton.getText(), "", "delete");//this function modifies the temp file, removing the user deleted
                fileManager.overwriterFromTemp();//this overwrites the userprofile.csv file
                uGroup.getUserGroup().clear();//clear the current ArrayList, getting it ready for an updated version 
                fileManager.fileInitialiser();//create the new version of the arrayList
                //System.out.println("After " + uGroup.getUserGroup());
                
                System.out.println("Here is the list of panels " + getButPanStorer());
                System.out.println("And the panel to remove is " + getButPanStorer().get(0));
                MainViewer app = MainViewer.getInstance();
                //app.remove(getButPanStorer().get(0));
                getButPanStorer().get(5).setVisible(false);
                //app.remove(editButton);
                //app.remove(delButton);
                app.revalidate();
                
            }
            
        
        }
    }

  
    
}
