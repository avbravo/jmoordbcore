/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.test.model;


import static com.avbravo.jmoordbcore.codecnative.JmoordbCodecNative.pojoCodecRegistry;
import com.avbravo.jmoordbcore.template.JmoordbTemplate;
import com.avbravo.jmoordbcore.template.Template;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import jakarta.inject.Named;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author avbravo
 */
@Named
@RequestScoped
public class Example implements Serializable{

    /**
     * @param args the command line arguments
     */
    public void test() {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        // TODO code application logic here
     MongoClientSettings settings = MongoClientSettings.builder()
        .codecRegistry(pojoCodecRegistry)
        .build();
MongoClient mongoClient = MongoClients.create(settings);
      
        final Template template = JmoordbTemplate.createConnection(mongoClient, "jmoordb_example");
//     
      Person p = new Person(1,"aris");
       Person save = template.save(p);
       
    }
    
}
