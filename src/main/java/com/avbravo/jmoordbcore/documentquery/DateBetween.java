/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.documentquery;

import java.util.Date;

/**
 *
 * @author avbravo
 */
public class DateBetween {
   private String field;
   private Date start;
   private Date end;
   private Boolean excludedHours;

    public DateBetween(String field, Date start, Date end, Boolean...excludedHours) {
        this.field = field;
        this.start = start;
        this.end = end;
          Boolean l = false;
        if (excludedHours.length != 0) {
            l = excludedHours[0];

        }
        this.excludedHours = l;
    }

    public Boolean getExcludedHours() {
        return excludedHours;
    }

    public void setExcludedHours(Boolean excludedHours) {
        this.excludedHours = excludedHours;
    }

   

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
 
   
}
