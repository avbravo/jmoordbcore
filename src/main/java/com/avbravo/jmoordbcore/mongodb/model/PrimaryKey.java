/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.mongodb.model;

 
 

/**
 *
 * @author avbravo
 */
 
 
public class PrimaryKey {
    private String name;
    private String type;

    public PrimaryKey() {
    }

    public PrimaryKey(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "PrimaryKey{" + "name=" + name + ", type=" + type + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
    
    
}
