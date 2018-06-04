package Listings;

import Items.Book;
import Items.Car;
import Items.Shoe;
import Items.Videogame;
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

@Named(value = "auction")
@ManagedBean
@SessionScoped
public class Auction extends Listing{
    
    public void createAuctionListing(int listing_id) throws SQLException {
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement listing = con.prepareStatement(
                "INSERT INTO auction_listings VALUES(?)");
                
        listing.setInt(1, listing_id);

        listing.executeUpdate();
        statement.close();
        con.commit();
        con.close();
    }
    
    public void submitListing() throws SQLException {
        int item_id = createItem();
        
        switch (getCategory()) 
        {
            case "Books" :
                Book book = getBook();
                book.createBook(item_id);
                break;
            case "Cars" :
                Car car = getCar();
                car.createCar(item_id);
                break;
            case "Shoes" :
                Shoe shoe = getShoe();
                shoe.createShoe(item_id);
                break;
            case "Video Games" :
                Videogame videogame = getVideogame();
                videogame.createVideogame(item_id);
                break;
            default:
                System.out.println("no category selected");
                break;
        } 
        
        int listing_id = createListing(item_id);
        createAuctionListing(listing_id);
    }
}
