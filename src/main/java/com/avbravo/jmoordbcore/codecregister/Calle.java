/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.codecregister;

/**
 *
 * @author avbravo
 */
public class Calle {
    private String id;
    private String calle;

    public Calle(String id, String calle) {
        this.id = id;
        this.calle = calle;
    }

    public Calle() {
    }

    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    @Override
    public String toString() {
        return "Calle{" + "id=" + id + ", calle=" + calle + '}';
    }

  
    
    
    
    
}
