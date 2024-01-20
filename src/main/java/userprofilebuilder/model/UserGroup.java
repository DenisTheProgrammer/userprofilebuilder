/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userprofilebuilder.model;

import java.util.ArrayList;

/**
 *
 * @author 
 * This is model class may be handy for putting data relevant groups of User Profiles in {many Users]
 */
public class UserGroup {
    ArrayList<User> userGroup = new ArrayList<>();
    private User[] users;
    //constructor
    
    /*public UserGroup(User[] users)
    {
       for(int i = 0; i < users.length; i++)
       {
           userGroup.add(users[i]);
       }
    }*/
    

    //getters and setters
    
    public ArrayList<User> getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(User user) {
        userGroup.add( user);
    }
}
