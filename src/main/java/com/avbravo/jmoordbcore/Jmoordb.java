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
     public static Template createConnection(final MongoClient mongoClient, final String dbName) {
         System.out.println("Jmoordb.-------Jmoordb.createConnection(final MongoClient mongoClient, final String dbName)");
        return createConnectionTemplateImpl(mongoClient, dbName,"llamare");
    }
     
      public static Template createConnectionTemplateImpl(final MongoClient mongoClient, final String dbName, final String options) {
           System.out.println("Jmoordb.******createConnectionTemplateImpl(final MongoClient mongoClient, final String dbName, final String options)");
        return new TemplateImpl(mongoClient, options, dbName);
    }
}
