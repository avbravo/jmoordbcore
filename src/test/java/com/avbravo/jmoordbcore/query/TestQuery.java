/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.query;

import com.avbravo.jmoordbcore.annotations.Repository;
import com.avbravo.jmoordbcore.enumeration.Comparison;
import com.avbravo.jmoordbcore.enumeration.Logic;
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
public class TestQuery implements Serializable{
@Inject 
Repository repository;
    private static String ordenacion = "";

    /**
     * @param args the command line arguments
     */
    public  void test(){
        // TODO code application logic here
        try {
           // Repository repository = new Repository();

            
            /*
            Restricion
            */
            Query query = new Query.Builder().
                    field("iddepartament")
                    .comparison(Comparison.EQ)
                    .value(2)
                    .build();
            repository.analizeQuery(query);
System.out.println("====================================");
            Query queryString = new Query.Builder().
                    field("username")
                    .comparison(Comparison.EQ)
                    .value("avbravo")
                    .build();
            
            repository.analizeQuery(queryString);
            System.out.println("====================================");
            // username="avbravo and active = true
            Query queryCombined = new Query.Builder().
                    field("username10")
                    .comparison(Comparison.EQ)
                    .value("avbravo")
                    .query(new Query.Builder().
                                    field("active10")
                                    .comparison(Comparison.EQ)
                                    .value(false)
                                    .build()
                    )
                    .build();
            
              repository.analizeQuery(queryCombined);
              System.out.println("====================================");
            // username="avbravo and active = true or photo != ""
            Query queryCombined3 = new Query.Builder().
                    field("username20")
                    .comparison(Comparison.EQ)
                    .value("avbravo")
                    .query(new Query.Builder().
                                    field("active20")
                                    .comparison(Comparison.EQ)
                                    .value(false)
                                    .query(new Query.Builder().
                                                    field("photo20")
                                                    .comparison(Comparison.NE)
                                                    .value("")
                                                    .build()
                                    ).build()
                    ).build();
     repository.analizeQuery(queryCombined3);
            System.out.println("====================================");
            /*
            FECHAS
            
             */
            ///1--------------QUERY SOLO CON FECHAS
            Query queryCombinedDate = new Query.Builder().
                    dateQuery(new DateQuery.Builder().
                            field("fecha30")
                            .start(new Date())
                            .comparison(Comparison.BETWEEN) 
                            .end(new Date())
                            .excludedHours(true)
                            .build()
                    ).build();
     repository.analizeQuery(queryCombinedDate);
     System.out.println("====================================");
     
            //2 username = "avbravo and datequery () en el mismo query
            Query queryCombinedDate2 = new Query.Builder().
                    field("username40")
                    .comparison(Comparison.EQ)
                    .value("avbravo")
                    .binary(Logic.AND)
                    .dateQuery(new DateQuery.Builder().
                            field("fecha40")
                            .start(new Date())
                            .comparison(Comparison.BETWEEN)
                            .end(new Date())
                            .excludedHours(true)
                            .build()
                    ).build();
            
                repository.analizeQuery(queryCombinedDate2);
                System.out.println("====================================");
            //3 username = "avbravo and datequery () en el mismo query
            Query queryCombinedDate3 = new Query.Builder().
                    field("username50")
                    .comparison(Comparison.EQ)
                    .value("avbravo")
                    .binary(Logic.AND)
                    .query(new Query.Builder().
                                    dateQuery(new DateQuery.Builder().
                                            field("fecha51")
                                            .start(new Date())
                                            .comparison(Comparison.BETWEEN)
                                            .end(new Date())
                                            .excludedHours(true)
                                            .build()
                                    ).build()
                    ).build();
 repository.analizeQuery(queryCombinedDate3);
 System.out.println("====================================");
 
            // username = "avbravo and datequery () y activo = true
            Query queryCombinedDate4 = new Query.Builder().
                    field("username60")
                    .comparison(Comparison.EQ)
                    .value("avbravo")
                    .binary(Logic.AND)
                    .query(new Query.Builder().
                                    field("active60")
                                    .comparison(Comparison.EQ)
                                    .value(true)
                                    .binary(Logic.AND)
                                    .dateQuery(new DateQuery.Builder().
                                            field("fecha60")
                                            .start(new Date())
                                            .comparison(Comparison.BETWEEN)
                                            .end(new Date())
                                            .excludedHours(true)
                                            .build()
                                    ).build()
                    ).build();
 repository.analizeQuery(queryCombinedDate4);
            System.out.println("====================================");
            /*
            Restricion
            */
            //2 username = "avbravo and datequery () en el mismo query
            Query queryRestringuido = new Query.Builder().
                    field("username70")
                    .comparison(Comparison.EQ)
                    .value("avbravo")
                    .binary(Logic.AND)
                    .dateQuery(new DateQuery.Builder().
                            field("fecha70")
                            .start(new Date())
                            .comparison(Comparison.BETWEEN)
                            .end(new Date())
                            .excludedHours(true)
                            .build()
                     
                    )
                    .query(new Query.Builder().
                                    field("active70")
                                    .comparison(Comparison.EQ)
                                    .value(false)
                                    .build()                          
                    ).build();
            
            repository.analizeQuery(queryRestringuido);
            System.out.println("====================================");
            /**
             * 
             */
           //Query vacio
           Query empty = new Query.Builder().build();
           
            
        } catch (Exception e) {
            System.out.println("---error " + e.getLocalizedMessage());
        }

//        if(jw.getJmoordbWhere().getJmoordbWhere().getJmoordbWhere().getJmoordbWhere().get !=null){
//           
//        }
    }

   
}
