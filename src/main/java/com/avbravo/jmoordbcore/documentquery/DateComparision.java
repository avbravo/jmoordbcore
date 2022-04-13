/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.documentquery;

import com.avbravo.jmoordbcore.enumeration.Comparison;
import java.util.Date;

/**
 *
 * @author avbravo
 */
public class DateComparision {

    private String field;
    Comparison comparision;
    private Date value;
    private Boolean excludedHours;

    public DateComparision(String field, Comparison comparision, Date value, Boolean... excludedHours) {
        this.field = field;
        this.comparision = comparision;
        this.value = value;
        Boolean l = false;
        if (excludedHours.length != 0) {
            l = excludedHours[0];

        }
        this.excludedHours =l;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Comparison getComparision() {
        return comparision;
    }

    public void setComparision(Comparison comparision) {
        this.comparision = comparision;
    }

    public Date getValue() {
        return value;
    }

    public void setValue(Date value) {
        this.value = value;
    }

}
