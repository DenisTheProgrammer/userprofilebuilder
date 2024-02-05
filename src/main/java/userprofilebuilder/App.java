/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package userprofilebuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import userprofilebuilder.controller.FileManager;
import userprofilebuilder.model.User;
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
        fileManager.fileInitialiser();

        //System.out.println(uGroup.getUserGroup()); //show me the ArrayList
        
        MainViewer showGUI = MainViewer.getInstance();
        showGUI.myGui(uGroup.getUserGroup());//initialise and show GUI + pass ArrayList
        	  	  		      	    	        	         
    }
    
}
