package Items;
import Connection.DBConnect;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

@Named(value = "videogame")
@ManagedBean
@SessionScoped
public class Videogame implements Serializable {
    private int itemID;
    private String title;
    private int rating;
    private String genre;
    private DBConnect dbConnect = new DBConnect();
    
    public int getItemID(){
        return itemID;
    }
    public void setItemID(int itemID){
        this.itemID = itemID;
    }
    
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    
    public int getRating(){
        return rating;
    }
    public void setRating(int rating){
        this.rating = rating;
    }
    
    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    
    public void findVideogame(int listing_id) throws SQLException {
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement videomgame = con.prepareStatement(
            "SELECT *\n" +
            "FROM listings INNER JOIN items on item = items.item_id\n" +
            "INNER JOIN video_games on items.item_id = video_games.item_id\n" +
            "WHERE status = 'active' AND listing_id = ?");
        
        videomgame.setInt(1, listing_id);
        
        ResultSet rs = videomgame.executeQuery();
        if(rs.next()) {
            title = rs.getString("title");
            rating = rs.getInt("rating");
            genre = rs.getString("genre");
        }
        
        statement.close();
        con.commit();
        con.close();
    }
        
    public void createVideogame(int id) throws SQLException {
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement videogames = con.prepareStatement(
            "INSERT INTO video_games VALUES (?,?,?,?)");
        
        videogames.setInt(1, id);
        videogames.setString(2, title);
        videogames.setInt(3, rating);
        videogames.setString(4, genre);
        
        videogames.executeUpdate();
        statement.close();
        con.commit();
        con.close();
    }
}
