package Listings;

import Connection.DBConnect;
import Connection.User;
import Items.Book;
import Items.Car;
import Items.Shoe;
import Items.Videogame;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
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

@Named(value = "listing")
@ManagedBean
@SessionScoped

public class Listing implements Serializable {
    private int listingID;
    private int listingLength;
    private int price;
    private String title;
    private String seller;
    private String postDate;
    private String expirationDate;
    private String category;
    private String type;
    private String imgSrc;
    private String description;
    private String[] categories = {"Book", "Auto", "Shoe", "Video Game"};
    private UIInput imgUI;
    
    DBConnect dbConnect = new DBConnect();
    
    public Listing() {
 
    }
    
    public int getListingLength() {
        return listingLength;
    }

    public void setListingLength(int listingLength) {
        this.listingLength = listingLength;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public UIInput getImgUI() {
        return imgUI;
    }

    public void setImgUI(UIInput imgUI) {
        this.imgUI = imgUI;
    }
    
    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
    
    public String[] getCategories() {
        return categories;
    }
    
    public void setCategories(String[] categories) {
        this.categories = categories;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public int getListingID(){
        return listingID;
    }
    public void setListingID(int listingID){
        this.listingID = listingID;
    }
    
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getSeller(){
        return seller;
    }
    public void setSeller(String seller){
        this.seller = seller;
    }
    
    public String getPostDate(){
        return postDate;
    }
    public void setPostDate(String postDate){
        this.postDate = postDate;
    }
    
    public String getExpirationDate(){
        return expirationDate;
    }
    
    public void setExpirationDate(String expirationDate){
        this.expirationDate = expirationDate;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void loadImg() {
        this.imgSrc = imgUI.getValue().toString();
    }
    
    public int createItem() throws SQLException {
        int id = -1;
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement item = con.prepareStatement(
                "INSERT INTO items (image) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
        
        item.setString(1, imgSrc);


        item.executeUpdate();
        ResultSet keys = item.getGeneratedKeys();
        if(keys.next())
            id = keys.getInt(1);
        statement.close();
        con.commit();
        con.close();
        
        return id;
    }
    
    public int createListing(int item_id) throws SQLException {
        int id = -1;
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement listing = con.prepareStatement(
                "INSERT INTO listings (price, title, description, post_date, exp_date, status, item_type, item, seller) "
                        + "VALUES (?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        
        LocalDate post_date = LocalDate.now();
        LocalDate exp_date = LocalDate.now().plusDays(listingLength);
        
        listing.setInt(1, price);
        listing.setString(2, title);
        listing.setString(3, description);
        listing.setDate(4, java.sql.Date.valueOf(post_date));
        listing.setDate(5, java.sql.Date.valueOf(exp_date));
        listing.setString(6, "active");
        listing.setString(7, category);
        listing.setInt(8, item_id);
        listing.setString(9, getUser());

        listing.executeUpdate();
        ResultSet keys = listing.getGeneratedKeys();
        if(keys.next())
            id = keys.getInt(1);
        statement.close();
        con.commit();
        con.close();
        
        return id;
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
     
    public void submitSell() throws SQLException {
        int item_id = createItem();
        
        switch (category) 
        {
            case "Book" :
                Book book = getBook();
                book.createBook(item_id);
                break;
            case "Auto" :
                Car car = getCar();
                car.createCar(item_id);
                break;
            case "Shoe" :
                Shoe shoe = getShoe();
                shoe.createShoe(item_id);
                break;
            case "Video Game" :
                Videogame videogame = getVideogame();
                videogame.createVideogame(item_id);
                break;
            default:
                System.out.println("no category selected");
                break;
        } 
        
        createListing(item_id);
    }
    
    public String findListing(Listing listing) throws SQLException {
        
        listingID = listing.getListingID();
        price = listing.getPrice();
        title = listing.getTitle();
        description = listing.getDescription();
        postDate = listing.getPostDate();
        expirationDate = listing.getExpirationDate();
        category = listing.getCategory();
        imgSrc = listing.getImgSrc();
        seller = listing.getSeller();
        System.out.println(category);
        
        switch (category) 
        {
            case "Book" :
                Book book = getBook();
                book.findBook(listingID);
                break;
            case "Auto" :
                Car car = getCar();
                car.findCar(listingID);
                break;
            case "Shoe" :
                Shoe shoe = getShoe();
                shoe.findShoe(listingID);
                break;
            case "Video Game" :
                Videogame videogame = getVideogame();
                videogame.findVideogame(listingID);
                break;
            default:
                System.out.println("no category selected");
                break;
        } 
        return "Listing";
    }
}
