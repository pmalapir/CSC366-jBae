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

@Named(value = "listing")
@ManagedBean
@SessionScoped

public class Listing {
    private int listingID;
    private String seller;
    private String postDate;
    private String expirationDate;
    private String category;
    private String imgSrc;
    private String[] categories = {"Books", "Cars", "Shoes", "Video Games"};

    private UIInput imgUI;

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
    
    public void loadImg() {
        this.imgSrc = imgUI.getValue().toString();
    }
}
