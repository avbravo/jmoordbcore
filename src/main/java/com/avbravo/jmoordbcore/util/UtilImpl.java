/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcore.util;

import jakarta.enterprise.context.ApplicationScoped;
import java.io.Serializable;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class UtilImpl implements Util, Serializable{
     // <editor-fold defaultstate="collapsed" desc="nombreEntity(String texto)">
   
   /**
    * obtiene el texto despues del ultimo puento
    * @param texto (com.avbravo.entity.Rol)
    * @return Rol
    */
   public  String nameOfEntity(String name){
       String result="";
          // TODO code application logic here
          try {
       
        Integer pos =name.lastIndexOf(".");

       result = name.substring(pos+1, name.length());

       } catch (Exception e) {
           
       }
        return result;
        
   }
    // </editor-fold>
   
   
    // <editor-fold defaultstate="collapsed" desc="String letterToLower(String texto)">
    /**
     * ConvertirLetraMinuscula
     *
     * @param s_cadena
     * @param caracter
     * @return
     */
    public String letterToLower(String texto) {

        try {

            texto = texto.trim();
            int largo = texto.length();
            if (largo <= 0) {
                return texto;
            }
            String letra = texto.substring(0, 1);

            texto = letra.toLowerCase() + texto.substring(1);
        } catch (Exception ex) {
          ////Test.msg("letterToLower() " + ex.getLocalizedMessage());
        }
        return texto;
    }
    // </editor-fold>
    
}
