package Connection;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.el.ELContext;
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
 * @author derek
 */
@Named(value = "login")
@ManagedBean
@SessionScoped

public class Login implements Serializable{
    private String username = "";
    private String password = "";

    private UIInput loginUI;
    
    private DBConnect dbConnect = new DBConnect();
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public UIInput getLoginUI() {
        return loginUI;
    }
    
    public void setLoginUI(UIInput loginUI) {
        this.loginUI = loginUI;
    }
    
    public void validateAcc(FacesContext context, 
                            UIComponent component, 
                            Object value) 
            throws ValidatorException, SQLException {
    // this functions validates username and login
    // does not return anything but will throw an exception if the user
    // uses an incorrect login
    // the exception will print an error message on the page definded by validator message
        System.out.println("ATTEMPT INTO ACCOUNT");
        String pass;
        
        Connection con = dbConnect.getConnection();
        
        if(con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        PreparedStatement validate = con.prepareStatement(
            "SELECT username, password FROM users WHERE username = ?");
        try {
            username = loginUI.getValue().toString();
            password = value.toString();
        }
        catch (NullPointerException e){
            FacesMessage errorMessage = new FacesMessage("Wrong login/password");
            throw new ValidatorException(errorMessage);
        }
        
        validate.setString(1, username);
        
        ResultSet rs = validate.executeQuery();
        
        if(rs.next())
        {
            pass = rs.getString("password");
            if(!password.equals(pass)) {     // password validates with login
                System.out.println("WRONG PASSWORD");
                FacesMessage errorMessage = new FacesMessage("Wrong login/password");
                throw new ValidatorException(errorMessage);
            }
        }
        else {
             System.out.println("WRONG PASSWORD!");
            FacesMessage errorMessage = new FacesMessage("Wrong login/password");
            throw new ValidatorException(errorMessage);
        }
        
    }
    
    public User getUser() {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        User user = (User) elContext.getELResolver().getValue(elContext, null, "user");
        return user;
    }
    
    public void login() throws SQLException {
        User user = getUser();
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement findUser = con.prepareStatement(
            "SELECT username, first_name, last_name, email, admin, wallet "
                    + "FROM users WHERE username = ?");
        
        findUser.setString(1, username);
        
        ResultSet rs = findUser.executeQuery();
        if(rs.next())
        {
            user.setData(rs);
        }
        statement.close();
        con.commit();
        con.close();
    }
    
    public void logout() throws SQLException {
        User user = getUser();
        user.setUserWallet();
        user.unsetData();
    }
}
