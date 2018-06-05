package Listings;

import Connection.DBConnect;
import Items.Book;
import Items.Car;
import Items.Shoe;
import Items.Videogame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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

@Named(value = "buyItNow")
@ManagedBean
@SessionScoped

public class BuyItNow extends Listing{
    
    private DBConnect dBConnect = new DBConnect();
    
   
}
