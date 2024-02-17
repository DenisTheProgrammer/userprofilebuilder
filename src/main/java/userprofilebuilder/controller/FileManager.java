/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userprofilebuilder.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import userprofilebuilder.model.User;
import userprofilebuilder.model.UserGroup;

/**
 *
 * @author ndeni
 */
public class FileManager 
{
    public void fileInitialiser(String fileName)
    {
        UserGroup uGroup = UserGroup.getInstance();
        try //this reads the file and makes objects based on it
                (
                FileReader file = new FileReader(fileName);
                BufferedReader b = new BufferedReader(file); //initialise file and buffered reader
                )
                {    
                    String line;
   
                    while ((line = b.readLine()) != null)
                    {
                    String[] details = line.split(",");
                    //System.out.println(details[2]);
                    User u = new User(details[0], details[1], details[2], details[3]);
                    uGroup.addToUserGroup(u); //new object users in then add each user to ArrayList
                    }      
            
                }
                
                catch(Exception d)
                {
                    d.printStackTrace();
                } 
    }
    
    
    
    public void tempCreator(String fileName, String change, String comparator, String choice)
    {
        if (choice.equals("modify"))
        {
            try //this will be used to create a new temporary file where the modified content is written
                (
                    FileReader file = new FileReader(fileName);
                    BufferedReader b = new BufferedReader(file); //initialise file and buffered reader
                    FileWriter myFile = new FileWriter("temp.csv");
                    BufferedWriter writer = new BufferedWriter(myFile);
                )
                {    
                    String line;
   
                   while ((line = b.readLine()) != null)
                    {
                        String[] details = line.split(",");
                        for(int i = 0; i < details.length; i ++)
                        {
                            if(!(change.equals(comparator)))
                            {
                               if (comparator.equals(details[i]))
                               {
                                   if(i == (details.length - 1))
                                    {
                                        writer.write(change); 
                                        break;
                                    }
                        
                                    else
                                    {
                                        writer.write(change + ","); 
                                        i++;
                                    }
                               }
                            }
                            
                           
                            if(i == (details.length - 1))
                            {
                                writer.write(details[i]);  
                            }
                        
                            else
                            {   
                                writer.write(details[i]+","); 
                            }  
                            
                        }
                    
                        writer.newLine();
                    }                      
                     
                }
                catch(Exception s)
                {
                    s.printStackTrace();
                }
        }
        
        else if(choice.equals("delete"))
        {
       
       
            try(    FileReader file = new FileReader(fileName); //this block deletes one user from the file
                    BufferedReader b = new BufferedReader(file); //initialise file and buffered reader
                    FileWriter myFile = new FileWriter("temp.csv");
                    BufferedWriter writer = new BufferedWriter(myFile);)
            {
                String line;
   
                while ((line = b.readLine()) != null)
                {
                    String decision = "";
                    String[] words = line.split(",");
                    
                    for (int i = 0; i < words.length; i++)
                    {
                        if(change.equals(words[i]))
                        {
                            decision = "delete";
                            break;
                        }
                    }
                    
                    System.out.println(decision);
                    
                    if (decision.equals("delete"))
                    {
                        continue;
                    }
                    else
                    {
                        for (int j = 0; j < words.length; j++)
                        {
                            if(j == (words.length - 1))
                            {
                                writer.write(words[j]); 
                            }
                        
                            else
                            {   
                                writer.write(words[j]+","); 
                            } 
                        }
                    } 
                 writer.newLine();           
                }
           
            }
       
            catch(Exception b)
            {
                b.printStackTrace();
            }
        }
        
        else
        {
            System.out.println("You have entered the wrong String for your choise parameter");
        }
       
       
    }
    
    public void overwriterFromTemp(String fileName)
    {
       try //this writes the content of the temporary file inside the main file
                (
                    FileReader temp = new FileReader("temp.csv");
                    BufferedReader t = new BufferedReader(temp); //initialise file and buffered reader
                    FileWriter userProfile = new FileWriter(fileName);
                    BufferedWriter user = new BufferedWriter(userProfile);
                )
                {

                    String replace;
                    while((replace = t.readLine()) != null)
                    {
                        String[] words = replace.split(",");
                        for(int i = 0; i < words.length; i++)
                        {
                            if(i == (words.length - 1))
                            {
                                user.write(words[i]); 
                            }
                            else
                            {   
                                user.write(words[i] + ",");
                            }                
                        }
                        
                        user.newLine();
                    }
                }
                
                catch(Exception x)
                {
                    x.printStackTrace();
                } 
    }
    
    public void fileSave(String name)
    {
        try
        (
            FileWriter newFile = new FileWriter(name);
            BufferedWriter writer = new BufferedWriter(newFile); 
        )
        {
            UserGroup uGroup = UserGroup.getInstance();
            for(int i = 0; i < uGroup.getUserGroup().size(); i++)
            {
                writer.write(uGroup.getUserGroup().get(i).getUserNumber() + ",");
                writer.write(uGroup.getUserGroup().get(i).getUserTitle() + ",");
                writer.write(uGroup.getUserGroup().get(i).getFullName() + ",");
                writer.write(uGroup.getUserGroup().get(i).getUserEmail());
                writer.newLine();
            }
        }
        
        catch(Exception x)
        {
            x.printStackTrace();
        }
    }
    
    public void writeNewUserToTemp(String fileName,String userNumber, String userTitle, String userFullName, String userEmail)
    {
        try
        (
            FileReader file = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(file);
            FileWriter temp = new FileWriter("temp.csv");
            BufferedWriter writer = new BufferedWriter(temp);
        )
        {
            //read the file and re write its content + the nre user into temp
        }
        
        catch(Exception x)
        {
            x.printStackTrace();
        }
    }
    
}
