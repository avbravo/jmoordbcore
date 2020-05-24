/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore;

import com.mongodb.MongoClient;

/**
 *
 * @author avbravo
 */
public class Jmoordb {
     public static Repository createDatastore(final MongoClient mongoClient, final String dbName) {
        return createDatastore(mongoClient, dbName,"llamare");
    }
     
      public static Repository createDatastore(final MongoClient mongoClient, final String dbName, final String options) {
        return new RepositoryImpl(mongoClient, options, dbName);
    }
}
