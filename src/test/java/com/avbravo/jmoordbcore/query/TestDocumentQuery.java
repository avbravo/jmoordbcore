/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.query;

import com.avbravo.jmoordbcore.annotations.Repository;
import com.avbravo.jmoordbcore.documentquery.DocumentQuery;
import com.avbravo.jmoordbcore.enumeration.Comparison;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author avbravo
 */
@Named
@RequestScoped
public class TestDocumentQuery implements Serializable{
@Inject
Repository repository;
    private static String ordenacion = "";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            

            
            DocumentQuery filter = new DocumentQuery.Builder().
                     field("username").EQ("fatima")
                    .AND().field("edad").NE(10)
                    .AND().field("active").EQ(true)
                    .AND().dateComparision("fechax", Comparison.EQ, new Date())
                    .build();
            
            
            DocumentQuery filter2 = new DocumentQuery.Builder().
                    field("username").EQ(5)
                    .AND().field("age").NE(14)
                    .AND().dateBetween("fecha", new Date(), new Date())   
                    .OR().dateComparision("fechaprocesado", Comparison.EQ, new Date())
                    .build();
            
            DocumentQuery filter3 = new DocumentQuery.Builder().
                    field("username").EQ(5)
                    .AND().field("age").NE(14)
                    .BEGIN()
                    .AND().dateBetween("fecha", new Date(), new Date())   
                    .OR().dateComparision("fechaprocesado", Comparison.EQ, new Date())
                    .END()
                    .build();
            
            
            
            DocumentQuery filter4 = new DocumentQuery.Builder().
                    field("username").EQ(5)
                    .AND().field("age").NE(14)
                    .BEGIN()
                    .OR().dateBetween("fecha", new Date(), new Date())   
                    .AND().dateComparision("fechaprocesado", Comparison.EQ, new Date())
                    .END()
                    .build();
            
            DocumentQuery filter5 = new DocumentQuery.Builder().
                    field("username").EQ(5)
                    .AND().field("age").NE(14)
                    .BEGIN()
                    .OR().dateBetween("fecha", new Date(), new Date())   
                    .AND().dateComparision("fechaprocesado", Comparison.EQ, new Date())
                    .END()
                    .AND().field("avtive").EQ(false)                    
                    .build();
                    
            DocumentQuery filter6 = new DocumentQuery.Builder().
                    field("username").EQ(5)
                    .AND().field("age").NE(14)
                    .BEGIN()
                    .OR().dateBetween("fecha", new Date(), new Date())   
                    .AND().dateComparision("fechaprocesado", Comparison.EQ, new Date())
                    .END()
                    .BEGIN()
                    .AND().field("avtive").EQ(false)                    
                    .END()
                    .build();
                    
            
            /*
            Restricion
            */
           
           
            
        } catch (Exception e) {
            System.out.println("---error " + e.getLocalizedMessage());
        }

//        if(jw.getJmoordbWhere().getJmoordbWhere().getJmoordbWhere().getJmoordbWhere().get !=null){
//           
//        }
    }

   
}
