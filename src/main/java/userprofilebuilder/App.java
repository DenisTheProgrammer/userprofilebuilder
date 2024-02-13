/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package userprofilebuilder;
import userprofilebuilder.controller.FileManager;
import userprofilebuilder.model.UserGroup;
import userprofilebuilder.view.MainViewer;


/**
 *
 * @author 
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // This is where your application will start
        UserGroup uGroup = UserGroup.getInstance();
        FileManager fileManager = new FileManager();
        fileManager.fileInitialiser("userprofile.csv");

        System.out.println(uGroup.getUserGroup()); //show me the ArrayList
        
        MainViewer showGUI = MainViewer.getInstance();
        showGUI.myGui(uGroup.getUserGroup(), "userprofile.csv");//initialise and show GUI + pass ArrayList
        	  	  		      	    	        	         
    }
    
}
