/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userprofilebuilder.view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import userprofilebuilder.controller.FileManager;
import userprofilebuilder.model.User;
import userprofilebuilder.model.UserGroup;


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
    private JFrame appFrame = new JFrame();

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
    public JFrame getAppFrame() {
        return appFrame;
    }

    public void setAppFrame(JFrame appFrame) {
        this.appFrame = appFrame;
    }

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
    
    public void myGui(ArrayList<User> myList, String fileName)
    {
        appFrame.setName("User Profile Builder");//give a name to the frame
        appFrame.setLayout(new BorderLayout());//set the layout to Border
        
        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem quit = new JMenuItem("Quit");
        
        quit.addActionListener(new menuAction());
        quit.setActionCommand("quit");
        
        open.addActionListener(new menuAction());
        open.setActionCommand("open");
        
        save.addActionListener(new menuAction());
        save.setActionCommand("save");
        
        menu.add(file);
        file.add(open);
        file.add(save);
        file.add(quit);
        
        appFrame.add(menu, BorderLayout.PAGE_START);
        
        panelBuilder builder = new panelBuilder();
        
        builder.borderSetUp(namePan, "User Name");
        builder.borderSetUp(titlePan, "Title");
        builder.borderSetUp(emailPan, "Email");
        
        builder.panSetUp(titlePan, "title", myList, fileName);
        builder.panSetUp(namePan, "fullName", myList, fileName);
        builder.panSetUp(emailPan, "email", myList, fileName);
    
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
    
    private class menuAction implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getActionCommand().equals("open"))
            {
                JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir")); //opens a file chooser to the project directory
                int open = fileChooser.showOpenDialog(new JFrame()); //shows 1 on cancel and 0 on opening a file
                if(open == 0)
                {
                    File file = fileChooser.getSelectedFile();//gets the selected file and stores it
                    //System.out.println(file);
                    UserGroup uGroup = UserGroup.getInstance();
                    uGroup.getUserGroup().clear();//clear array
                    FileManager fileManager = new FileManager();
                    fileManager.fileInitialiser(file.getName());//populate array with content of selected file
                    //System.out.println("The new array consists of " + uGroup.getUserGroup());
                    MainViewer view = MainViewer.getInstance();
                    
                    view.getTitlePan().removeAll();
                    view.getNamePan().removeAll();
                    view.getEmailPan().removeAll();//remove each pan
                    
                    view.getAppFrame().getContentPane().removeAll();//remove all content from the view
                    
                    view.getAppFrame().revalidate();
                    view.getAppFrame().repaint();
                    view.myGui(uGroup.getUserGroup(), file.getName());//re populate the view with new content
                    
                }
                else
                {
                    System.out.println("Open file cancelled");
                }
                
                
            }
            
            else if (e.getActionCommand().equals("quit"))
            {
                System.exit(0); //exits app
            }
            
            else if (e.getActionCommand().equals("save"))
            {
                FileManager fileManager = new FileManager();
                String input = JOptionPane.showInputDialog("Enter the name of your new file");//displays an input window
                fileManager.fileSave(input);
            }
        }
        
    }
}
