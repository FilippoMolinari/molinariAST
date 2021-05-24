/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.molinariats;
import java.io.Serializable;
import java.time.LocalDate;
/**
 * la classe rappresenta un oggetto test
 * gli attributi della classe sono:
 * int codiceID;
 * String nome;
 * String cognome;
 * String codiceFiscale;
 * LocalDate data;
 * String esito;
 * @author filip
 */
public class Test implements Serializable
{
    //atributi
    private int codiceID;
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private LocalDate data;
    private String esito;
    /**
     * costruttore
     * @param codiceID
     * @param nome
     * @param cognome
     * @param codiceFiscale
     * @param esito
     * @param giorno
     * @param mese
     * @param anno 
     */
    public Test(int codiceID, String nome, String cognome, String codiceFiscale, String esito,int giorno,int mese,int anno)
    {
        setNome(nome);
        setCognome(cognome);
        setCodiceFiscale(codiceFiscale);
        setData(giorno, mese, anno);
        setCodiceID(codiceID);
        setEsito(esito);
    }
    /**
     * costruttore di copia
     * @param t 
     */
    public Test(Test t)
    {
        setCodiceID(t.codiceID);
        setNome(t.nome);
        setCognome(t.cognome);
        setCodiceFiscale(t.codiceFiscale);
        setData(t.getData().getDayOfMonth(), t.getData().getMonthValue(),t.getData().getYear());
        setEsito(t.esito);
    }
    /**
     * costruttore vuoto
     */
    public Test()
    {
        this.nome=null;
        this.cognome=null;
        this.codiceFiscale=null;
        this.codiceID=0;
        this.esito=null;
        this.data=LocalDate.now();
    }
    /**
     * restituisce il valore del codiceID
     * @return 
     */
    public int getCodiceID() 
    {
        return codiceID;
    }
    /**
     * restituisce il nome di chi ha effettuato il test
     * @return 
     */
    public String getNome() 
    {
        return nome;
    }
    /**
     * restituisce il cognome di chi ha effettuato il test
     * @return 
     */
    public String getCognome() 
    {
        return cognome;
    }
    /**
     * restituisce il codice fiscale di chi ha effettuato il test
     * @return 
     */
    public String getCodiceFiscale() 
    {
        return codiceFiscale;
    }
    /**
     * restituisce la data in cui è stato effettuato il test
     * @return 
     */
    public LocalDate getData()
    {
        return data;
    }
    /**
     * restituisce l'esito del test
     * @return 
     */
    public String getEsito() 
    {
        return esito;
    }
    /**
     * assegna un valore a nome
     * @param nome 
     */
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    /**
     * assegna un valore a cognome
     * @param cognome 
     */
    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }
    /**
     * assegna un valore a codiceFiscale
     * @param codiceFiscale 
     */
    public void setCodiceFiscale(String codiceFiscale) 
    {
        this.codiceFiscale = codiceFiscale;
    }
    /**
     * assegna un valore alla data
     * @param giorno
     * @param mese
     * @param anno 
     */
    public void setData(int giorno,int mese,int anno)
    {
        this.data=LocalDate.of(anno, mese, giorno);
    }
    /**
     * assega un valore all'esito
     * @param esito 
     */
    public void setEsito(String esito) 
    {
        this.esito = esito;
    }
    /**
     * assegna un valore al codiceID
     * @param codiceID 
     */
    public void setCodiceID(int codiceID) 
    {
        this.codiceID = codiceID;
    }
    
    /**
     * restituisce una stringa in cui sono elencati i valori assegnati ad ogni attributo
     * @return 
     */
     public String toString()
    {
        String s;
        s="cognome: "+getCognome()+", nome: "+getNome()+", codice fiscale: "+getCodiceFiscale()+", data: "+getData().toString()+", codiceID test: "+getCodiceID()+", esito: "+getEsito();
        return s;
    }
}
