/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.molinariats;
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
        LocalDate dataCercata;
        dataCercata=LocalDate.of(2025, 3, 1);
        AST a=new AST();
        Test t1=new Test(3, "b", "b", "a", "positivo", 1, 3, 2025);
        Test t2=new Test(5, "a", "a", "a", "positivo", 1, 3, 2025);
        Test t3=new Test(2, "d", "d", "b", "positivo", 1, 4, 2025);
        Test t4=new Test(0, "c", "c", "c", "positivo", 1, 3, 2025);
        a.aggiungiTest(t1);
        a.aggiungiTest(t2);
        a.aggiungiTest(t3);
        a.aggiungiTest(t4);
        //System.out.println(a.testPersona("a"));
        //System.out.println(a.nTestFatti());
        System.out.println(a.positiviData(dataCercata));
        
    }
}
