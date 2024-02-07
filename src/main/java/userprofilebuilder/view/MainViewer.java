/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userprofilebuilder.view;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import userprofilebuilder.model.User;


/**
 *
 * @author 
 * This might be useful for defining you Main App Viewer e.g. a JFrame
 */
public final class MainViewer extends JFrame
{
    private JPanel namePan = new JPanel();
    private JPanel titlePan = new JPanel();
    private JPanel emailPan = new JPanel(); 
    private JTabbedPane tabs = new JTabbedPane();

    //singleton + constructor
    
    private static MainViewer instance;
    private MainViewer(){}
    public static MainViewer getInstance()
    {
       if(instance == null)
       {
           instance = new MainViewer();
       }
       return instance;
    }
    
    //getters and setters

    public JPanel getNamePan() 
    {
        return namePan;
    }

    public void setNamePan(JPanel namePan) 
    {
        this.namePan = namePan;
    }

    public JPanel getTitlePan() 
    {
        return titlePan;
    }

    public void setTitlePan(JPanel titlePan) 
    {
        this.titlePan = titlePan;
    }

    public JPanel getEmailPan() 
    {
        return emailPan;
    }

    public void setEmailPan(JPanel emailPan) 
    {
        this.emailPan = emailPan;
    }
    
    public JTabbedPane getTabs() 
    {
        return tabs;
    }

    public void setTabs(JTabbedPane tabs) 
    {
        this.tabs = tabs;
    }

    //methods
    
    public void myGui(ArrayList<User> myList)
    {
        JFrame appFrame = new JFrame("User Profile Builder");//initialise the frame
        appFrame.setLayout(new BorderLayout());//set the layout to Border
        
        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem quit = new JMenuItem("Quit");
        
        menu.add(file);
        file.add(open);
        file.add(save);
        file.add(quit);
        
        appFrame.add(menu, BorderLayout.PAGE_START);
        
        panelBuilder builder = new panelBuilder();
        
        builder.borderSetUp(namePan, "User Name");
        builder.borderSetUp(titlePan, "Title");
        builder.borderSetUp(emailPan, "Email");
        
        builder.panSetUp(namePan, "fullName", myList);
        builder.panSetUp(titlePan, "title", myList);
        builder.panSetUp(emailPan, "email", myList);
    
        
        appFrame.add(namePan,BorderLayout.CENTER);//create a panel that goes in the center of the frame and has GridBagLayout
        appFrame.add(titlePan,BorderLayout.CENTER);//create a panel that goes in the center of the frame and has GridBagLayout
        appFrame.add(emailPan,BorderLayout.CENTER);//create a panel that goes in the center of the frame and has GridBagLayout
 
         
        
        
        tabs.addTab("User Title", titlePan);
        tabs.addTab("User Name", namePan);
        tabs.addTab("User Email", emailPan);
        appFrame.add(tabs); //tabbed pans, run app to see, added all 3 tabs
        
       
        
        appFrame.setSize(600,400);
        appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        appFrame.setVisible(true);//remeber to always set these attributes AT THE END or else app will not display

 
     
    }   
}
