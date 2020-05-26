/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.codecnative;

import com.mongodb.client.model.InsertOneOptions;

/**
 *
 * @author avbravo
 */
@SuppressWarnings({"unchecked", "UnusedReturnValue", "unused", "removal"})
public interface CodecNative {
    default <T> T save(T entity) {
         System.out.println("++++++++++++++++++++++++++++++++++");
         System.out.println("Template.java. save()");
        return save(entity, new InsertOneOptions());
    }
         <T> T save(T entity, InsertOneOptions options);
         
         <T> T findAll(T entity);
}
