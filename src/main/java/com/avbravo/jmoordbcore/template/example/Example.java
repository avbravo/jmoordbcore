/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.template.example;


import com.avbravo.jmoordbcore.template.JmoordbTemplate;
import com.mongodb.MongoClient;
import com.mongodb.client.model.InsertOneOptions;
import com.avbravo.jmoordbcore.template.Template;

/**
 *
 * @author avbravo
 */
public class Example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MongoClient mongoClient = new MongoClient();
      
        final Template template = JmoordbTemplate.createConnection(mongoClient, "jmoordb_example");
//     
      Person p = new Person(1,"aris");
       Person save = template.save(p);
       
    }
    
}
