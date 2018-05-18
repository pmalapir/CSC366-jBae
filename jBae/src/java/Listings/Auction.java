/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listings;

/**
 *
 * @author Patrick
 */
public class Auction extends Listing{
    private double currentBid;
    private double reserve;
    
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
