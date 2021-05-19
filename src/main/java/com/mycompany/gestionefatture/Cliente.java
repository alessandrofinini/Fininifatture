/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionefatture;

/**
 *
 * @author pc hp
 */
public class Cliente 
{
    private long codiceIdentificativo;
    private String cognome;
    private String nome;
    private String partitaIva;
   private Cliente[] clienti;
   

    public Cliente(long codiceIdentificativo, String cognome, String nome, String partitaIva) 
    {
        this.codiceIdentificativo = codiceIdentificativo;
        this.cognome = cognome;
        this.nome = nome;
        this.partitaIva = partitaIva;
    }
    public Cliente(Cliente c)
    {
        codiceIdentificativo=c.getCodiceIdentificativo();
        cognome=c.getCognome();
        nome=c.getNome();
        partitaIva=c.getPartitaIva();
    }
    public Cliente()
    {
        setCodiceIdentificativo(codiceIdentificativo);
        setNome("");
        setCognome("");
    }

    

    public long getCodiceIdentificativo() 
    {
        return codiceIdentificativo;
    }

    public void setCodiceIdentificativo(long codiceIdentificativo) 
    {
        this.codiceIdentificativo = codiceIdentificativo;
    }

    public String getCognome() 
    {
        return cognome;
    }

    public void setCognome(String cognome) 
    {
        this.cognome = cognome;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getPartitaIva() 
    {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) 
    {
        this.partitaIva = partitaIva;
    }
    
    
    public String toString()    
  {
      String s;
      s="Codice identificativo:"+getCodiceIdentificativo()+"\nCognome:"+getCognome()+"\nNome:"+getNome()+"\nPartita Iva:"+getPartitaIva();
      return s;
  }
    
}
