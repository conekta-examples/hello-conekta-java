/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author mauricio
 */
public class Event extends Model {

    public String id;
    public String type;
    public String charge_id;
    public String created_at;

    public Event() {
    }
    
    public void build(String id, String type, String charge_id, String created_at) {
        this.id = id;
        this.type = type;
        this.charge_id = charge_id;
        this.created_at = created_at;
    }

}
