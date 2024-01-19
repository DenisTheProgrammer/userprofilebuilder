/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package userprofilebuilder;

import java.io.BufferedReader;
import java.io.FileReader;


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
            while (true)
            {
            String line = b.readLine();
            
            if (line == null)
            {
                break;
            }
            
            System.out.println(line);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
