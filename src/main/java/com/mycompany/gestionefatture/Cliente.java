/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionefatture;

import java.io.Serializable;
import java.time.LocalDate;

/**
 /**
 * la classe rappresenta un cliente
 * i suoi attributi sono:<br>
 * codiceIdentificativo: codice identificativo della fattura<br>
 * cognome: cognome del cliente<br>
 * nome: nome del cliente <br>
 * partitaIva: indica la partita iva di un cliente<br>
 * importo: indica l'importo da pagare di una fattura<br>
 * dataEmissione: data in cui viene emessa la fattura<br>
 * dataSaldo: data in cui avviene il pagamento della fattura<br>
 * In questa classe vengono inserite tutte le informazioni
 * di una fattura.
 * @author pc hp
 */
public class Cliente implements Serializable
{
    private long codiceIdentificativo;
    private String cognome;
    private String nome;
    private String partitaIva;
   private float importo;
   private LocalDate dataEmissione;
    private LocalDate dataSaldo;
   
    private boolean pagato=false;
   /**
     * Costruttore della classe Cliente 
     * Consente di istanziare una nuovo cliente
     * @param codiceIdentificativo: codice identificativo della fattura
     * @param cognome: cognome del cliente per la fattura da emettere<br>
     * @param nome: nome del cliente per la fattura da emettere <br>
     * @param partitaIva: partitaiva del cleinte peer la emissione di una fattura
     * @param importo:importo della fattura emessa
     * @param anno: anno in cui viene emessa la fattura
     * @param mese: mese in cui viene emessa la fattura
     * @param giorno: giorno in cui viene emessa la fattura
     */

    public Cliente(long codiceIdentificativo, String cognome, String nome, String partitaIva,float importo,int giorno,int mese,int anno) 
    {
        setCodiceIdentificativo(codiceIdentificativo);
        setNome(nome);
        setCognome(cognome);
        setPartitaIva(partitaIva);
        setImporto(importo);
        setDataEmissione(giorno,mese,anno);
        dataSaldo=null;
    }
    /**
     * Costruttore di copia (istanzia oggetti)
     * @param c è un oggetto di tipo auto
     */
   
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
    /**
     * Costruttore vuoto 
     * istanzia oggetti vuoti
     */
    public Cliente()
    {
        this.codiceIdentificativo=0;
        this.cognome=null;
        this.nome=null;
        this.partitaIva=null;
        this.importo=0;
        dataEmissione=null;
        dataSaldo=null;
    }
    /**
     * Restituisce il pagamento della persona che ha emesso una fattura
     * @return il pagamento  della persona che ha emesso una fattura
     */
  public boolean getPagato() 
    {
        return pagato;
    }
    /**
     * Definisce il pagamento di una fattura emessa
     * @param pagato è il pagamento della fattura
     */
    public void setPagato(boolean pagato) 
    {
        this.pagato = pagato;
    }
    /**
     * Definisce l'importo di una fattura emessa
     * @param importo è l'importo della fattura
     */
    public void setImporto(float importo)
    {
        this.importo = importo;
    }
    /**
     * Definisce la data di emissione di una fattura
     * @param giorno è il giorno dell'emissione
     * @param mese è il mese dell'emissione
     * @param anno è l'anno dell'emissione
     */
    public void setDataEmissione(int giorno,int mese,int anno) 
    {
        this.dataEmissione = LocalDate.of(anno, mese, giorno);;
    }
    /**
     * Definisce la data di saldo di una fattura
     * @param giorno è il giorno del saldo
     * @param mese è il mese del saldo
     * @param anno è l'anno del saldo
     * @return 1 : fattura gia pagata, 0 : pagamento avvenuto correttamente
     */
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
     /**
     * Restituisce l'importo della persona che ha emesso una fattura
     * @return l'importo della persona che ha emesso una fattura
     */

    public float getImporto() 
    {
        return importo;
    }
    /**
     * restituisce la data di saldo di una fattura
     * @return la data di saldo di una fattura
     */
    public LocalDate getDataSaldo() 
    {
        return dataSaldo;
    }
 /**
     * restituisce la data di emissione di una fattura
     * @return la data di emissione di una fattura
     */
    public LocalDate getDataEmissione() 
    {
        return dataEmissione;
    }
    

     /**
     * Restituisce il codice identificativo della fattura
     * @return il codice identificativo della fattura
     */
    public long getCodiceIdentificativo() 
    {
        return codiceIdentificativo;
    }
    /**
     * Definisce il codice identificativo di una fattura emessa
     * @param codiceIdentificativo  è il codice identificativo della fattura
     */
    public void setCodiceIdentificativo(long codiceIdentificativo) 
    {
        this.codiceIdentificativo = codiceIdentificativo;
    }
    /**
     * Restituisce il cognome della persona che ha emesso una fattura
     * @return il cognome della persona che ha emesso una fattura
     */
    public String getCognome() 
    {
        return cognome;
    }
    /**
     * Definisce il cognome di colui che vuole emettere una fattura
     * @param cognome è il cognome inserito dall'utente
     */
    public void setCognome(String cognome) 
    {
        this.cognome = cognome;
    }
    /**
     * Restituisce il nome della persona che ha emesso una fattura
     * @return il nome della persona che ha emesso una fattura
     */
    public String getNome() 
    {
        return nome;
    }
    /**
     * Definisce il nome di colui che vuole emettere una fattura
     * @param nome è il cognome inserito dall'utente
     */
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    /**
     * Restituisce la partita iva della persona che ha emesso una fattura
     * @return la partita ivadella persona che ha emesso una fattura
     */
    public String getPartitaIva() 
    {
        return partitaIva;
    }
/**
     * Definisce la partita iva di colui che vuole emettere una fattura
     * @param partitaIva  è il cognome inserito dall'utente
     */
    public void setPartitaIva(String partitaIva) 
    {
        this.partitaIva = partitaIva;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codiceIdentificativo=" + codiceIdentificativo + ", cognome=" + cognome + ", nome=" + nome + ", partitaIva=" + partitaIva + ", importo=" + importo + ", dataEmissione=" + dataEmissione + ", dataSaldo=" + dataSaldo + '}';
    }
    
    


    
    
}
