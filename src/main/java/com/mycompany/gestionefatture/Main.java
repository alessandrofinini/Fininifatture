/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionefatture;

import eccezioni.*;
import java.io.IOException;


import java.util.InputMismatchException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author pc hp
 */
public class Main 
{
    public static void main(String[] args) throws FileException, CodiceNonValido 
    {
        Fattura f=new Fattura();
        String nomeFileTesto="fatture.txt";
        String nomeFileBinario="fatture.bin";
        String[] vociMenu=new String[8];
        int sceltaUtente=0;
        Scanner tastiera=new Scanner(System.in);
        Cliente cliente = null;
        int codice,esitoOperazione,nFatturePresenti=0;
        int giorno=0,mese=0,anno=0;
        
        
        vociMenu[0]="ESCI DALL'APPLICAZIONE";
        vociMenu[1]="NUOVA FATTURA";
        vociMenu[2]="ELIMINA FATTURA IN BASE AL CODICE";
        vociMenu[3]="PAGAMENTO DI UNA NUOVA FATTURA";
        vociMenu[4]="VISUALIZZAZIONE DATI FATTURE";
        vociMenu[5]="VISUALIZZA TUTTE LE FATTURE INSERENDO IL NOMINATIVO DEL CLIENTE ";
        vociMenu[6]="ESPORTAZIONE IN FILE CSV";
        vociMenu[7]="SALVATAGGIO E CARICAMENTO IN FILE BINARIO";
         
      try
        {
            f=f.caricaFatture(nomeFileBinario);
            System.out.println("Dati caricati correttamente!");
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Impossibile accedere al file, i dati non sono stati caricati!");
        }
        catch(FileException ex)
        {
            System.out.println("Errore di lettura, i dati non sono stati caricati!");
        } 
        catch (IOException ex) 
        {
            System.out.println("Impossibile accedere al file!");
        }
         
        Menu menu=new Menu(vociMenu);
        
        
        
        
        
        do
        {
            try
            {
                sceltaUtente=menu.sceltaMenu();
            
            switch(sceltaUtente)
            {
                case 0:
                {
                    System.out.println("L'applicazione e' terminata");
                    break;
                }
                case 1:
                {
                    cliente=new Cliente();
                    System.out.println("Codice-->");
                    cliente.setCodiceIdentificativo(tastiera.nextInt());
                    
                    tastiera.nextLine();
                    
                    System.out.println("Cognome-->");
                    cliente.setCognome(tastiera.nextLine());
                    
                    System.out.println("Nome-->");
                    cliente.setNome(tastiera.nextLine());
                    
                    System.out.println("PartitaIva-->");
                    cliente.setPartitaIva(tastiera.nextLine());
                    
                    System.out.println("Importo-->");
                    cliente.setImporto(tastiera.nextInt());
                    
                    
                    
                    System.out.println("Giorno-->");
                    giorno=tastiera.nextInt();
                    System.out.println("Mese-->");
                    mese=tastiera.nextInt();
                    System.out.println("Anno-->");
                    anno=tastiera.nextInt();
                    cliente.setDataEmissione(giorno,mese,anno);
                   
                    f.aggiungiFattura(cliente);
                    System.out.println("Inserimento avvenuto con successo");
                    System.out.println("premi un pulsante per continuare");
                    tastiera.nextLine();
                    break;
                }
                case 2:
                {
                    System.out.println("Codice[0...99]-->");
                    codice = tastiera.nextInt();
                    esitoOperazione=0;
                    
                    
                    
                    try
                    {
                        f.rimuoviFattura(codice);
                        System.out.println("ok rimozione effettuata correttamente");
                    }
                    catch(CodiceNonValido e1)
                    {
                        System.out.println(e1.toString());
                    } 
                    
                    System.out.println("premi un pulsante per continuare");
                    tastiera.nextLine();
                    break;
                }
                case 3:
                {
                    System.out.println("Inserisci codice univoco della fattura da pagare-->");
                    int c1= tastiera.nextInt();
                    int risultato;
                    
                    System.out.println("Giorno-->");
                    giorno=tastiera.nextInt();
                    System.out.println("Mese-->");
                    mese=tastiera.nextInt();
                    System.out.println("Anno-->");
                    anno=tastiera.nextInt();
                    
                    risultato=f.saldoNuovaFattura(giorno,mese,anno,c1);
                    
                    if(risultato==1)
                    {
                        System.out.println("Fattura già pagata");
                    }
                    else if(risultato==0)
                    {
                        System.out.println("Fattura pagata correttamente");
                    }
                    else
                    {
                        System.out.println("Il codice inserito non è esiste!");
                    }
                    
                    System.out.println("premi un pulsante per continuare");
                    tastiera.nextLine();
                    break;
                }
                case 4:
                {
                    System.out.println("\n");
                        try
                        {
                            f.visualizzaDatiCliente();
                        }
                        catch(NessunClienteException e1)
                        {
                            System.out.println(e1.toString());
                        }
                        
                        System.out.println("\n\nPremi un pulsante per continuare...");
                        tastiera.nextLine();
                        System.out.println("\n\n\n\n\n");
                        break;
                    
                    
                }
                case 5:
                {
                    
                    String nome,cognome;
                    System.out.println("Inserisci nome e cognome del cliente da cercare: ");
                    
                    System.out.println("Nome-->");
                    nome=tastiera.nextLine();
                    
                    System.out.println("Cognome-->");
                    cognome=tastiera.nextLine();
                    
                    f.visualizzaFattureDiUnaPersona(nome,cognome);
                    System.out.println(cliente.toString());
                    System.out.println("premi un pulsante per continuare");
                    tastiera.nextLine();
                    break;
                }
                case 6:
                {
                    try
                    {
                        f.esportaInCSV(nomeFileTesto);
                    }
                    catch(IOException e1)
                    {
                        System.out.println("Impossibile accedere al file, le fatture non sono stati salvate");
                    }
                   

                    System.out.println("premi un pulsante per continuare");
                    tastiera.nextLine();
                    break;
                }
                case 7:
                {
                    try
                        {
                            f.salvaFattura(nomeFileBinario);
                            System.out.println("\nSalvataggio avvenuto con successo");
                        }
                        catch(IOException ex)
                        {
                            System.out.println("\nErrore nella scrittura del file");
                        }
                        
                        System.out.println("\n\nPremi un pulsante per continuare...");
                        tastiera.nextLine();
                        System.out.println("\n\n\n\n\n");
                        break;
                }
           
            }
            }
            catch(InputMismatchException|NumberFormatException e1)
            {
                tastiera.nextLine();
                System.out.println("Input non corretto");
            }
            }while(sceltaUtente!=0);
        }
    }


        
        
        
        
           
         
        
    
    

