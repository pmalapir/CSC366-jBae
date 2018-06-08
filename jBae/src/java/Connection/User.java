package Connection;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patrick
 */

@Named(value = "user")
@ManagedBean
@SessionScoped

public class User implements Serializable {
    private boolean loggedIn;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private double wallet;
    private boolean admin;
    
    private UIInput passwordUI;
    
    private DBConnect dbConnect = new DBConnect();

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }

    public UIInput getPasswordUI() {
        return passwordUI;
    }

    public void setPasswordUI(UIInput passwordUI) {
        this.passwordUI = passwordUI;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public double getWallet(){
        return wallet;
    }
    public void setWallet(double wallet){
        this.wallet = wallet;
    }

    public boolean getAdmin(){
        return admin;
    }
    
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }   
    
    public void earn() {
        System.out.println("CASH:" + wallet + 1);
        this.wallet++;
    }
    public void validateUser(
            FacesContext context, 
            UIComponent component, 
            Object value) 
            throws ValidatorException, SQLException {
        
        Connection con = dbConnect.getConnection();

        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        PreparedStatement validate = con.prepareStatement(
            "SELECT username FROM users WHERE username = ?");
        
        validate.setString(1, value.toString());
        
        ResultSet rs = validate.executeQuery();
        
        if(rs.next())
        {
            FacesMessage errorMessage = new FacesMessage("Username taken");
            throw new ValidatorException(errorMessage);
        }
    }
    
    public void validatePass(
            FacesContext context, 
            UIComponent component, 
            Object value) 
            throws ValidatorException {
        
        password = passwordUI.getValue().toString();
        
        if(!password.equals(value.toString()))
        {
            FacesMessage errorMessage = new FacesMessage("Passwords do not match");
            throw new ValidatorException(errorMessage);
        }
    }
    
    public void registerUser() throws SQLException {
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement registerAccount = con.prepareStatement(
                "INSERT INTO users VALUES (?,?,?,?,?,?,?)");
        
        registerAccount.setString(1, username);
        registerAccount.setString(2, password);
        registerAccount.setString(3, firstName);
        registerAccount.setString(4, lastName);
        registerAccount.setString(5, email);
        registerAccount.setDouble(6, 100);
        registerAccount.setBoolean(7, false);
        
        registerAccount.executeUpdate();
        statement.close();
        con.commit();
        con.close();
    }
}
