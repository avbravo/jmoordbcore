/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.codecnative.example;

import org.bson.types.ObjectId;

/**
 *
 * @author avbravo
 */
public final class Person {
    private ObjectId id;
    private String name;
    private int age;
    private Address address;

    public Person() {
    }

  
    public ObjectId getId() {
        return id;
    }

    public void setId(final ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }
    
    // Rest of implementation

    public Person(String name, int age, Address address) {

        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(ObjectId id, String name, int age, Address address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + '}';
    }

   
    
    
}
