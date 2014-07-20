/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_connection;

import com.mysql.jdbc.Connection;
import java.lang.reflect.Constructor;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Model;

/**
 *
 * @author mauricio
 */
public class DBConnection {

    public Connection connection;

    public DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hello_conekta_java",
                "root", "password");
    }
    
    public Model find(String id, Model model){
        Class modelClass = model.getClass();
        String tableName = modelClass.getSimpleName().toLowerCase() + "s";
        String columns = this.getFieldNames(modelClass);
        Constructor c;
        Model o;
        ArrayList objects = new ArrayList();
        try {
            java.sql.Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT " + columns + " FROM " + tableName + " WHERE id = " + id);
            c = modelClass.getConstructor();
            resultSet.next();
            model.buildObject(resultSet);
            statement.close();
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Invalid query." + tableName, ex);
        }
        return model;
    }

    public ArrayList all(Class modelClass) {
        String tableName = modelClass.getSimpleName().toLowerCase() + "s";
        String columns = this.getFieldNames(modelClass);
        Constructor c;
        Model o;
        ArrayList objects = new ArrayList();
        try {
            java.sql.Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT " + columns + " FROM " + tableName);
            c = modelClass.getConstructor();
            while (resultSet.next()) {
                o = (Model) c.newInstance();
                o.buildObject(resultSet);
                objects.add(o);
            }
            statement.close();
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Invalid query." + tableName, ex);
        }
        return objects;
    }

    public void save(Object model) {
        String tableName = model.getClass().getSimpleName().toLowerCase() + "s";
        String values = this.getFieldValues(model);
        String columns = this.getFieldNames(model.getClass());
        try {
            java.sql.Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO " + tableName + " (" + columns + " )" + " VALUES (" + values + ")");
            statement.close();
            connection.close();
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Cannot save in DB.", ex);
        }
    }
    
    protected String getFieldValues(Object model) {
        java.lang.reflect.Field[] fields;
        fields = model.getClass().getDeclaredFields();
        String values = "";
        for (java.lang.reflect.Field field : fields) {
            try {
                values += "'" + (field.get(model) + "").toString() + "'" + ",";
            } catch (Exception e) { 
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Illegal field.", e);
            }
            //field.getName();
        }
        if (!values.isEmpty())
            values = values.substring(0, values.length() - 1);
        return values;
    }

    protected String getFieldNames(Class modelClass) {
        java.lang.reflect.Field[] fields;
        fields = modelClass.getDeclaredFields();
        String values = "";
        for (java.lang.reflect.Field field : fields) {
            try {
                //values += field.get(modelClass).toString() + ",";
                values += field.getName() + ",";
            } catch (Exception e) { 
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Illegal field.", e);
            }
            //field.getName();
        }
        if (!values.isEmpty())
            values = values.substring(0, values.length() - 1);
        return values;
    }
}
