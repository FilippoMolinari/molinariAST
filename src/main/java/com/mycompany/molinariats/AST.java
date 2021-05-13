/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.molinariats;

import javax.swing.text.html.HTML;

/**
 *
 * @author filip
 */
public class AST 
{
    private Test[] elencoTest;
    private int testPresenti=0;
    private final int N_MAX_TEST=100;
    
    public AST()
    {
        elencoTest=new Test[N_MAX_TEST];
    }
    public int aggiungiTest(Test t)
    {
        elencoTest[testPresenti]=new Test(t);
        testPresenti++;
        return 0;
    }
    public int eliminaTest(String codiceFiscaleDaCercare)
    {
        int rimozioneOk=-1;
        for (int i=0; i<testPresenti;i++)
        {
            if(codiceFiscaleDaCercare==elencoTest[i].getCodiceFiscale())
            {
                aggiornaPosizioneTest(i);
                rimozioneOk=0;
            }
        }
        return rimozioneOk;
    }
    private void aggiornaPosizioneTest(int posizione)
    {
        for (int i=0; i<testPresenti-2;i++)
        {
           elencoTest[i]=elencoTest[i+1]; 
        }
        testPresenti--;
    }
}
