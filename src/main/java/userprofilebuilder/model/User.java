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
    private String userNumber;
    private String userTitle;
    private String fullName;
    private String userEmail;
  
    //constructor
    
    public User(String userNumber, String userTitle, String fullName, String userEmail)
    {
        this.userNumber = userNumber;
        this.userTitle = userTitle;
        this.fullName = fullName;
        this.userEmail = userEmail;
    }

    //getters and setters

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() //to string to display them when asking for array list
    {
        return this.getUserNumber() + " " + this.getUserTitle() + " " + this.getFullName() + " " + this.getUserEmail();
    }
    
    
}
