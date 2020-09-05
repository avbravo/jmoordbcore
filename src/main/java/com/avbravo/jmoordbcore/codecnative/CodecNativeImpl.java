/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.codecnative;

import com.avbravo.jmoordbcore.codecnative.example.Person;
import com.mongodb.Block;
import com.mongodb.client.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertOneOptions;
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

    protected CodecNativeImpl(final MongoClient mongoClient, final String options, final String dbName, CodecRegistry pojoCodecRegistry) {

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

        save(entity, 1, 2, 2);
        return entity;
    }

    private <T> void save(final T entity, Integer a, Integer b, Integer c) {
        //Aqui poner los entitys
        try {
            MongoCollection<T> collection = (MongoCollection<T>) database.getCollection(entity.getClass().getSimpleName(), entity.getClass());
            collection.insertOne(entity);

        } catch (Exception e) {
            System.out.println("save() " + e.getLocalizedMessage());
        }

    }
    
    
    
    
    
    public <T> T findAll(final T entity) {
        try{
  MongoCollection<T> collection = (MongoCollection<T>) database.getCollection(entity.getClass().getSimpleName(), entity.getClass());
              

             //  Query the Collection
            Block<Person> printBlock = new Block<Person>() {
                @Override
                public void apply(final Person person) {
                    System.out.println(person);
                }
            };
            //Consumer
          //   collection.find().forEach(printBlock);
             } catch (Exception e) {
             System.out.println("find() " + e.getLocalizedMessage());
        }
        return entity;
    }
  

}
