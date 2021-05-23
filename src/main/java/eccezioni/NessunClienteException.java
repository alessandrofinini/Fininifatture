/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eccezioni;

/**
 *
 * @author Federico Bonomi
 */
public class NessunClienteException extends Exception 
{
    public String toString()
    {
        return "Nessun cliente inserito";
    }
    
    public String toString(String nome, String cognome)
    {
        return "Nessuna fattura a nome: "+nome+" "+cognome;
    }
}
