/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.documentquery;

import com.avbravo.jmoordbcore.enumeration.Comparison;
import com.avbravo.jmoordbcore.sorter.Sorter;
import java.util.Date;

/**
 *
 * @author avbravo
 * https://avbravo-2.gitbook.io/jmoordb/capitulo-4/introduccion-cap4/busquedas-con-filter
 */
public class DocumentQuery {

    private String field;
    private AND AND;
    private EQ EQ;
    private NE NE;
    private OR OR;

    private DateBetween dateBetween;
    private DateComparision dateComparision;
    private Sorter sorter;
    private BEGIN begin;
    private END end;

    public DocumentQuery() {
    }

    public DocumentQuery(String field, AND AND, EQ EQ, NE NE, OR OR, DateBetween dateBetween, DateComparision dateComparision, Sorter sorter, BEGIN begin, END end) {
        this.field = field;
        this.AND = AND;
        this.EQ = EQ;
        this.NE = NE;
        this.OR = OR;
        this.dateBetween = dateBetween;
        this.dateComparision = dateComparision;
        this.sorter = sorter;
        this.begin = begin;
        this.end = end;
    }

    
    
    public BEGIN getBegin() {
        return begin;
    }

    public void setBegin(BEGIN begin) {
        this.begin = begin;
    }

    public END getEnd() {
        return end;
    }

    public void setEnd(END end) {
        this.end = end;
    }

   
    

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public AND getAND() {
        return AND;
    }

    public void setAND(AND AND) {
        this.AND = AND;
    }

    public EQ getEQ() {
        return EQ;
    }

    public void setEQ(EQ EQ) {
        this.EQ = EQ;
    }

    public NE getNE() {
        return NE;
    }

    public void setNE(NE NE) {
        this.NE = NE;
    }

    public OR getOR() {
        return OR;
    }

    public void setOR(OR OR) {
        this.OR = OR;
    }

   

    public DateBetween getDateBetween() {
        return dateBetween;
    }

    public void setDateBetween(DateBetween dateBetween) {
        this.dateBetween = dateBetween;
    }

    public DateComparision getDateComparision() {
        return dateComparision;
    }

    public void setDateComparision(DateComparision dateComparision) {
        this.dateComparision = dateComparision;
    }

    public Sorter getSorter() {
        return sorter;
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

   

  

 

    public static class Builder {
       private String field;
    private AND AND;
    private EQ EQ;
    private NE NE;
    private OR OR;

    private DateBetween dateBetween;
    private DateComparision dateComparision;
    private Sorter sorter;

  private BEGIN begin;
    private END end;

        public Builder field(String field) {
            this.field = field;
            return this;
        }

       

        public Builder BEGIN() {
            this.begin = new BEGIN();
            return this;
        }
        public Builder END() {
            this.end = new END();
            return this;
        }

        public Builder AND() {
            this.AND = new AND();
            return this;
        }

        public Builder OR() {
            this.OR = new OR();
            return this;
        }

        public Builder EQ(Object value) {
            this.EQ = new EQ(value);
            return this;
        }

        public Builder NE(Object value) {
            this.NE = new NE(value);
            return this;
        }

        public Builder dateBetween(String field, Date start, Date end, Boolean... excludedHours) {
            this.dateBetween = new DateBetween(field, start, end, excludedHours);
            return this;
        }

        public Builder dateComparision(String field, Comparison comparision, Date value, Boolean... excludedHours) {
            this.dateComparision = new DateComparision(field, comparision, value);
            return this;
        }

        public DocumentQuery build() {
            return new DocumentQuery(field, AND, EQ, NE, OR, dateBetween, dateComparision, sorter, begin, end);
        }

    }
}
