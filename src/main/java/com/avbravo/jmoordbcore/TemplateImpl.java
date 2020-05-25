/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertOneOptions;
import java.lang.System.Logger;

/**
 *
 * @author avbravo
 */
@SuppressWarnings({"unchecked", "rawtypes", "removal"})
public class TemplateImpl   implements AdvancedTemplate {
    
     // private static final Logger LOG = LoggerFactory.getLogger(TemplateImpl.class);

    private final MongoDatabase database;
    private final MongoClient mongoClient;
     protected TemplateImpl(final MongoClient mongoClient, final String options, final String dbName) {
         System.out.println("-TemplateImpl -------->protected TemplateImpl((final MongoClient mongoClient, final String options, final String dbName) " );
       this.mongoClient = mongoClient;
       MongoDatabase database = mongoClient.getDatabase(dbName);
//        this.mapper = new Mapper(this, database.getCodecRegistry(), options);
//
      this.database = database;
//                            .withCodecRegistry(mapper.getCodecRegistry());
//        this.queryFactory = options.getQueryFactory();
    }
    
     @Override
    public <T> T save(final T entity) {
        return save(entity, new InsertOneOptions());
    }
     @Override
    public <T> T save(final T entity, final InsertOneOptions options) {
         System.out.println("===========================================================");
         System.out.println("TemplateImpl.java..---save()");
        if (entity == null) {
          
        }

        save(1,2,2);
        return entity;
    }
    
      private <T> void save(Integer a, Integer b, Integer c) {
          System.out.println("Voy a guardar los datos");
    }
      
      
       
      
     

}

