/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionefatture;

import java.io.IOException;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import eccezioni.*;
import file.TextFile;


/**
 *
 * @author pc hp
 */
public class Fattura 
{
    
    
    private Cliente[] elencoFatture;
    private int fattureTot=0;
    private int nFatturePresenti=0;
    private final int N_MAX_FATTURE=100; 
        
    
   
    

   
     public Fattura()
    {
        elencoFatture=new Cliente[N_MAX_FATTURE];  
        
    }
         public Fattura(Fattura f)
    {
        elencoFatture=new Cliente[N_MAX_FATTURE];  
        for(int i=0;i<N_MAX_FATTURE;i++)
        {
            elencoFatture[i]=f.getFattura(i);
        }
         nFatturePresenti++;
         
    }
   

    public Cliente[] getElencoFatture() 
    {
        return elencoFatture;
    }
    public Cliente getFattura(int posizione)
    {
        return elencoFatture[posizione];
    }
    public int getN_MAX_FATTURE() 
    {
        return N_MAX_FATTURE;
    }

 

    public int getnFatturePresenti() 
    {
        return nFatturePresenti;
    }

    public void setnFatturePresenti(int nFatturePresenti) 
    {
        this.nFatturePresenti = nFatturePresenti;
    }

 
    
    
    
    public void aggiungiFattura(Cliente c1)
    {
            elencoFatture[nFatturePresenti]=c1;
            nFatturePresenti++;
    }
   
    
    private void aggiornaPosizioneFattura(int posizione)
    {
        for (int i=posizione;i<nFatturePresenti-1;i++)
        {
            elencoFatture[i]=elencoFatture[i+1];
        }
        elencoFatture[nFatturePresenti-1]=null;  
        nFatturePresenti--;
    }
    public int rimuoviFattura(int codice) throws CodiceNonValido
    {
        int f=0;
         for(int i=0; i<N_MAX_FATTURE; i++) 
        {
            if(elencoFatture[i]!=null && elencoFatture[i].getCodiceIdentificativo()==codice) 
            {
                elencoFatture[i]=null;
                aggiornaPosizioneFattura(i);
                return 0;
            }
            else if(elencoFatture[i].getCodiceIdentificativo()!=codice)
                    {
                        f++;
                    }
           
                
        }
         if(f==nFatturePresenti)
            throw new CodiceNonValido(); 
        return -1;
    
    }
        
     public int saldoNuovaFattura(int giorno, int mese, int anno, int c1)
    {
        int risultato;
        
        for(int i=0;i<nFatturePresenti;i++)
            {
                if(elencoFatture[i].getCodiceIdentificativo()==c1)
                {
                    risultato=elencoFatture[i].setDataSaldo(giorno,mese,anno);
                    
                    if(risultato==1)
                    {
                        return 1;
                    }
                    else
                    {
                        return 0;
                    }
                        
                }
                        
            }
        return 2;
         
    }
   public void visualizzaDatiCliente() throws NessunClienteException
    {
        if(nFatturePresenti==0)
            throw new NessunClienteException();
        for(int i=0;i<nFatturePresenti;i++)
        {
            System.out.println(elencoFatture[i].toString());
        }
        System.out.println("\n");
    }
   
     public void visualizzaFattureDiUnaPersona(String nome,String cognome)
    {
        System.out.println("Fatture di un determinato cliente: ");
        for (int i=0;i<nFatturePresenti;i++)
        {
            if(elencoFatture[i].getNome().compareToIgnoreCase(nome)==0 && elencoFatture[i].getCognome().compareToIgnoreCase(cognome)==0)
            {
                System.out.println("Codice: "+elencoFatture[i].getCodiceIdentificativo()+" , "+"Partita iva: "+elencoFatture[i].getPartitaIva()+" , "+";");
            }
        }
    }
         public void esportaInCSV()throws IOException,FileException
    {
        TextFile f1=new TextFile("Salvataggio.txt",'W',true);

        for(int i=0;i<getnFatturePresenti();i++)
        {
            if(elencoFatture[i]!=null)
            {
                f1.toFile(elencoFatture[i].getCodiceIdentificativo()+";"+";"+elencoFatture[i].getCognome()+";"+elencoFatture[i].getNome()+";"+elencoFatture[i].getPartitaIva()+";"+elencoFatture[i].getImporto()+";"+elencoFatture[i].getDataEmissione()+";"+elencoFatture[i].getDataSaldo()+";\n");
            }
        } 
        f1.close();
    }
          public void salvaFattura() throws FileNotFoundException, IOException
    {
       
        FileOutputStream f1=new FileOutputStream("Bin/ Fattura.bin");
        ObjectOutputStream writer=new ObjectOutputStream(f1);
        writer.writeObject(this);
        writer.flush();
        writer.close();          
                
    }
          
   public Fattura caricaFattura(String nomeFile) throws IOException, FileException
     {
        Fattura f=null;
        
        
        try
        {
            FileInputStream f1=new FileInputStream(nomeFile);
            ObjectInputStream reader=new ObjectInputStream(f1);
            try
            {
                f=(Fattura)reader.readObject();
                reader.close();
                System.out.println("\nLettura da file avvevuta correttamente");

            }
            catch(ClassNotFoundException ex)
            {
                reader.close();
                System.out.println("\nErrore nella lettura");
            }
        }
        catch(IOException ex)
        {
            System.out.println("\nImpossibile accedere al file");
        }
        
        return f;
     }
          
          
          
         
         
         
         
    }
  

   


    

            
    
    
    
    
   
    

