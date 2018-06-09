/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Search;

import Connection.DBConnect;
import Connection.User;
import Items.Book;
import Items.Car;
import Items.Shoe;
import Items.Videogame;

import Listings.ArrayListings;
import Listings.Listing;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author derek
 */
@Named(value = "search")
@ManagedBean
@SessionScoped

public class Search implements Serializable {
    private String search_input;
    
    private double price;

    private DBConnect dbConnect = new DBConnect();
    
    public String getSearch_input() {
        return search_input;
    }

    public void setSearch_input(String search_input) {
        this.search_input = search_input;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public ArrayListings getArrayListing() throws SQLException {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        ArrayListings arrayListing = (ArrayListings) elContext.getELResolver().getValue(elContext, null, "arrayListings");
        return arrayListing;
    }
     
    public Listing getListing() throws SQLException {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        Listing listing = (Listing) elContext.getELResolver().getValue(elContext, null, "listing");
        return listing;
    }
    
    public String getUser() throws SQLException {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        User user = (User) elContext.getELResolver().getValue(elContext, null, "user");
        return user.getUsername();
    }
        
    public Book getBook() throws SQLException {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        Book book = (Book) elContext.getELResolver().getValue(elContext, null, "book");
        return book;
    }
    
    public Shoe getShoe() throws SQLException {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        Shoe shoe = (Shoe) elContext.getELResolver().getValue(elContext, null, "shoe");
        return shoe;
    }
        
    public Car getCar() throws SQLException {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        Car car = (Car) elContext.getELResolver().getValue(elContext, null, "car");
        return car;
    }
            
    public Videogame getVideogame() throws SQLException {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        Videogame videogame = (Videogame) elContext.getELResolver().getValue(elContext, null, "videogame");
        return videogame;
    }
    public String simple_search() throws SQLException {
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement simple_search = con.prepareStatement(
            "SELECT *\n" +
            "FROM listings INNER JOIN items ON item = item_id\n" +
            "   AND (LOWER(title) LIKE ? \n" +
            "       OR LOWER(seller) LIKE ? \n" +
            "       OR LOWER(item_type) LIKE ? \n" +
            "       OR LOWER(description) LIKE ? )");

        simple_search.setString(1, "%" + search_input.toLowerCase() + "%");
        simple_search.setString(2, "%" + search_input.toLowerCase() + "%");
        simple_search.setString(3, "%" + search_input.toLowerCase() + "%");
        simple_search.setString(4, "%" + search_input.toLowerCase() + "%");
        
        ResultSet rs = simple_search.executeQuery();
        ArrayListings arrayListings = getArrayListing();
        
        arrayListings.generateGeneric(rs);
        
        statement.close();
        con.commit();
        con.close();
        
        return "SearchResult";
    }
    public void build_search_query() {
        search_input = "";
        
        if(price != 0)
        {
            
        }
    }
    
    public String advance_search() throws SQLException {
        
        build_search_query();
        
        return "SearchResult";
    }
}
