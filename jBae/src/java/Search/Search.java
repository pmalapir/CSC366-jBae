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
import java.util.ArrayList;
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
    private String price_compare;
    private String seller = "";
    
    private ArrayList<Object> params;
    private double price;
    
    private DBConnect dbConnect = new DBConnect();

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getPrice_compare() {
        return price_compare;
    }

    public void setPrice_compare(String price_compare) {
        this.price_compare = price_compare;
    }
    
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
    public void fillCategories(Listing listing) throws SQLException {
        switch (listing.getCategory()) {
            case "Auto":
                Car car = getCar(); 
                if(car.getMake() != null && !car.getMake().isEmpty())
                {
                    search_input += "   AND LOWER(autos.make) LIKE ?\n";
                    params.add((String) "%" + car.getMake().toLowerCase() + "%");
                }
                if(car.getModel()!= null && !car.getModel().isEmpty())
                {
                    search_input += "   AND LOWER(autos.model) LIKE ?\n";
                    params.add((String) "%" + car.getModel().toLowerCase() + "%");
                }
                if(car.getYear()!= 0)
                {
                    search_input += "   AND autos.year = ?";
                    params.add((Integer) car.getYear());
                }
                break;
                
            case "Book":
                Book book = getBook(); 
                if(book.getTitle()!= null && !book.getTitle().isEmpty())
                {
                    search_input += "   AND LOWER(books.title) LIKE ?\n";
                    params.add((String) "%" + book.getTitle().toLowerCase() + "%");
                }
                if(book.getAuthor()!= null && !book.getAuthor().isEmpty())
                {
                    search_input += "   AND LOWER(books.author) LIKE ?\n";
                    params.add((String) "%" + book.getAuthor().toLowerCase() + "%");
                }
                if(book.getGenre() != null && !book.getGenre().isEmpty())
                {
                    search_input += "   AND LOWER(books.genre) LIKE ?";
                    params.add((String) "%" + book.getGenre().toLowerCase() + "%");
                }
                break;
                
            case "Shoe":
                Shoe shoe = getShoe(); 
                if(shoe.getModel() != null && !shoe.getModel().isEmpty())
                {
                    search_input += "   AND LOWER(shoes.model) LIKE ?\n";
                    params.add((String) "%" + shoe.getModel().toLowerCase() + "%");
                }
                if(shoe.getBrand()!= null && !shoe.getBrand().isEmpty())
                {
                    search_input += "   AND LOWER(shoes.brand) LIKE ?\n";
                    params.add((String) "%" + shoe.getBrand().toLowerCase() + "%");
                }
                if(shoe.getSize() != 0)
                {
                    search_input += "   AND shoes.year = ?";
                    params.add((Integer) shoe.getSize());
                }
                break;
            case "Video Game":
                Videogame videogame = getVideogame(); 
                if(videogame.getTitle() != null && !videogame.getTitle().isEmpty())
                {
                    search_input += "   AND LOWER(video_games.title) LIKE ?\n";
                    params.add((String) "%" + videogame.getTitle().toLowerCase() + "%");
                }
                if(videogame.getGenre() != null && !videogame.getGenre().isEmpty())
                {
                    search_input += "   AND LOWER(video_games.genre) LIKE ?\n";
                    params.add((String) "%" + videogame.getGenre().toLowerCase() + "%");
                }
                if(videogame.getRating() != 0)
                {
                    search_input += "   AND video_games.rating = ?";
                    params.add((Integer) videogame.getRating());
                }
                break;
            default:
                break;
        }
    }
    public void build_search_query(Listing listing) throws SQLException {        
        search_input = "SELECT *\n" +
                    "   FROM listings INNER JOIN items ON listings.listing_id = items.item_id\n";
 
        switch (listing.getCategory()) {
            case "Auto":
                search_input += "   INNER JOIN autos ON autos.item_id = items.item_id\n";
                break;
            case "Book":
                search_input += "   INNER JOIN books ON books.item_id = items.item_id\n";
                break;
            case "Shoe":
                search_input += "   INNER JOIN shoes ON shoes.item_id = items.item_id\n";
                break;
            case "Video Game":
                search_input += "   INNER JOIN video_games ON video_games.item_id = items.item_id\n";
                break;
            default:
                break;
        }
        
        search_input += "   WHERE status = 'active'\n";
        
        if(price != 0)
        {
            if(price_compare.equals("greater"))
                search_input += "   AND price >= ?\n";
            else
                search_input += "   AND price <= ?\n";
            params.add((Double) price);
        }
        
        if(seller != null && !seller.equals(""))
        {
            search_input += "   AND LOWER(seller) LIKE ?\n";
            params.add((String) "%" + seller.toLowerCase() + "%");
        }
        
        fillCategories(listing);
        System.out.println(search_input);
    }
    
    public String advance_search() throws SQLException {
        Listing listing = getListing();
        params = new ArrayList<>();
        
        build_search_query(listing);
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement advance_search = con.prepareStatement(search_input);
        
        int index = 1;
        for(Object param : params)
        {
            if(param instanceof Double)
                advance_search.setDouble(index, (Double) param);
            
            else if(param instanceof Integer)
                advance_search.setInt(index, (Integer) param);
            
            else if(param instanceof String)
                advance_search.setString(index, (String) param);
            
            index++;
        }
        ResultSet rs = advance_search.executeQuery();
        ArrayListings arrayListings = getArrayListing();
        
        arrayListings.generateGeneric(rs);
        
        statement.close();
        con.commit();
        con.close();
        
        return "SearchResult";
    }
}
