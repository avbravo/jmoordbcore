/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.query;

import com.avbravo.jmoordbcore.annotations.Repository;
import com.avbravo.jmoordbcore.enumeration.Comparison;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
@Named
@RequestScoped
public class TestDateQuery implements Serializable{
@Inject
Repository repository;
    private static String ordenacion = "";

    /**
     * @param args the command line arguments
     */
    public  void test() {
        // TODO code application logic here
        try {

          //  Repository repository = new Repository();

//Entre fecchas            
            DateQuery dateQuery1 = new DateQuery.Builder().
                    field("fecha")
                    .start(new Date())
                    .comparison(Comparison.BETWEEN)
                    .end(new Date())
                    .excludedHours(true)
                    .build();

//Valida si es la fecha ==               
            DateQuery dateQuery2 = new DateQuery.Builder().
                    field("fechanacimiento")
                    .start(new Date())
                    .comparison(Comparison.EQ)
                    .build();

            Bson filterDate = repository.queryCreateDate(dateQuery1);
            System.out.println("-----------DOCUMENTO GENERADO SIMPLE-------");
            System.out.println(filterDate);

            filterDate = repository.queryCreateDate(dateQuery2);
            System.out.println("-----------DOCUMENTO GENERADO COMPUESTO-------");
            System.out.println(filterDate);
        } catch (Exception e) {
            System.out.println("---error " + e.getLocalizedMessage());
        }

//        if(jw.getJmoordbWhere().getJmoordbWhere().getJmoordbWhere().getJmoordbWhere().get !=null){
//           
//        }
    }

}
