package Items;

import Connection.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
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

@Named(value = "book")
@ManagedBean
@SessionScoped

public class Book {
    private String title;
    private String author;
    private String genre;
    
    private DBConnect dbConnect = new DBConnect();
    
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    
    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    
    public void createBook(int id) throws SQLException {
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement book = con.prepareStatement(
            "INSERT INTO books VALUES (?,?,?,?)");
        
        book.setInt(1, id);
        book.setString(2, title);
        book.setString(3, author);
        book.setString(4, genre);
        
        book.executeUpdate();
        statement.close();
        con.commit();
        con.close();
    }
}
