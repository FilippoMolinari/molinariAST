/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.molinariats;
import eccezioni.FileException;
import eccezioni.eccezionePosizioneNonValida;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import java.time.LocalDate;

/**
 *
 * @author filip
 */
public class Main 
{
    public static void main(String[] args) 
    {
        String[] vociMenu=new String[8];
        int sceltaUtente=-1;
        Scanner tastiera=new Scanner(System.in);
        LocalDate dataCercata;
        Test test;
        AST a=new AST();
        String nome,cognome,codiceFiscale,esito,nomeFile="test.txt",nomeFileBinario="test.bin";
        int codiceID=a.getTestPresenti(),giorno,mese,anno;     
        vociMenu[0]=" termina esecuzione";
        vociMenu[1]=" aggiungi test";
        vociMenu[2]=" cancella test";
        vociMenu[3]=" visualizza i test svolti da una persona";
        vociMenu[4]=" visualizza il numero di test effettuati complessivamente dall'AST";
        vociMenu[5]=" visualizza i test positivi in una determinata data(ordine alfabetico)";
        vociMenu[6]=" esporta in formato CSV i dati di tutti i test";
        vociMenu[7]=" salva i dati su un file binario";
        try
        {
            FileInputStream f1=new FileInputStream(nomeFileBinario);
            ObjectInputStream reader=new ObjectInputStream(f1);
            try
            {
                a=(AST)reader.readObject();
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
        Menu menu=new Menu(vociMenu);
        do
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
                    System.out.println("inserisci il nome dell'utente:");
                    nome=tastiera.nextLine();
                    System.out.println("inserisci il cognome dell'utente:");
                    cognome=tastiera.nextLine();
                    System.out.println("inserisci il codice fiscale dell'utente:");
                    codiceFiscale=tastiera.nextLine();
                    System.out.println("inserisci il giorno in cui è stato effettuato il test:");
                    giorno=tastiera.nextInt();
                    System.out.println("inserisci il mese in cui è stato effettuato il test:");
                    mese=tastiera.nextInt();
                    System.out.println("inserisci l'anno in cui è stato effettuato il test:");
                    anno=tastiera.nextInt();
                    codiceID++;
                    tastiera.nextLine();
                    System.out.println("inserisci l'esito del test:");
                    esito=tastiera.nextLine();
                    test=new Test(codiceID,nome,cognome,codiceFiscale,esito,giorno,mese,anno);
                    a.aggiungiTest(test);
                    break;
                }
                case 2:
                {
                    System.out.println("inserisci il codice fiscale dell'utente che si vuole eliminare:");
                    codiceFiscale=tastiera.nextLine();
                    a.eliminaTest(codiceFiscale);  
                    break;
                }
                case 3:
                {
                    System.out.println("inserisci il codice fiscale dell'utente che si vuole cercare:");
                    codiceFiscale=tastiera.nextLine();
                    a.testPersona(codiceFiscale);
                    break;
                }
                case 4:
                {
                    System.out.println("sono stati svolti complessivamente "+a.nTestFatti()+" test");
                    break;
                }
                case 5:
                {
                    System.out.println("inserisci il giorno in cui è stato effettuato il test:");
                    giorno=tastiera.nextInt();
                    System.out.println("inserisci il mese in cui è stato effettuato il test:");
                    mese=tastiera.nextInt();
                    System.out.println("inserisci l'anno in cui è stato effettuato il test:");
                    anno=tastiera.nextInt();
                    dataCercata=LocalDate.of(anno, mese, giorno);
                    System.out.println("i test svolti nella data indicata sono: \n"+a.positiviData(dataCercata));
                    break;
                }
                case 6:
                {
                    try
                    {
                        a.salvaTest(nomeFile);
                        System.out.println("salvataggio avvenuto");
                    }
                    catch(IOException e1)
                    {
                        System.out.println("impossibile salvare i dati sul file");
                    }
                    catch(FileException e2)
                    {
                        System.out.println(e2.toString());
                    }
                    catch(eccezionePosizioneNonValida e1)
                    {
                        System.out.println("La posizione non è valida");
                    }
                    break;
                }
                case 7:
                {
                    try
                    {
                        a.salvaTestBinario(nomeFileBinario);
                        System.out.println("salvataggio avvenuto");
                    }
                    catch(IOException e1)
                    {
                        System.out.println("impossibile salvare i dati sul file");
                    }
                    catch(FileException e2)
                    {
                        System.out.println(e2.toString());
                    } 
                    catch(eccezionePosizioneNonValida e1)
                    {
                        System.out.println("La posizione non è valida");
                    }
                    break;
                    
                }
            }
        }while(sceltaUtente!=0);
        //System.out.println(a.testPersona("a"));
        //System.out.println(a.nTestFatti());
        //System.out.println(a.positiviData(dataCercata));
        //a.salvaTest("Test.txt");
        
    }
}
