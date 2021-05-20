/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eccezioni;

/**
 *
 * @author filip
 */
public class eccezionePosizioneNonValida extends Exception
{
    private int ripiano;
    private int posizione;

    public eccezionePosizioneNonValida (int ripiano, int posizione)
    {
        this.ripiano=ripiano;
        this.posizione=posizione;
    }
            
    public int getRipiano() 
    {
        return ripiano;
    }

    public int getPosizione() 
    {
        return posizione;
    }
    public String toString()
    {
        String s="";
        s+="La posizione riipiano: "+getRipiano()+" posizione: "+getPosizione()+ " non e valida.";
        return s;
    }
    
    
}
