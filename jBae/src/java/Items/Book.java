package Items;

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

@Named(value = "book")
@ManagedBean
@SessionScoped

public class Book {
    private int itemID;
    private String title;
    private String author;
    private String genre;
    
    public int getItemID(){
        return itemID;
    }
    public void setItemID(int itemID){
        this.itemID = itemID;
    }
    
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    
    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    
    
}
