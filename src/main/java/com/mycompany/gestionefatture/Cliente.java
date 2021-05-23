/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionefatture;

import java.time.LocalDate;

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
   private float importo;
   private LocalDate dataSaldo;
    private LocalDate dataEmissione;
    private float importoemissione=0;
    private boolean pagato=false;
  

    public Cliente(long codiceIdentificativo, String cognome, String nome, String partitaIva,int giorno,int mese,int anno) 
    {
        setCodiceIdentificativo(codiceIdentificativo);
        setNome(nome);
        setCognome(cognome);
        setPartitaIva(partitaIva);
        setImporto(importo);
        setDataEmissione(giorno,mese,anno);
        dataSaldo=null;
    }

   
    public Cliente(Cliente c)
    {
        codiceIdentificativo=c.getCodiceIdentificativo();
        cognome=c.getCognome();
        nome=c.getNome();
        partitaIva=c.getPartitaIva();
       importo=c.getImporto();
       dataEmissione=c.getDataEmissione();
       dataSaldo=c.getDataSaldo();
    }
    
    public Cliente()
    {
        codiceIdentificativo=0;
        cognome=null;
        nome=null;
        partitaIva=null;
        importo=0;
        dataEmissione=null;
        dataSaldo=null;
    }
 public boolean getPagato() {
        return pagato;
    }

    public void setPagato(boolean pagato) {
        this.pagato = pagato;
    }
    public void setImporto(float importo) {
        this.importo = importo;
    }

    public void setDataEmissione(int giorno,int mese,int anno) 
    {
        this.dataSaldo = LocalDate.of(anno, mese, giorno);;
    }

     public int setDataSaldo(int giorno,int mese, int anno) 
    {
        if(pagato)
        {
            return 1;
        }
        else
        {
            this.dataSaldo = LocalDate.of(anno, mese, giorno);
            pagato=true;
            return 0;
        }
        
    }
      public void setImportoemissione(float importoemissione) 
      {
        this.importoemissione = importoemissione;
    }

    public float getImporto() 
    {
        return importo;
    }

    public LocalDate getDataSaldo() 
    {
        return dataSaldo;
    }

    public LocalDate getDataEmissione() 
    {
        return dataEmissione;
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
      s="Codice identificativo:"+getCodiceIdentificativo()+"\nCognome:"+getCognome()+"\nNome:"+getNome()+"\nPartita Iva:"+getPartitaIva()+"\nImporto:"+getImporto()+"\nDataEmissione:"+getDataEmissione();
      return s;
  }

    
    
}
