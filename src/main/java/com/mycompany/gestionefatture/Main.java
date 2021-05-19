/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionefatture;

import java.util.Scanner;

/**
 *
 * @author pc hp
 */
public class Main 
{
    public static void main(String[] args) 
    {
        String[] vociMenu=new String[9];
        int sceltaUtente=0;
        Scanner tastiera=new Scanner(System.in);
        
        Cliente c1=new Cliente(1,"finini","alexander","IT34249479WAS");
        System.out.println(c1.toString());
        
        
        
        Fattura f1=new Fattura();
        f1.aggiungiFattura(f1);
        System.out.println(f1.toString());
        
    }
    
}
        
        
        
        
        
           
         
        
    
    

