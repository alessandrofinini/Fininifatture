/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eccezioni;

/**
 *
 * @author pc hp
 */
public class CodiceNonValido extends Exception
{
   
   public String toString()
    {
        String s="";
        s+="Il codice inserito non è esistente";
        return s;
    } 

}
