/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.codecnative.test;

import com.avbravo.jmoordbcore.codecnative.example.model.Person;
import com.avbravo.jmoordbcore.codecnative.example.model.Calle;
import com.avbravo.jmoordbcore.codecnative.example.model.Address;
import com.avbravo.jmoordbcore.codecnative.CodecNative;
import com.avbravo.jmoordbcore.codecnative.JmoordbCodecNative;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import jakarta.inject.Named;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
//import com.mongodb.client.MongoClients;

/**
 *
 * @author avbravo
 */
@Named
@RequestScoped
public class Example1 implements Serializable{

    /**
     * @param args the command line arguments
     */
    public void test() {
        // TODO code application logic here
        try {
            //Obtener el codec
         MongoClient mongoClient = MongoClients.create(JmoordbCodecNative.settings());
            //Definir codecNative
       final CodecNative codecNative = JmoordbCodecNative.createConnection(mongoClient, "jmoordb_nativecode");
        Person person = new Person("Ada Byron", 20, new Address("St James Square", "London", "W1", new Calle("c", "Rosio")));
        codecNative.save(person);

            System.out.println(" invocare find()");
            //QUERY
       codecNative.findAll(person);
        } catch (Exception e) {
            System.out.println("Error " + e.getLocalizedMessage());
        }
    }

}
