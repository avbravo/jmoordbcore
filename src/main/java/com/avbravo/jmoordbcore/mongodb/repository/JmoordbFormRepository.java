/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.mongodb.repository;

import jakarta.ejb.Stateless;
import com.avbravo.jmoordbcore.mongodb.Repository;
import com.avbravo.jmoordbcore.mongodb.model.JmoordbForm;
 


/**
 *
 * @author avbravo
 */
@Stateless
public class JmoordbFormRepository extends Repository<JmoordbForm> {
  
    public JmoordbFormRepository() {
        super(JmoordbForm.class);
    }

}
