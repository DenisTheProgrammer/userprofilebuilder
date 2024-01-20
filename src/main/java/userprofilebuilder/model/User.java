/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userprofilebuilder.model;

/**
 *
 * @author 
 * This is model class may be handy for putting data relevant to the User Profile in
 */
public class User 
{
    
    private String fullName;
    
    //constructor
    
    public User(String fullName)
    {
        this.fullName = fullName;
    }

    //getters and setters

    public String getFullName() {
        return fullName;  
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString()
    {
        return this.getFullName();
    }
    
    
}
