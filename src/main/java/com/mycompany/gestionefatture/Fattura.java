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
 *  è la classe che contiene l'array di tipo Cliente
 * contiene i metodi necessari per gestire una fattura
 * i suoi attributi sono:<br>
 * elencoFatture: è un array di oggetti di classe Cliente 
 * NUM_MAX_FATTURE: attributo statico,è una costante, rappresenta il numero massimo delle fatture=100
 * nFatturePresenti: è un contatore che conta il numero di fatture presenti nell'array
 * @author pc hp
 */
public class Fattura implements Serializable
{
    private Cliente[] elencoFatture;
    private int nFatturePresenti=0;
    private final static int N_MAX_FATTURE=100; 
    /**
     * Costruttore di default(istanzia un array di tipo Cliente)
     */
     public Fattura()
    {
        elencoFatture=new Cliente[N_MAX_FATTURE];  
        
    }
    //return 1 : numero massimo di fatture raggiunte
    //return 0 : fattura aggiunta correttamente
     
     
     /**
     * Costruttore di copia. Consente di istanziare una nuova Fattura,
     * copiando un altro oggetto di classe Fattura
     * copia dell' Fattura passata come parametro
     * @param f oggetto di classe Fattura da cui effettuare la copia
     */
         public Fattura(Fattura f)
    {
        elencoFatture=new Cliente[N_MAX_FATTURE];  
        for(int i=0;i<N_MAX_FATTURE;i++)
        {
            elencoFatture[i]=f.getFattura(i);
        }
         nFatturePresenti++;
         
    }
   

    /**
     * Metodo getter dell'array di oggetti di classe Cliente elencoFatture
     * inserendo la posizione dell'oggetto che vogliamo visualizzare
     * Ci permette di visualizzare il contenuto dell'oggetto in posizione posizione
     * @param posizione è la posizione in cui voglio vedere l'oggetto
     * @return Il contenuto dell'array elencoFatture in posizione posizione, sarà un oggetto di classe Cliente
     */
    public Cliente getFattura(int posizione)
    {
        return elencoFatture[posizione];
    }
    
    public int getN_MAX_FATTURE() 
    {
        return N_MAX_FATTURE;
    }
    /**
     * Restituisce il numero di fatture presenti all'array
     * @return 
     */
    public int getnFatturePresenti() 
    {
        return nFatturePresenti;
    }

    /**
     * Aggiunge un ogetto istanziato di tipo Cliente all'array
     * @param c1 c1 è l'oggetto istanziato che sarà aggiunto all'array
     */
    
    public void aggiungiFattura(Cliente c1)
    {
            elencoFatture[nFatturePresenti]=c1;
            nFatturePresenti++;
    }
    /**
     * aggiorna la posizione delle fatture effettuate nell'array
     * @param posizione la posizione serve per modificare l'ordine delle fatture
     */
    private void aggiornaPosizioneFattura(int posizione)
    {
        for (int i=posizione;i<nFatturePresenti-1;i++)
        {
            elencoFatture[i]=elencoFatture[i+1];
        }
        elencoFatture[nFatturePresenti-1]=null;  
        nFatturePresenti--;
    }
      /**
     * Elimina una fattura 
     * @param codice è il codice della fattura da eliminare
     */
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
      /**
     * è il metodo che permette di registrare il pagamento di una fattura
     * @param giorno è il giorno del saldo della fattura
     * @param mese è il mese del saldo della fattura
     * @param anno è l'anno del saldo della fattura
     * @param c1 è il codice che permette di definire quale fattura va pagata
     * @return 
     */
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
     
     /**
     * Visualizzare i dati di tutte le fatture emesse e non ancora pagate
     * #@throws NessunClienteException 
     */ 
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
     /**
     * Visualizza le fatture effettuate da una determinata persona
     * @param nome è il nome della persona di cui si vuole visualizzare le fatture pagate e non pagate
     * @param cognome è il cognome della persona di cui si vuole visualizzare le fatture pagate e non pagate
     */ 
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
     
     /**
     * Esporta in file di testo, in formato csv, tutte le fatture emesse
     * @throws IOException
     * @throws FileException 
     */
   public void esportaInCSV(String nomeFile) throws IOException, FileException
    {
        TextFile f1=new TextFile(nomeFile,'W');
        Cliente cliente;
        for(int i=0;i<nFatturePresenti;i++)
        {
            cliente=elencoFatture[i];
            if(cliente!=null)
            {
                f1.toFile(elencoFatture[i].getCognome()+";"+elencoFatture[i].getNome()+";"+elencoFatture[i].getCodiceIdentificativo()+";"+elencoFatture[i].getPartitaIva()+"\n");
            }
        }
        f1.close();
    }
         /**
     * Salva i dati su un file binario
     * @throws FileNotFoundException
     * @throws IOException 
     */
          public void salvaFattura(String nomeFile) throws FileNotFoundException, IOException
    {
       
        FileOutputStream f=new FileOutputStream("Bin/ Fattura.bin");
        ObjectOutputStream writer=new ObjectOutputStream(f);
        writer.writeObject(this);
        writer.flush();
        writer.close();          
                
    }
                /**
     * Carica i dati su un file binario
     * @throws FileNotFoundException
     * @throws IOException 
     * @throws FileException
     */
   public Fattura caricaFatture(String nomeFile) throws FileNotFoundException, IOException, FileException
    {
        FileInputStream f1=new FileInputStream(nomeFile);
        ObjectInputStream inputStream=new ObjectInputStream(f1); 
        Fattura c;
        try 
        {
            c=(Fattura)inputStream.readObject();
            inputStream.close();
            return c;
        } 
        catch (ClassNotFoundException ex) 
        {
            inputStream.close();
            throw new FileException("Errore nella lettura del file!");
        }
    }
          
          
          
         
         
         
         
    }
  

   


    

            
    
    
    
    
   
    

