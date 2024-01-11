/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonexample;

import java.util.ArrayList;

/**
 *
 * @author localadmin
 */
public class MySingleton {
       // this is the static attribute which contains the only object of this 
       // example class. being static it won't get swept up by the garbage collector
       // it is null before the constructor is called
    	private static MySingleton uniqueInstance;
        
	// instance variables here 
        // some data for our unique instance object to show you can use it 
        // to get model data in this case just Strings empty at first but it could be 
        // Collections of objects or anything
        private String myUniqueInstanceData;
       
 
        // this is the way of getting the unique instance 
        // printlines have been put in to show how it works
	public static MySingleton getInstance() {
		if (uniqueInstance == null) {
                        System.out.println("The uniqueInstance is null.");
                        System.out.println("Call the constructor");
			uniqueInstance = new MySingleton();
		}
                System.out.println("We have a uniqueInstance so return it");
		return uniqueInstance;
	}
        
        // the private constructor
        private MySingleton() {
        // a print line just to show when the constructor is called 
        // it is a private constructor and can only be called from the getInstance method
          System.out.println("Creating our uniqueInstance");
        }
        
	// other useful methods here

        // getters and setters for whatever data we have in our uniqueInstance
    public String getMyUniqueInstanceData() {
        return myUniqueInstanceData;
    }

    public void setMyUniqueInstanceData(String myUniqueInstanceData) {
        this.myUniqueInstanceData = myUniqueInstanceData;
    }
        
}
