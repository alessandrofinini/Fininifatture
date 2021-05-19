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
public class Ordinatore 
{
    public static void scambia(Cliente v[],int posizione1, int posizione2)
    {
        Cliente c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    
     //scambia array di stringhe
    public static void scambia(String v[],int posizione1, int posizione2)
    {
        String c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    public static void scambia(int v[],int posizione1, int posizione2)
    {
        int c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    public static int[] bubbleSortCrescente(int a[])
    {
        int[] ordinato=new int[a.length];
        boolean scambioAvvenuto=false;
        for(int i=0;i<ordinato.length;i++)
           ordinato[i]=a[i];
        do
        {
            scambioAvvenuto=false;
            for(int i=0;i<ordinato.length-1;i++)
            {
                if(ordinato[i]>ordinato[i+1])
                {
                    scambia(ordinato,i,i+1);
                    scambioAvvenuto=true;
                   
                }
            }
        }while(scambioAvvenuto);
        return ordinato;
    }
    public static int[] bubbleSortDecrescente(int a[])
    {
        int[] ordinato=new int[a.length];
        boolean scambioAvvenuto=false;
        for(int i=0;i<ordinato.length;i++)
           ordinato[i]=a[i];
        do
        {
            scambioAvvenuto=false;
            for(int i=0;i<ordinato.length-1;i++)
            {
                if(ordinato[i]<ordinato[i+1])
                {
                    scambia(ordinato,i,i+1);
                    scambioAvvenuto=true;
                   
                }
            }
        }while(scambioAvvenuto);
        return ordinato;
    }
    
     public static String[] bubbleSortCrescente(String a[])
    {
        String[] ordinato=new String[a.length];
        boolean scambioAvvenuto=false;
        for(int i=0;i<ordinato.length;i++)
           ordinato[i]=a[i];
        do
        {
            scambioAvvenuto=false;
            for(int i=0;i<ordinato.length-1;i++)
            {
                if(ordinato[i].compareToIgnoreCase(ordinato[i+1])>0)
                {
                    scambia(ordinato,i,i+1);
                    scambioAvvenuto=true;
                   
                }
            }
        }while(scambioAvvenuto);
        return ordinato;
    }
    public static String[] bubbleSortDecrescente(String a[])
    {
        String[] ordinato=new String[a.length];
        boolean scambioAvvenuto=false;
        for(int i=0;i<ordinato.length;i++)
           ordinato[i]=a[i];
        do
        {
            scambioAvvenuto=false;
            for(int i=0;i<ordinato.length-1;i++)
            {
                if(ordinato[i].compareToIgnoreCase(ordinato[i+1])<0)
                {
                    scambia(ordinato,i,i+1);
                    scambioAvvenuto=true;
                   
                }
            }
        }while(scambioAvvenuto);
        return ordinato;
    }
    //ordina array di stringhe in ordine alfabetico
    public static String[] selectionSortCrescente(String[] a)
    {
        String[] ordinato=new String[a.length];
        
        
        
        for(int i=0;i<ordinato.length;i++)
           ordinato[i]=a[i];
        
        
        for (int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].compareToIgnoreCase(ordinato[i])<0)
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
    public static Cliente[] selectionSortLibriPrezzoCrescente(Cliente[] a)
    {
        Cliente[] ordinato=new Cliente[a.length];
        
        
        
        for(int i=0;i<ordinato.length;i++)
           ordinato[i]=a[i];
        
        
        for (int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].getCodiceIdentificativo()<ordinato[i].getCodiceIdentificativo())
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
    public static Cliente[] selectionSortAlfabeticoClienti(Cliente[] a)
    {
        Cliente[] ordinato=new Cliente[a.length];



        for(int i=0;i<ordinato.length;i++)
           ordinato[i]=a[i];


        for (int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].getCognome().compareToIgnoreCase(ordinato[i].getCognome())<0 || (ordinato[j].getCognome().compareToIgnoreCase(ordinato[i].getCognome())==0 && ordinato[j].getNome().compareToIgnoreCase(ordinato[i].getNome())<0))
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    //ordina arrey di stringhe in ordine alfabetico inverso
     public static String[] selectionSortDecrescente(String[] a)
    {
        String[] ordinato=new String[a.length];
        
        
        
        for(int i=0;i<ordinato.length;i++)
           ordinato[i]=a[i];
        
        
        for (int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].compareToIgnoreCase(ordinato[i])>0)
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }

    //ordina array di interi in ordine crescente
    public static int[] selectionSortCrescente(int[] a)
    {
        int[] ordinato=new int[a.length];
        
        
        for(int i=0;i<ordinato.length;i++)
           ordinato[i]=a[i];
          
        for (int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j]<ordinato[i])
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
    
    //ordina array di interi in ordine decrescente
     public static int[] selectionSortDecrescente(int[] a)
    {
        int[] ordinato=new int[a.length];
        
        
        for(int i=0;i<ordinato.length;i++)
           ordinato[i]=a[i];
        
        
        for (int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j]>ordinato[i])
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
     
}

