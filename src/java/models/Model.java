/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import db_connection.DBConnection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauricio
 */
public class Model {

    public void save() {
        try {
            DBConnection connection;
            connection = new DBConnection();
            connection.save((Object) this);
        } catch (Exception ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, "Cannot connect to DB.", ex);
        }
    }
    
    public void buildObject(ResultSet resultSet){
        Class modelClass = this.getClass();
        java.lang.reflect.Field[] fields;
        fields = modelClass.getDeclaredFields();
        for (java.lang.reflect.Field field : fields) {
            try {
                field.set(this, resultSet.getString(field.getName()));
            } catch (Exception e) { 
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Illegal field.", e);
            }
        }
    }
}
