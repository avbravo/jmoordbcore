/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.repository;

import com.avbravo.jmoordbcore.annotations.Repository;
import com.avbravo.jmoordbcore.enumeration.Comparison;
import com.avbravo.jmoordbcore.pagination.Pagination;
import com.avbravo.jmoordbcore.query.DateQuery;
import com.avbravo.jmoordbcore.query.Query;
import com.avbravo.jmoordbcore.sorter.Sort;
import com.avbravo.jmoordbcore.sorter.Sorter;
import com.mongodb.client.model.Filters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import org.bson.Document;
import org.bson.conversions.Bson;


/**
 *
 * @author avbravo
 */
@ApplicationScoped
@Named
public class RepositoryImpl implements Repository, Serializable {

    Document querySorter = new Document();
    Document querySearch = new Document();

    Bson filterDate;

    @Override
    public void findBy(Query query, Pagination pagination, Sorter sorter) {
        //Siempre invocarlo por el finddBy para que limpie documente
        querySearch = new Document();
        querySorter = new Document();

    }
@Override
    public void findBy(Query query) {
        //Siempre invocarlo por el finddBy para que limpie documente
        querySearch = new Document();
        querySorter = new Document();
        try {
        

        } catch (Exception e) {
            System.out.println("error " + e.getLocalizedMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Document queryCreateSort(Sorter sorter)">
    /**
     * para query devuelve un Document sort
     *
     * @return
     */
    @Override
    public Document queryCreateSort(Sorter sorter) {
        try {

            if (sorter.getSort().equals(Sort.ASC)) {
                querySorter.append(sorter.getField(), 1);
            } else {
                if (sorter.getSort().equals(Sort.DESC)) {
                    querySorter.append(sorter.getField(), -1);
                }
            }

            if (sorter.getSorter() == null) {

                return querySorter;
            } else {
                return queryCreateSort(sorter.getSorter());
            }
        } catch (Exception e) {
            System.out.println("---genSort( " + e.getLocalizedMessage());
        }
        return querySorter;
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Bson queryCreateDate(DateQuery dateQuery)">

    /**
     * para query devuelve un Document sort
     *
     * @return
     */
    @Override
    public Bson queryCreateDate(DateQuery dateQuery) {
        try {

            if (dateQuery.getComparision().equals(Comparison.EQ)) {

                filterDate = Filters.and(Filters.gte(dateQuery.getField(), dateQuery.getStart()),
                        Filters.lte(dateQuery.getField(), dateQuery.getStart()));
            } else {
                if (dateQuery.getComparision().equals(Comparison.BETWEEN)) {
                    filterDate = Filters.and(Filters.gte(dateQuery.getField(), dateQuery.getStart()),
                            Filters.lte(dateQuery.getField(), dateQuery.getEnd()));
                }
            }

        } catch (Exception e) {
            System.out.println("queryCreateDate() " + e.getLocalizedMessage());
        }
        return filterDate;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Document queryCreateSort(Sorter sorter)">
    /**
     * para query devuelve un Document sort
     *
     * @return
     */
    @Override
    public Document analizeQuery(Query query) {
        try {
            if (query.getField() == null || query.getField().equals("")) {
                System.out.println("1...(N)o Field");
                if (query.getDateQuery() == null) {
                    System.out.println("1.1--- (N)o Field (No)Date Qyery");
                    if (query.getQuery() == null) {
                        System.out.println("1.2... (N)o Field (No)Date Qyery (No)Query ");
                    } else {
                        System.out.println("1.3... (N)o Field (No)Date Qyery (Si)Query");
                        analizeQuery(query.getQuery());
                    }
                } else {
                    //tiene DateQuery
                    System.out.println("1.4  (N)o Field  (Si) DataQuery");
                    if (query.getQuery() == null) {
                        System.out.println("1.5+++(N)o Field  (Si) DataQuery (No)Query");
                    } else {
                        System.out.println("1.6**** (N)o Field  (Si) DataQuery (Si)Query invoco query ");
                             analizeQuery(query.getQuery());
                    }
                }

            } else {
              
                System.out.println("2.>>> (Si) Field --------> Field name= "+query.getField());
                if (query.getDateQuery() == null) {
                    System.out.println("2.1>>> (Si) Field (No) dataQuery");
                    if (query.getQuery() == null) {
                        System.out.println("2.2>>>(Si) Field (No)dataQuery (No) Query");
                    } else {
                        System.out.println("2.3>>>(Si) Field  (No)dataQuery (Si) Query invoco query");
                             analizeQuery(query.getQuery());
                    }
                } else {
                    System.out.println("2,4>>> (Si) Field  (Si)dataQuery");
                    if(query.getQuery()==null){
                        System.out.println("2.5 (Si) Field  Si)dataQuery  (No)qyery");
                    }else{
                        System.out.println("2.6 (Si) Field  (Si)dataQuery  (Si)dataquery invoco query");
                             analizeQuery(query.getQuery());
                    }
                }
            }
            
            

//            if (sorter.getSort().equals(Sort.ASC)) {
//                querySorter.append(sorter.getField(), 1);
//            } else {
//                if (sorter.getSort().equals(Sort.DESC)) {
//                    querySorter.append(sorter.getField(), -1);
//                }
//            }
//
//            if (sorter.getSorter() == null) {
//
//                return querySorter;
//            } else {
//                return queryCreateSort(sorter.getSorter());
//            }
        } catch (Exception e) {
            System.out.println("---genSort( " + e.getLocalizedMessage());
        }
        return querySorter;
    }// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="void convertirdatos()">

    @Override
    public void convertirdatos(){
//            if (q.getValue() instanceof String) {
//                System.out.println(" es string " + q.getValue().toString());
//            } else {
//                if (q.getValue() instanceof Integer) {
//                    Integer i = ((Integer) q.getValue()).intValue();
//                    System.out.println(" es entero " + i);
//                } else {
//                    if (q.getValue() instanceof Date) {
////                      Date createdDate = (Date) q.getValue[]; 
////                        System.out.println("es fecha "+);
//                    } else {
//                        if (q.getValue() instanceof Double) {
//                            Double d = ((Double) q.getValue()).doubleValue();
//                            System.out.println(" es double " + d);
//                        } else {
//                            if (q.getValue() instanceof Boolean) {
//                                Boolean di = ((Boolean) q.getValue()).booleanValue();
//                                System.out.println(" es BOLEAN " + di);
//                            }
//
//                        }
//                    }
//                }
//            }
    }
        // </editor-fold>
}
