/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.codecregister;

import com.mongodb.Block;
import com.mongodb.MongoClientSettings;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
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
public class Example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            //Creating a Custom CodecRegistry
            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));

            //Using the CodecRegistry
            MongoClientSettings settings = MongoClientSettings.builder()
                    .codecRegistry(pojoCodecRegistry)
                    .build();

            MongoClient mongoClient = MongoClients.create(settings);

            /**
             *
             */
            MongoDatabase database = mongoClient.getDatabase("test");
//You can use an alternative CodecRegistry with a MongoDatabase:
            database = database.withCodecRegistry(pojoCodecRegistry);

            //    MongoCollection<Document> collection = database.getCollection("myTestCollection");
//You can use an alternative CodecRegistry with a MongoCollection:
            //   collection = collection.withCodecRegistry(pojoCodecRegistry);
//
            MongoCollection<Person> collection = database.getCollection("people", Person.class);

            //Insert a Person
            Person ada2 = new Person("Ada Byron", 20, new Address("St James Square", "London", "W1",new Calle("c", "Rosio")));
                        collection.insertOne(ada2);
                        
                        
//            Person ada = new Person("Ada Byron", 20, new Address("St James Square", "London", "W1"));
//
//            collection.insertOne(ada);
            System.out.println("-----Guardando.....");

//            //Insert Many Persons
//            List<Person> people = asList(
//                    new Person("Charles Babbage", 45, new Address("5 Devonshire Street", "London", "W11")),
//                    new Person("Alan Turing", 28, new Address("Bletchley Hall", "Bletchley Park", "MK12")),
//                    new Person("Timothy Berners-Lee", 61, new Address("Colehill", "Wimborne", null))
//            );
//
//            collection.insertMany(people);
//            System.out.println("Insertando muchas.....");

            //  Query the Collection
            Block<Person> printBlock = new Block<Person>() {
                @Override
                public void apply(final Person person) {
                    System.out.println(person);
                }
            };

            collection.find().forEach(printBlock);
        } catch (Exception e) {
            System.out.println("Error "+e.getLocalizedMessage());
        }
    }

}
