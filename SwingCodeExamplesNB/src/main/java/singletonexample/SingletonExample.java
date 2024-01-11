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
public class SingletonExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // We are going to get our uniqueInstance of a Singleton object
        System.out.println("First call to get our uniqueInstance");
        MySingleton theOnlyOne = MySingleton.getInstance();
        System.out.println("Now I'm going to put some data in and it will be: theOnlyOne");
        theOnlyOne.setMyUniqueInstanceData("theOnlyOne");
       // now I am going to retrieve the data
       System.out.println("Now I want to get  my uniqueInstance again (I can get it from anywhere in my application)");
       
       MySingleton theOnlyOneAgain = MySingleton.getInstance();
       
       System.out.println("Let's see if it is the same object - what's the data?");
       
       System.out.println(theOnlyOneAgain.getMyUniqueInstanceData());
       
       System.out.println("Hey man it's the same object! That was easy :-) No more passing the object all over the place. Patterns rule!"); 
    }
    
}
