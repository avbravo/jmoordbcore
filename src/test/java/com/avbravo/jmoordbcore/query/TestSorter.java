/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.query;

import com.avbravo.jmoordbcore.annotations.Repository;
import com.avbravo.jmoordbcore.sorter.Sort;
import com.avbravo.jmoordbcore.sorter.Sorter;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import org.bson.Document;

/**
 *
 * @author avbravo
 */
@Named
@RequestScoped
public class TestSorter implements Serializable{
@Inject
Repository repository;
    private static String ordenacion = "";

    /**
     * @param args the command line arguments
     */
    public void test() {
        // TODO code application logic here
        try {

            
            //---------ORDENACION SIMPLE----------
            Sorter sorter = new Sorter.Builder().
                    field("iduser")
                    .sort(Sort.ASC)
                    .build();

            //---------ORDENACION MULTIPLE----------
            Sorter sorter2 = new Sorter.Builder().
                    field("username")
                    .sort(Sort.ASC)
                    .sorter(
                            new Sorter.Builder().
                                    field("date")
                                    .sort(Sort.ASC)                                    
                                    .build()
                    ).build();

           
         Document  querySorter =repository.queryCreateSort(sorter);
            System.out.println("-----------DOCUMENTO GENERADO SIMPLE-------");
            System.out.println(querySorter);
      
            
            querySorter =repository.queryCreateSort(sorter2);
            System.out.println("-----------DOCUMENTO GENERADO COMPUESTO-------");
            System.out.println(querySorter);

        } catch (Exception e) {
            System.out.println("---error " + e.getLocalizedMessage());
        }

//        if(jw.getJmoordbWhere().getJmoordbWhere().getJmoordbWhere().getJmoordbWhere().get !=null){
//           
//        }
    }

   
}
