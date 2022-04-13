/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.codecnative;


import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author avbravo
 */
public class JmoordbCodecNative {

    public static CodecNative createConnection(final MongoClient mongoClient, final String dbName) {
        System.out.println("Jmoordb.-------Jmoordb.createConnection(final MongoClient mongoClient, final String dbName)");
        return createConnection(mongoClient, dbName, "llamare");
    }

    public static CodecNative createConnection(final MongoClient mongoClient, final String dbName, final String options) {
        System.out.println("Jmoordb.******createConnectionTemplateImpl(final MongoClient mongoClient, final String dbName, final String options)");
        return new CodecNativeImpl(mongoClient, options, dbName, pojoCodecRegistry());
    }

    /**
     * Devuelve el settins
     */
    public static CodecRegistry pojoCodecRegistry() {

        //Creating a Custom CodecRegistry
        CodecRegistry pojoCodecRegistryVar = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        return pojoCodecRegistryVar;
    }

    /**
     * Devuelve el settins
     */
    public static MongoClientSettings settings() {

        //Creating a Custom CodecRegistry
        //Using the CodecRegistry
        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry())
                .build();

        return settings;
    }
}
