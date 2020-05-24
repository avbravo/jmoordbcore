/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.example;

import com.mongodb.client.model.InsertOneOptions;

/**
 *
 * @author avbravo
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PersonRepository personRepository = new PersonRepository() {
            @Override
            public <T> T save(T entity, InsertOneOptions options) {
                System.out.println("----New Main.java");
                return null;
            }
        } ;
        Person p = new Person(1,"aris");
        Person save = personRepository.save(p);
    }
    
}
