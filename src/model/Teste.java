/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Conversor;


/**
 *
 * @author Administrator
 */
public class Teste {

    public static void main(String[] args) {
        // MemoriaCache memoria  = new MemoriaCache();
        Memoria memoria = new Memoria();
        Conversor conversor = new Conversor();
        String memoryTrace;
        String numero = "10";
        memoryTrace = "0,1032,1,1033,8,9,1033,2048,2047,2046,16,1033";

        String[] vetMemory= conversor.memoryTraceBinario(memoryTrace);
        //System.out.println(conversor.StringBinaria(numero));
        //System.out.println(conversor.UltimoBit(conversor.StringBinaria(numero)));
        
       conversor.memoryTraceBinario("2");
       String b = Integer.toBinaryString(2);
       
        String a=conversor.alteraTamanhoPalavra(b);
        System.out.println(a);
        

    }
}
