
import java.sql.Connection;
import java.sql.SQLException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author derek
 */
public class Login {
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
    
    public void validateUsr(FacesContext context, 
                            UIComponent component, 
                            Object value) 
            throws ValidatorException, SQLException {
    // this functions validates username and login
    // does not return anything but will throw an exception if the user
    // uses an incorrect login
    // the exception will print an error message on the page definded by validator message
        Connection con = dbConnect.getConnection();
        
        if(con == null) {
            throw new SQLException("Can't get database connection");
        }
        con.setAutoCommit(false);
    // SQL CODE TO VALIDATE LOGIN
    }
}
