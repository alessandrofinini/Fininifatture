/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionefatture;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author pc hp
 */
public class Fattura 
{
    
    private float importo;
    private Fattura[] elencoFatture;
    private int fattureTot=0;
    private int nFatturePresenti=0;
    private final int N_MAX_FATTURE=100; 
    private LocalDate dataSaldo;
    private LocalDate dataEmissione;
   
    

    public Fattura(float importo,int anno,int mese, int giorno) 
    {
       
        this.importo=importo;
        this.dataEmissione=LocalDate.of(anno,mese,giorno);
        this.dataSaldo=LocalDate.of(anno,mese,giorno);
        
    }
     public Fattura()
    {
        elencoFatture=new Fattura[N_MAX_FATTURE];  
        nFatturePresenti=0;
    }

    public LocalDate getDataSaldo() 
    {
        return dataSaldo;
    }

   

    public LocalDate getDataEmissione()
    {
        return dataEmissione;
    }

   
     public Fattura(Fattura f)
     {
         
         dataEmissione=f.getDataEmissione();
         dataSaldo=f.getDataSaldo();
         importo=f.getImporto();
                 
     }
    

    

    public float getImporto() 
    {
        return importo;
    }

    public void setImporto(float importo) 
    {
        this.importo = importo;
    }

    public int getnFatturePresenti() 
    {
        return nFatturePresenti;
    }

    public void setnFatturePresenti(int nFatturePresenti) 
    {
        this.nFatturePresenti = nFatturePresenti;
    }

 
    
     public long getCliente(long codiceIdentificativoProgressivo)
    {
        return codiceIdentificativoProgressivo;
    }
    
    public int aggiungiFattura(Fattura f)
    {
        int i=0;
        if(nFatturePresenti<0||nFatturePresenti>100)
        {
            System.out.println("IL NUMERO DI FATTURE TOTALI E' SOPRA IL NUMERO MASSIMO");
            return i=-1;
        }
        elencoFatture[nFatturePresenti]=new Fattura(f);
        nFatturePresenti++;
        fattureTot++;
        return i;//fattura inserita correttamente
    }
   
    
    
    public int rimuoviFattura(int codice)
    {
        
        try
        {
            if(elencoFatture[codice]==null)
                return -2; 
            elencoFatture[codice]=null;
                return codice;
        }
        catch(ArrayIndexOutOfBoundsException codiceNonValido)
        {
            return -1;
        }
        
    }

    @Override
    public String toString() {
        return "Fattura{" + "importo=" + importo + ", dataSaldo=" + dataSaldo + ", dataEmissione=" + dataEmissione + '}';
    }

    

            
    
    
    
    
   
    
}
