package Listings;

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
    private double price;
    private double listingLength;
    
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    
    public double getListingLength(){
        return listingLength;
    }
    public void setListingLength(double listingLength){
        this.listingLength = listingLength;
    }
}
