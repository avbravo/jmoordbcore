/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.producer;

import com.avbravo.jmoordbcore.annotations.core.CodecNativeClient;
import com.avbravo.jmoordbcore.annotations.core.RepositoryClient;
import com.avbravo.jmoordbcore.annotations.core.TemplateClient;
import com.avbravo.jmoordbcore.codecnative.JmoordbCodecNative;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import jakarta.ejb.ConcurrencyManagement;
import jakarta.ejb.ConcurrencyManagementType;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Singleton;
import jakarta.ws.rs.Produces;

/**
 *
 * @author avbravo
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class JmoordbCoreProducer {

    MongoClient mongoClient;

    // <editor-fold defaultstate="collapsed" desc="MongoClient mongoClientCodecNative() ">
    @Produces
    @CodecNativeClient
    @ApplicationScoped
    public MongoClient mongoClientCodecNative() {
        System.out.println("-------------------------------------");
        System.out.println("Producer");
        MongoClient mongoClientCN = MongoClients.create(JmoordbCodecNative.settings());
        try {

        } catch (Exception e) {
            System.out.println("emongoClientCodecNative() " + e.getLocalizedMessage());

        }
        mongoClient = mongoClientCN;
        return mongoClient;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="MongoClient mongoClientCodecNative() ">
    @Produces
    @TemplateClient
    @ApplicationScoped
    public MongoClient mongoClientTemplate() {
        System.out.println("-------------------------------------");
        System.out.println("Producer");
        MongoClient mongoClientTemplate = MongoClients.create(JmoordbCodecNative.settings());
        try {

        } catch (Exception e) {
            System.out.println("mongoClientTemplate() () " + e.getLocalizedMessage());

        }
        mongoClient = mongoClientTemplate;
        return mongoClient;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="MongoClient mongoClientRepository() ">
    @Produces
    @RepositoryClient
    @ApplicationScoped
    public MongoClient mongoClientRepository() {
        System.out.println("-------------------------------------");
        System.out.println("Producer");
        MongoClient mongoClientTemplate = MongoClients.create(JmoordbCodecNative.settings());
        try {

        } catch (Exception e) {
            System.out.println("mongoClientRepository() " + e.getLocalizedMessage());

        }
        mongoClient = mongoClientTemplate;
        return mongoClient;
    }
// </editor-fold>
    
    
    
    
    
}
