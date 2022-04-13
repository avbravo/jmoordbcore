/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbcore.pagination;

/**
 *
 * @author avbravo
 */
public class Pagination {
    private Integer page;
    private Integer rowForPages;
    private Integer size;

    public Pagination() {
    }

    public Pagination(Integer page, Integer rowForPages, Integer size) {
        this.page = page;
        this.rowForPages = rowForPages;
        this.size = size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRowForPages() {
        return rowForPages;
    }

    public void setRowForPages(Integer rowForPages) {
        this.rowForPages = rowForPages;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
    
     public static class Builder {
   private Integer page;
    private Integer rowForPages;
    private Integer size;


        public Builder withPage(Integer page) {
            this.page= page;
            return this;
        }
        public Builder withRowForPages(Integer rowForPages) {
            this.rowForPages = rowForPages;
            return this;
        }
        public Builder withSize(Integer size) {
            this.size = size;
            return this;
        }

      

        public Pagination build() {
            return new Pagination(page, rowForPages, size);
        }

    }
    
}
