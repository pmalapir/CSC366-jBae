/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Search;

import Connection.DBConnect;

import Listings.ArrayListings;
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

public class Search {
    private String search_input;

    private DBConnect dbConnect = new DBConnect();
    
    public String getSearch_input() {
        return search_input;
    }

    public void setSearch_input(String search_input) {
        this.search_input = search_input;
    }
    

    public ArrayListings getArrayListing() throws SQLException {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        ArrayListings arrayListing = (ArrayListings) elContext.getELResolver().getValue(elContext, null, "arrayListings");
        return arrayListing;
    }
    
    public String simple_title_search() throws SQLException {
        Connection con = dbConnect.getConnection();
        
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        
        con.setAutoCommit(false);
        
        Statement statement = con.createStatement();
                
        PreparedStatement simple_search = con.prepareStatement(
            "SELECT *\n" +
            "FROM listings INNER JOIN items ON item = item_id\n" +
            "   AND LOWER(title) LIKE ?");

        simple_search.setString(1, "%" + search_input.toLowerCase() + "%");
        
        ResultSet rs = simple_search.executeQuery();
        ArrayListings arrayListings = getArrayListing();
        
        arrayListings.generateGeneric(rs);
        
        statement.close();
        con.commit();
        con.close();
        
        return "SearchResult";
    }
    
}
