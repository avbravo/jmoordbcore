/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.producer;


import com.avbravo.jmoordbcore.codecnative.JmoordbCodecNative;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import java.util.ArrayList;
import java.util.Arrays;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

/**
 *
 * @author avbravo
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class CodecNativeProducer {

    @Produces
    @ApplicationScoped
    public MongoClient mongoClientCodecNative() {
         MongoClient mongoClient = MongoClients.create(JmoordbCodecNative.settings());
        try {
        
          
        } catch (Exception e) {
            System.out.println("error() "+e.getLocalizedMessage());
     //       JmoordbUtil.errorMessage("conecction() "+e.getLocalizedMessage());
        }

        return mongoClient;
    }
}
