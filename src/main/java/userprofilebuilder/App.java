/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package userprofilebuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import userprofilebuilder.model.User;
import userprofilebuilder.model.UserGroup;


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
        
        try
            (
                FileReader file = new FileReader("username.csv");
                BufferedReader b = new BufferedReader(file);
                )
        {    
            String line;
            
            while ((line = b.readLine()) != null)
            {
        
            UserGroup uGroup = new UserGroup();
            
            User u = new User(line);
            uGroup.setUserGroup(  u);
            
            /*for(int i = 0; i < uGroup.getUserGroup().size(); i ++)
            {
                System.out.println(uGroup.getUserGroup().get(i));
            }*/
            
            System.out.println(uGroup.getUserGroup());
            
            }   
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }      
        	  	  		      	    	        	         
    }
    
}
