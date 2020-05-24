/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.example;

import com.avbravo.jmoordbcore.Jmoordb;
import com.avbravo.jmoordbcore.Repository;
import com.mongodb.MongoClient;
import com.mongodb.client.model.InsertOneOptions;

/**
 *
 * @author avbravo
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MongoClient mongoClient = new MongoClient();
          final Repository repository = Jmoordb.createDatastore(mongoClient, "morphia_example");
     
        Person p = new Person(1,"aris");
        Person save = repository.save(p);
    }
    
}
