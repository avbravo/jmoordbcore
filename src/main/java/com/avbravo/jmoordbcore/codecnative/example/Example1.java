/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.codecnative.example;

import com.avbravo.jmoordbcore.codecnative.CodecNative;
import com.avbravo.jmoordbcore.codecnative.JmoordbCodecNative;
import com.avbravo.jmoordbcore.template.JmoordbTemplate;
import com.avbravo.jmoordbcore.template.Template;
import com.mongodb.Block;
import com.mongodb.MongoClientSettings;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static java.util.Arrays.asList;
import java.util.List;
import org.bson.Document;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author avbravo
 */
public class Example1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            //Obtener el codec
            MongoClient mongoClient = MongoClients.create(JmoordbCodecNative.settings());
            //Definir codecNative
            final CodecNative codecNative = JmoordbCodecNative.createConnection(mongoClient, "jmoordb_example");
            Person person = new Person("Ada Byron", 20, new Address("St James Square", "London", "W1", new Calle("c", "Rosio")));
            codecNative.save(person);

        } catch (Exception e) {
            System.out.println("Error " + e.getLocalizedMessage());
        }
    }

}
