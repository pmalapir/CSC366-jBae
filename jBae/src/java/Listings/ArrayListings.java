/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listings;

import Connection.DBConnect;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named(value = "arrayListings")
@ManagedBean
@SessionScoped
public class ArrayListings implements Serializable {
    
    private ArrayList<Listing> listings;
    private ArrayList<Listing> shoeListings;
    private ArrayList<Listing> carListings;
    private ArrayList<Listing> videoGameListings;
    private ArrayList<Listing> bookListings;
    
    private DBConnect dbConnect = new DBConnect();

    public ArrayList<Listing> getListings() throws SQLException {
        generateAll();
        return this.listings;
    }

    public void setListings(ArrayList<Listing> listings) {
        this.listings = listings;
    }
    
    public ArrayList<Listing> getShoeListings() throws SQLException {
        generateShoes();
        return this.shoeListings;
    }

    public void setShoeListings(ArrayList<Listing> shoeListings) {
        this.shoeListings = shoeListings;
    }
    
    public ArrayList<Listing> getCarListings() throws SQLException {
        generateCars();
        return this.carListings;
    }
    
    public void setCarListings(ArrayList<Listing> carListings) {
        this.carListings = carListings;
    }
    
    public ArrayList<Listing> getVideoGameListings() throws SQLException {
        generateVideoGames();
        return this.videoGameListings;
    }
    
    public void setVideoGameListings(ArrayList<Listing> videoGameListings) {
        this.videoGameListings = videoGameListings;
    }
    
    public ArrayList<Listing> getBookListings() throws SQLException {
        generateBooks();
        return this.bookListings;
    }
    
    public void setBookListings(ArrayList<Listing> bookListings) {
        this.bookListings = bookListings;
    }
    
    public void generateAll() throws SQLException {
                
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement list = con.prepareStatement(
                "SELECT *\n" +
                "FROM listings INNER JOIN items on item = item_id\n" +
                "WHERE status = 'active'");
        
        ResultSet rs = list.executeQuery();
        listings = new ArrayList<>();

        while(rs.next())
        {
            Listing listing = new Listing();
            listing.setPrice(rs.getInt("price"));
            listing.setTitle(rs.getString("title"));
            listing.setDescription(rs.getString("description"));
            listing.setPostDate(rs.getDate("post_date").toString());
            listing.setExpirationDate(rs.getDate("exp_date").toString());          
            listing.setSeller(rs.getString("seller"));
            listing.setImgSrc(rs.getString("image"));
            listing.setCategory(rs.getString("item_type"));
            listings.add(listing);
        }
        statement.close();
        con.commit();
        con.close();
    }
    
     public void generateShoes() throws SQLException {
                
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement list = con.prepareStatement(
                "SELECT *\n" +
                "FROM listings INNER JOIN items on item = item_id\n" +
                "WHERE status = 'active'\n" +
                "AND item_type = 'shoes'");
        
        ResultSet rs = list.executeQuery();
        shoeListings = new ArrayList<>();

        while(rs.next())
        {
            Listing listing = new Listing();
            listing.setPrice(rs.getInt("price"));
            listing.setTitle(rs.getString("title"));
            listing.setDescription(rs.getString("description"));
            listing.setPostDate(rs.getDate("post_date").toString());
            listing.setExpirationDate(rs.getDate("exp_date").toString());          
            listing.setSeller(rs.getString("seller"));
            listing.setImgSrc(rs.getString("image"));
            listing.setCategory(rs.getString("item_type"));
            shoeListings.add(listing);
        }
        statement.close();
        con.commit();
        con.close();
    }
     
      public void generateVideoGames() throws SQLException {
                
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement list = con.prepareStatement(
                "SELECT *\n" +
                "FROM listings INNER JOIN items on item = item_id\n" +
                "WHERE status = 'active'" +
                "AND item_type = 'video games'");
        
        ResultSet rs = list.executeQuery();
        videoGameListings = new ArrayList<>();

        while(rs.next())
        {
            Listing listing = new Listing();
            listing.setPrice(rs.getInt("price"));
            listing.setTitle(rs.getString("title"));
            listing.setDescription(rs.getString("description"));
            listing.setPostDate(rs.getDate("post_date").toString());
            listing.setExpirationDate(rs.getDate("exp_date").toString());          
            listing.setSeller(rs.getString("seller"));
            listing.setImgSrc(rs.getString("image"));
            listing.setCategory(rs.getString("item_type"));
            videoGameListings.add(listing);
        }
        statement.close();
        con.commit();
        con.close();
    }
       public void generateCars() throws SQLException {
                
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement list = con.prepareStatement(
                "SELECT *\n" +
                "FROM listings INNER JOIN items on item = item_id\n" +
                "WHERE status = 'active'" +
                "AND item_type = 'autos'");
        
        ResultSet rs = list.executeQuery();
        carListings = new ArrayList<>();

        while(rs.next())
        {
            Listing listing = new Listing();
            listing.setPrice(rs.getInt("price"));
            listing.setTitle(rs.getString("title"));
            listing.setDescription(rs.getString("description"));
            listing.setPostDate(rs.getDate("post_date").toString());
            listing.setExpirationDate(rs.getDate("exp_date").toString());          
            listing.setSeller(rs.getString("seller"));
            listing.setImgSrc(rs.getString("image"));
            listing.setCategory(rs.getString("item_type"));
            carListings.add(listing);
        }
        statement.close();
        con.commit();
        con.close();
    }
        public void generateBooks() throws SQLException {
                
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement list = con.prepareStatement(
                "SELECT *\n" +
                "FROM listings INNER JOIN items on item = item_id\n" +
                "WHERE status = 'active'" +
                "AND item_type = 'books'");
        
        ResultSet rs = list.executeQuery();
        bookListings = new ArrayList<>();

        while(rs.next())
        {
            Listing listing = new Listing();
            listing.setPrice(rs.getInt("price"));
            listing.setTitle(rs.getString("title"));
            listing.setDescription(rs.getString("description"));
            listing.setPostDate(rs.getDate("post_date").toString());
            listing.setExpirationDate(rs.getDate("exp_date").toString());          
            listing.setSeller(rs.getString("seller"));
            listing.setImgSrc(rs.getString("image"));
            listing.setCategory(rs.getString("item_type"));
            bookListings.add(listing);
        }
        statement.close();
        con.commit();
        con.close();
    }
}
