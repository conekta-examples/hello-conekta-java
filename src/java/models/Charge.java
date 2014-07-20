/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import db_connection.DBConnection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauricio
 */
public class Charge extends Model {

    public String id;
    public String livemode;
    public String created_at;
    public String status;
    public String currency;
    public String description;
    public String reference_id;
    public String failure_code;
    public String failure_message;
    public String amount;
    public String card_name;
    public String card_exp_month;
    public String card_exp_year;
    public String card_auth_code;
    public String card_last4;
    public String card_brand;

    public Charge() {
    }

    public String getId() {
        return id;
    }

    public String getLivemode() {
        return livemode;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public String getStatus() {
        return status;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDescription() {
        return description;
    }

    public String getReferenceId() {
        return reference_id;
    }

    public String getFailureCode() {
        return failure_code;
    }

    public String getFailureMessage() {
        return failure_message;
    }

    public String getAmount() {
        return amount;
    }

    public String getCardName() {
        return card_name;
    }

    public String getCardExpMonth() {
        return card_exp_month;
    }

    public String getCardExpYear() {
        return card_exp_year;
    }

    public String getCardAuthCode() {
        return card_auth_code;
    }

    public String getCardLast4() {
        return card_last4;
    }

    public String getCardBrand() {
        return card_brand;
    }

    public static ArrayList all() {
        ArrayList array = new ArrayList();
        try {
            DBConnection connection;
            connection = new DBConnection();
            array = connection.all(Charge.class);
        } catch (Exception ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, "Cannot connect to DB.", ex);
        }
        return array;
    }

    public void build(String id, String livemode, String created_at, String status, String currency, String description, String reference_id, String failure_code, String failure_message, String amount, String card_name, String card_exp_month, String card_exp_year, String card_auth_code, String card_last4, String card_brand) {
        this.id = id;
        this.livemode = livemode.equals("true") ? "1" : "0";
        Timestamp stamp = new Timestamp(Integer.parseInt(created_at));
        this.created_at = stamp.toString();
        this.status = status;
        this.currency = currency;
        this.description = description;
        this.reference_id = reference_id;
        this.failure_code = failure_code;
        this.failure_message = failure_message;
        this.amount = amount;
        this.card_name = card_name;
        this.card_exp_month = card_exp_month;
        this.card_exp_year = card_exp_year;
        this.card_auth_code = card_auth_code;
        this.card_last4 = card_last4;
        this.card_brand = card_brand;
    }
}
