/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.molinariats;
import java.time.LocalDate;
/**
 *
 * @author filip
 */
public class Test 
{
    //atributi
    private int codiceID;
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private LocalDate data;
    private String esito;

    public Test(int codiceID, String nome, String cognome, String codiceFiscale, String esito,int giorno,int mese,int anno)
    {
        setNome(nome);
        setCognome(cognome);
        setCodiceFiscale(codiceFiscale);
        setData(giorno, mese, anno);
        setCodiceID(codiceID);
        setEsito(esito);
    }

    public Test(Test t)
    {
        setCodiceID(t.codiceID);
        setNome(t.nome);
        setCognome(t.cognome);
        setCodiceFiscale(t.codiceFiscale);
        setData(t.getData().getDayOfMonth(), t.getData().getMonthValue(),t.getData().getYear());
        setEsito(t.esito);
    }
    public Test()
    {
        this.nome=null;
        this.cognome=null;
        this.codiceFiscale=null;
        this.codiceID=0;
        this.esito=null;
        this.data=LocalDate.now();
    }
    public int getCodiceID() 
    {
        return codiceID;
    }

    public String getNome() 
    {
        return nome;
    }

    public String getCognome() 
    {
        return cognome;
    }

    public String getCodiceFiscale() 
    {
        return codiceFiscale;
    }

    public LocalDate getData()
    {
        return data;
    }

    public String getEsito() 
    {
        return esito;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }

    public void setCodiceFiscale(String codiceFiscale) 
    {
        this.codiceFiscale = codiceFiscale;
    }

    public void setData(int giorno,int mese,int anno)
    {
        this.data=LocalDate.of(anno, mese, giorno);
    }

    public void setEsito(String esito) 
    {
        this.esito = esito;
    }
    public void setCodiceID(int codiceID) 
    {
        this.codiceID = codiceID;
    }
    

     public String toString()
    {
        String s;
        s="cognome: "+getCognome()+", nome: "+getNome()+", codice fiscale: "+getCodiceFiscale()+", data: "+getData().toString()+", codiceID test: "+getCodiceID()+", esito: "+getEsito();
        return s;
    }
}
