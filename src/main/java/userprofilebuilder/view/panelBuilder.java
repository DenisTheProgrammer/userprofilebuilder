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
    private ArrayList<JRadioButton> radInd = new ArrayList<>();

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
    
    public ArrayList<JRadioButton> getRadInd() {
        return radInd;
    }

    public void setRadInd(ArrayList<JRadioButton> radInd) {
        this.radInd = radInd;
    }
    
    //methods
    public void borderSetUp(JPanel panel, String name)
    {
       Border border = BorderFactory.createTitledBorder(name);
       panel.setBorder(border);//this is how you set a titled border and add it to a panel
    }
    
    public void panSetUp(JPanel panel, String menu, ArrayList<User> userList, String fileName)
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
                radInd.add(selButton);
            }
            
            if (menu.equals("title"))
            {    
                selButton = new JRadioButton(String.valueOf(userList.get(i).getUserTitle()));
                radInd.add(selButton);
            }
            
            if(menu.equals("email"))
            {
                selButton = new JRadioButton(String.valueOf(userList.get(i).getUserEmail()));
                radInd.add(selButton);
            }
            
            JButton editButton = new JButton("Edit");//create the edit button
            JButton delButton = new JButton("Delete");//create the delete button
            
            editButton.addActionListener(new MyListener(selButton, fileName));//link the listener to the MyListener class
            editButton.setActionCommand("edit");//set command name
            
            delButton.addActionListener(new MyListener(selButton, fileName));//link the listener to the MyListener Class
            delButton.setActionCommand("delete");//set command name
            
            butPanel.add(selButton);
            butPanel.add(editButton);
            butPanel.add(delButton);//add the buttons to the panel
            
            radButOns.add(selButton);//add the buttons to a group to make it easier for layout purposes(future)
            panel.add(butPanel,gbc);//add the new pannel to the existing panel
        }  
    }
    
    public void endPanSetUp(JPanel panel)
    {
        JButton displayProfile = new JButton("Display Profile");
        panel.add(displayProfile);
        
        JButton addProfile = new JButton("Add Profile");
        panel.add(addProfile);
    }
    
    private class MyListener implements ActionListener //inner class to handle action listeners
    {
        private JRadioButton selButton;
        private String fileName;

        //getters and setters
        public String getFileName() {
            return fileName;
        }
        
        public void setFileName(String fileName) {        
            this.fileName = fileName;
        }

        public JRadioButton getSelButton() {
            return selButton;
        }

        public void setSelButton(JRadioButton selButton) {
            this.selButton = selButton;
        }
        
        //constructor
        public MyListener(JRadioButton selButton, String fileName)//constructor that takes a parameter, see edit button
        {
            this.selButton = selButton;
            this.fileName = fileName;
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
                fileManager.tempCreator(fileName, input, selButton.getText(),"modify"); //this function writes to the temporary file
                fileManager.overwriterFromTemp(fileName);

                selButton.setText(input);
                
                UserGroup uGroup = UserGroup.getInstance();//get the current instance of the user group
                uGroup.getUserGroup().clear();//clear the current ArrayList, getting it ready for an updated version 
                
                fileManager.fileInitialiser("userprofile.csv");
                
            }
            
            else if (e.getActionCommand().equals("delete"))
            {
                UserGroup uGroup = UserGroup.getInstance(); //get the current instance of UserGroup 
                FileManager fileManager = new FileManager();//create a new instance of our fresh class
                fileManager.tempCreator(fileName, selButton.getText(), "", "delete");//this function modifies the temp file, removing the user deleted
                fileManager.overwriterFromTemp(fileName);//this overwrites the userprofile.csv file
                uGroup.getUserGroup().clear();//clear the current ArrayList, getting it ready for an updated version 
                fileManager.fileInitialiser("userprofile.csv");//create the new version of the arrayList
                
                MainViewer app = MainViewer.getInstance();
                
                int index = getRadInd().indexOf(selButton);
                System.out.println(index);
                if(index > 5)
                {
                   app.getTitlePan().remove(butPanStorer.get(index - 6));
                   app.getNamePan().remove(butPanStorer.get(index - 3));
                   app.getEmailPan().remove(butPanStorer.get(index));
                }
                
                else if(index >2)
                {
                    app.getTitlePan().remove(butPanStorer.get(index - 3));
                    app.getNamePan().remove(butPanStorer.get(index));
                    app.getEmailPan().remove(butPanStorer.get(index + 3));
                }
                
                else
                {
                    app.getTitlePan().remove(butPanStorer.get(index));
                    app.getNamePan().remove(butPanStorer.get(index + 3));
                    app.getEmailPan().remove(butPanStorer.get(index + 6));
                }

                app.getTabs().revalidate();
                app.getTabs().repaint(); 
            }
            
        
        }
    }

  
    
}
