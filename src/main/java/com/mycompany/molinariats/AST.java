/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.molinariats;
import eccezioni.*;
import eccezioni.FileException;
import file.TextFile;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import javax.swing.text.html.HTML;
import java.time.LocalDate;

/**
 * la classe AST contiene e gestisce un array di oggetti della classe test
 * i suoi attributi sono:
 * int testTotali=0;
 * boolean tesPersona;
 * Test[] elencoTest;
 * int testPresenti=0;
 * final int N_MAX_TEST=100;
 * @author filip
 */
public class AST implements Serializable
{
    private int testTotali=0;
    static boolean tesPersona;
    private Test[] elencoTest;
    private int testPresenti=0;
    private final int N_MAX_TEST=100;
    Scanner tastiera=new Scanner(System.in);
    /**
     * costruttore della classe AST
     */
    public AST()
    {
        elencoTest=new Test[N_MAX_TEST];
    }
    /**
     * permette di aggiungere un oggetto della classe test
     * @param t
     * @return
     * @throws InputMismatchException 
     */
    public int aggiungiTest(Test t)throws InputMismatchException
    {
        int i=0;
        if(testPresenti<0||testPresenti>100)
        {
            System.out.println("il numero di test effettuati è sopra la soglia massima.");
            return i=-1;//test non inserito
        }
        elencoTest[testPresenti]=new Test(t);
        testPresenti++;
        testTotali ++;
        return i;//test inserito correttamente
    }
    /**
     * permette di eliminare un oggetto della classe test
     * @param codiceFiscaleDaCercare
     * @return
     * @throws InputMismatchException 
     */
    public int eliminaTest(String codiceFiscaleDaCercare)throws InputMismatchException
    {
        int rimozioneOk=-1;
        int y=0;
        for (int i=0; i<testPresenti;i++)
        {
            if(codiceFiscaleDaCercare.compareToIgnoreCase(elencoTest[i].getCodiceFiscale())==0)
            {
                System.out.println(testPersona(elencoTest[i].getCodiceFiscale()));
                System.out.println("inserisci il codiceID del test da eliminare: ");
                y=tastiera.nextInt();
                for(int z=0;z<testPresenti;z++)
                {
                    if(y==elencoTest[z].getCodiceID())
                    {
                        aggiornaPosizioneTest(z);
                        rimozioneOk=0;
                        return rimozioneOk;
                    }
                }  
            }
        }
        return rimozioneOk;
    }
    /**
     * consente di aggiornare la posizione dei test all'interno dell'array elencoTest, durante l'esecuzione di eliminaTest
     * @param posizione 
     */
    private void aggiornaPosizioneTest(int posizione)
    {
        for (int i=posizione; i<testPresenti-1;i++)
        {
           elencoTest[i]=elencoTest[i+1]; 
        }
        testPresenti--;
    }
    /**
     * permette di visualizzare tutti i test svolti da una determinata persona
     * @param codiceFiscaleDaCercare
     * @return 
     */
    public String testPersona(String codiceFiscaleDaCercare)
    {
        String s = null;
        if(testPresenti<0)
        {
            s="nessun test ancora effettuato.";
        }
        
        for (int i=0; i<testPresenti;i++)
        {
            if(i==0)
            {
                if(codiceFiscaleDaCercare.compareToIgnoreCase(elencoTest[i].getCodiceFiscale())==0)
                {
                    s=(elencoTest[i].getData()+", "+elencoTest[i].getCodiceID()+", "+elencoTest[i].getEsito()+"\n");
                }
                continue;
            }
            if(codiceFiscaleDaCercare.compareToIgnoreCase(elencoTest[i].getCodiceFiscale())==0)
            {
                s+=(elencoTest[i].getData()+", "+elencoTest[i].getCodiceID()+", "+elencoTest[i].getEsito()+"\n");
            }
        }
        return s;
    }
    /**
     * permette di visualizzare il numero di test svolti complessivamente dall'AST
     * @return 
     */
    public int nTestFatti()
    {
        return testTotali;
    }
    /**
     * permette di visualizzare tutti i test svolti in una determinata data
     * @param dataCercata
     * @return 
     */
    public String positiviData(LocalDate dataCercata)
    {
        String s = null;
        int x=0;
        Test[] testPositivi;
        testPositivi=new Test[N_MAX_TEST];
        for(int i=0;i<testPresenti;i++)
        {
            if(dataCercata.isEqual(elencoTest[i].getData()))
            {
                if(elencoTest[i].getEsito()=="positivo")
                {
                    testPositivi[x]=elencoTest[i];
                    x++;
                }

            }
        }
        testPositivi=Ordinatore.ordinaTest(testPositivi);
        for(int i=0;i<x;i++)
        {
            if(i==0)
            {
                s=testPositivi[i].getCognome()+" ,"+testPositivi[i].getNome()+" ,"+testPositivi[i].getCodiceFiscale()+" ,"+testPositivi[i].getData()+" ,"+testPositivi[i].getCodiceID()+" ,"+testPositivi[i].getEsito()+"\n";
                continue;
            }
            s+=testPositivi[i].getCognome()+" ,"+testPositivi[i].getNome()+" ,"+testPositivi[i].getCodiceFiscale()+" ,"+testPositivi[i].getData()+" ,"+testPositivi[i].getCodiceID()+" ,"+testPositivi[i].getEsito()+"\n";
        }
        if(s==null)
        {
            s="nessun test di quella data è presente";
        }
        return s;
    }
    /**
     * permette di salvare i test svolti su un file CSV
     * @param nomeFile
     * @throws IOException
     * @throws FileException
     * @throws eccezionePosizioneNonValida 
     */
    public void salvaTest(String nomeFile) throws IOException, FileException, eccezionePosizioneNonValida
    {
        TextFile f1=new TextFile(nomeFile,'W');
        Test test;
        for(int i=0;i<testPresenti;i++)
        {
            test=elencoTest[i];
            if(test!=null)
            {
                f1.toFile(elencoTest[i].getCognome()+";"+elencoTest[i].getNome()+";"+elencoTest[i].getCodiceFiscale()+";"+elencoTest[i].getData()+";"+elencoTest[i].getCodiceID()+";"+elencoTest[i].getEsito()+"\n");
            }
        }
        f1.close();
    }
    /**
     * permette di salvare i test svolti su un file binario 
     * @param nomeFile
     * @throws IOException 
     */
    public void salvaTestBinario(String nomeFile) throws IOException
    {
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream writer=new ObjectOutputStream(f1);
        writer.writeObject(this);
        writer.flush();
        writer.close();   
    }
    /**
     * restituisce il numero di test presenti all'interno dell'array
     * @return 
     */
    public int getTestPresenti() 
    {
        return testPresenti;
    }
    /**
     * restituisce il numero massimo di test inseribili
     * @return 
     */
    public int getN_MAX_TEST() 
    {
        return N_MAX_TEST;
    }
    
}
