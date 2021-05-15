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
public class Fattura 
{
    private String nomeCliente;
    private String cognomeCliente;
    private long codiceIdentificativoProgressivo;
    private String partitaIva;
    private float importo;
    private Cliente[] cliente;
    private int nClientiPresenti;
    private final int N_MAX_CLIENTI=100; 

    public Fattura(String nome, String cognome, long codiceIdentificativoProgressivo, String partitaIva) 
    {
        this.nomeCliente = nome;
        this.cognomeCliente = cognome;
        this.codiceIdentificativoProgressivo = codiceIdentificativoProgressivo;
        this.partitaIva = partitaIva;
    }
     public Fattura(Fattura f)
    {
        setCodiceIdentificativoProgressivo(codiceIdentificativoProgressivo);
        setNome("");
        setCognome("");
        
        nClientiPresenti=0;
    }
    

    public String getNome() 
    {
        return nomeCliente;
    }

    public void setNome(String nome)
    {
        this.nomeCliente = nome;
    }

    public String getCognome() 
    {
        return cognomeCliente;
    }

    public void setCognome(String cognome) 
    {
        this.cognomeCliente = cognome;
    }

    public long getCodiceIdentificativoProgressivo() 
    {
        return codiceIdentificativoProgressivo;
    }

    public void setCodiceIdentificativoProgressivo(long codiceIdentificativoProgressivo) 
    {
        this.codiceIdentificativoProgressivo = codiceIdentificativoProgressivo;
    }

    public String getPartitaIva() 
    {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) 
    {
        this.partitaIva = partitaIva;
    }

    public float getImporto() 
    {
        return importo;
    }

    public void setImporto(float importo) 
    {
        this.importo = importo;
    }

    public int getnClientiPresenti() 
    {
        return nClientiPresenti;
    }

    public void setnClientiPresenti(int nClientiPresenti) 
    {
        this.nClientiPresenti = nClientiPresenti;
    }
    
     public long getCliente(long codiceIdentificativoProgressivo)
    {
        return codiceIdentificativoProgressivo;
    }
    
    public int aggiungiCliente(Cliente cliente)
    {
        if (nClientiPresenti>N_MAX_CLIENTI)
            return -1;      //LA CLASSE HA RAGGIUNTO IL NUMERO MASSIMO DI 
        elencoClienti[nClientiPresenti]=new Cliente(cliente.getcodiceIdentificativoProgressivo,cliente.getCognome(),cliente.getNome());
        nClientiPresenti++;
        return 0;
    }
    
    //metodo che consente di modificare i dati anagrafici di uno studente della classe
    // -1 --> studente non presente
    //  0 --> ok
    
    
    
    
    
    public String elencoClienti()
    {
        String s;
        if(nClientiPresenti==-1)
            s="nessun cliente presente";
        else
      s="Cliente:"+getCliente(codiceIdentificativoProgressivo);
      return s;
    }
    
}
