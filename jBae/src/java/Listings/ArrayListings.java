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

    private DBConnect dbConnect = new DBConnect();

    public ArrayList<Listing> getListings() throws SQLException {
        generateAll();
        return this.listings;
    }

    public void setListings(ArrayList<Listing> listings) {
        this.listings = listings;
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
            listing.setPrice(rs.getDouble("price"));
            listing.setTitle(rs.getString("title"));
            listing.setDescription(rs.getString("description"));
            listing.setPostDate(rs.getDate("post_date").toString());
            listing.setPostDate(rs.getDate("exp_date").toString());          
            listing.setSeller(rs.getString("seller"));
            listing.setImgSrc(rs.getString("image"));
            listing.setCategory(rs.getString("item_type"));
            listings.add(listing);
        }
        statement.close();
        con.commit();
        con.close();
    }
}
