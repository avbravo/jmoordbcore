/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.annotations;

import com.avbravo.jmoordbcore.pagination.Pagination;
import com.avbravo.jmoordbcore.query.DateQuery;
import com.avbravo.jmoordbcore.query.Query;
import com.avbravo.jmoordbcore.sorter.Sorter;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface Repository {

    public void findBy(Query query, Pagination pagination, Sorter sorter);

    public void findBy(Query query);

    public Document queryCreateSort(Sorter sorter);

    public Bson queryCreateDate(DateQuery dateQuery);

    public Document analizeQuery(Query query);

    public void convertirdatos();
}
