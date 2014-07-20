/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import db_connection.DBConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauricio
 */
public class Product extends Model {

    public String id;
    public String name;
    public String description;
    public String price;
    public String is_subscription;

    public Product(){
        
    }
    
    public String getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    
    public String getDescription(){
        return description;
    }
    
    public String getPrice(){
        return price;
    }
    
    public String getIsSubscription(){
        return is_subscription;
    }
    
    public static Product find(String id){
        Product product = new Product();
        try {
            DBConnection connection;
            connection = new DBConnection();
            product = (Product) connection.find(id, product);
        } catch (Exception ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, "Cannot connect to DB.", ex);
        }
        return product;
    }
    
    public static ArrayList all(){
        ArrayList array = new ArrayList();
        try {
            DBConnection connection;
            connection = new DBConnection();
            array = connection.all(Product.class);
        } catch (Exception ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, "Cannot connect to DB.", ex);
        }
        return array;
    }
    
    public void build(String id, String name, String description, String price, String is_subscription) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.is_subscription = is_subscription;
    }

}
