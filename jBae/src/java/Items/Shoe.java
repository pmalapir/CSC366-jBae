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

@Named(value = "shoe")
@ManagedBean
@SessionScoped
public class Shoe implements Serializable {
    private int itemID;
    private String brand;
    private String model;
    private int size;
    private DBConnect dbConnect = new DBConnect();
    public int getItemID(){
        return itemID;
    }
    public void setItemID(int itemID){
        this.itemID = itemID;
    }
    
    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    
    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model = model;
    }
    
    public int getSize(){
        return size;
    }
    public void setSize(int size){
        this.size = size;
    }
    
    public void findShoe(int listing_id) throws SQLException {
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement shoe = con.prepareStatement(
            "SELECT *\n" +
            "FROM listings INNER JOIN items on item = items.item_id\n" +
            "INNER JOIN shoe on items.item_id = shoe.item_id\n" +
            "WHERE status = 'active' AND listing_id = ?");
        
        shoe.setInt(1, listing_id);
        
        ResultSet rs = shoe.executeQuery();
        if(rs.next()) {
            brand = rs.getString("brand");
            model = rs.getString("model");
            size = rs.getInt("size");
        }
        
        statement.close();
        con.commit();
        con.close();
    }
    
    public void createShoe(int id) throws SQLException {
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement shoe = con.prepareStatement(
            "INSERT INTO shoes VALUES (?,?,?,?)");
        
        shoe.setInt(1, id);
        shoe.setString(2, brand);
        shoe.setString(3, model);
        shoe.setInt(4, size);
        
        shoe.executeUpdate();
        statement.close();
        con.commit();
        con.close();
    }
}
