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
public final class UserGroup {
    private static UserGroup instance;
    private ArrayList<User> userGroup = new ArrayList<>();
    private UserGroup(){}//disable constructor to enforce singleton
    
    //singleton
    
    public static UserGroup getInstance()
    {
        if(instance == null)
        {
            instance = new UserGroup();
        }
        
        return instance;
    }
    //getters and setters

    public ArrayList<User> getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(ArrayList<User> userGroup) {
        this.userGroup = userGroup;
    }

    public void addToUserGroup(User u)
    {
        userGroup.add(u);
    }
    
}
