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

@Named(value = "car")
@ManagedBean
@SessionScoped
public class Car implements Serializable {
    private int itemID;
    private String make;
    private String model;
    private int year;
    private DBConnect dbConnect = new DBConnect();
    
    public int getItemID(){
        return itemID;
    }
    public void setItemID(int itemID){
        this.itemID = itemID;
    }
    
    public String getMake(){
        return make;
    }
    public void setMake(String make){
        this.make = make;
    }
    
    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model = model;
    }
    
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year = year;
    }
    
    public void findCar(int listing_id) throws SQLException {
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement car = con.prepareStatement(
            "SELECT *\n" +
            "FROM listings INNER JOIN items on item = items.item_id\n" +
            "INNER JOIN autos on items.item_id = autos.item_id\n" +
            "WHERE status = 'active' AND listing_id = ?");
        
        car.setInt(1, listing_id);
        
        ResultSet rs = car.executeQuery();
        if(rs.next()) {
            make = rs.getString("make");
            model = rs.getString("model");
            year = rs.getInt("year");
        }
        System.out.println("HERE");
        statement.close();
        con.commit();
        con.close();
    }
    
    public void createCar(int id) throws SQLException {
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement car = con.prepareStatement(
            "INSERT INTO autos VALUES (?,?,?,?)");
        
        car.setInt(1, id);
        car.setString(2, make);
        car.setString(3, model);
        car.setInt(4, year);
        
        car.executeUpdate();
        statement.close();
        con.commit();
        con.close();
    }
}
