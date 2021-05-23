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
public class CodiceVuoto extends Exception
{
    private int codice;

    public CodiceVuoto(int codice) 
    {
        this.codice = codice;
    }

    public int getCodice() 
    {
        return codice;
    }
    public String toString()
    {
        String s="";
        s+="Il codice emesso:"+getCodice()+"  è vuoto.";
        return s;
    }
}
