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

@Named(value = "auction")
@ManagedBean
@SessionScoped
public class Auction extends Listing{
    private double startingBid = 0;
    private double auctionLength;
    private double currentBid;
    private double reserve;
    
    public double getStartingBid(){
        return startingBid;
    }
    public void setStartingBid(double startingBid){
        this.startingBid = startingBid;
    }
    
    public double getAuctionLength(){
        return auctionLength;
    }
    public void setAuctionLength(double auctionLength){
        this.auctionLength = auctionLength;
    }
    
    public double getCurrentBid(){
        return currentBid;
    }
    public void setCurrentBid(double currentBid){
        this.currentBid = currentBid;
    }
    
    public double getReserve(){
        return reserve;
    }
    public void setReserve(double reserve){
        this.reserve = reserve;
    }
}
