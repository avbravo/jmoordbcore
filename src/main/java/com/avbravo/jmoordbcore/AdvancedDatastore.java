/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore;

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
public interface AdvancedDatastore extends Repository {

    @SuppressWarnings("removal")
    @Deprecated(since = "2.0", forRemoval = true)
    default <T> void insert(T entity, InsertOptions options) {
     //   insert(entity, options.toInsertOneOptions()); 
    }
}
