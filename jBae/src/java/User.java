/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patrick
 */
public class User {
    private String username;
    private String password;
    private int phone;
    private String address;
    private String firstName;
    private String lastName;
    private int wallet;
    private boolean admin;
    
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassowrd(String password){
        this.password = password;
    }
    
    public int getPhone(){
        return phone;
    }
    public void setPhone(int phone){
        this.phone = phone;
    }
    
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public int getWallet(){
        return wallet;
    }
    public void setWallet(int wallet){
        this.wallet = wallet;
    }

    public boolean getAdmin(){
        return admin;
    }
    public void setAdmin(boolean admin){
        this.admin = admin;
    }   
    
}
