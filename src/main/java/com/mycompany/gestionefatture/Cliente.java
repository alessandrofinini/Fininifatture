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
    private int nFatturePresenti;
    private Fattura[] fatture;
    private final int N_MAX_FATTURE=10;

    public Cliente(long codiceIdentificativo, String cognome, String nome, String partitaIva) 
    {
        this.codiceIdentificativo = codiceIdentificativo;
        this.cognome = cognome;
        this.nome = nome;
        this.partitaIva = partitaIva;
    }
    public Cliente(Cliente c)
    {
        setCodiceIdentificativo(codiceIdentificativo);
        setNome("");
        setCognome("");
        fatture=new Fattura[N_MAX_FATTURE];
        nFatturePresenti=0;
    }
    public Cliente()
    {
        
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

    public int getnFatturePresenti() 
    {
        return nFatturePresenti;
    }

    public void setnFatturePresenti(int nFatturePresenti) 
    {
        this.nFatturePresenti = nFatturePresenti;
    }

    public Fattura[] getFatture() 
    {
        return fatture;
    }

    public void setFatture(Fattura[] fatture) 
    {
        this.fatture = fatture;
    }
    
    public String toString()    
  {
      String s;
      s="Codice identificativo:"+getCodiceIdentificativo()+"\nCognome:"+getCognome()+"\nNome:"+getNome();
      return s;
  }
    
}
