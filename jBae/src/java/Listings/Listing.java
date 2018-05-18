package Listings;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patrick
 */
public class Listing {
    private int listingID;
    private String seller;
    private String postDate;
    private String expirationDate;
    
    public int getListingID(){
        return listingID;
    }
    public void setListingID(int listingID){
        this.listingID = listingID;
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
}
