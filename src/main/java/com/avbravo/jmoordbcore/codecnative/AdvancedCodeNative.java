/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.codecnative;

import com.avbravo.jmoordbcore.template.*;
import com.mongodb.DBObject;
import com.mongodb.DBRef;
import com.mongodb.InsertOptions;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author avbravo
 */
@SuppressWarnings("removal")
@Deprecated(since = "2.0", forRemoval = true)
public interface AdvancedCodeNative extends CodecNative {

    @SuppressWarnings("removal")
    @Deprecated(since = "2.0", forRemoval = true)
    default <T> void insert(T entity, InsertOptions options) {
        System.out.println("AdvancedTemplate---->AdvancedTemplate.insert");
     //   insert(entity, options.toInsertOneOptions()); 
    }
}
