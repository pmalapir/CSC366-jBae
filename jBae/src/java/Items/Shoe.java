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

@Named(value = "shoe")
@ManagedBean
@SessionScoped
public class Shoe {
    private int itemID;
    private String brand;
    private String model;
    private int size;
    
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
}
