/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.codecnative;

import com.avbravo.jmoordbcore.codecnative.example.Address;
import com.avbravo.jmoordbcore.codecnative.example.Calle;
import com.avbravo.jmoordbcore.codecnative.example.Person;
import com.avbravo.jmoordbcore.template.*;
import com.mongodb.client.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertOneOptions;
import java.lang.System.Logger;
import org.bson.codecs.configuration.CodecRegistry;

/**
 *
 * @author avbravo
 */
@SuppressWarnings({"unchecked", "rawtypes", "removal"})
public class CodecNativeImpl implements AdvancedCodeNative {

    // private static final Logger LOG = LoggerFactory.getLogger(TemplateImpl.class);
    private final MongoDatabase database;
    private final MongoClient mongoClient;

    protected CodecNativeImpl(final MongoClient mongoClient, final String options, final String dbName,CodecRegistry pojoCodecRegistry) {
        
        this.mongoClient = mongoClient;
        MongoDatabase database = mongoClient.getDatabase(dbName);
         database = database.withCodecRegistry(pojoCodecRegistry);
        
        this.database = database;

    }

    @Override
    public <T> T save(final T entity) {
        return save(entity, new InsertOneOptions());
    }

    @Override
    public <T> T save(final T entity, final InsertOneOptions options) {
     
        if (entity == null) {

        }

        save(entity,1, 2, 2);
        return entity;
    }

    private <T> void save(final T entity,Integer a, Integer b, Integer c) {
        //Aqui poner los entitys
        System.out.println("V===============================>oy a guardar los datos");
         MongoCollection<Person> collection = database.getCollection("people", Person.class);

            //Insert a Person aqui pongo los entitys descompuestos de la reflexio
            Person person = new Person("Ada Byron", 20, new Address("St James Square", "London", "W1", new Calle("c", "Rosio")));
            collection.insertOne(person);
            System.out.println("-----------------> Guardado en la base de datos");
        
    }

}
