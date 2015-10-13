/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.MemoriaCache;

/**
 *
 * @author Administrator
 */
public class Conversor {

    private MemoriaCache memoriaCache ;

    public String[] MemoryTraceBinario(String memoryTrace) {
        String[] vetorMemoria;
        vetorMemoria = memoryTrace.split(",");
        
        for(int i=0;i<vetorMemoria.length;i++){
            vetorMemoria[i] = StringBinaria(vetorMemoria[i]);
        }
       
       return vetorMemoria;

    }

    public String StringBinaria(String strNumero) {
        int val = Integer.parseInt(strNumero);
        String bin = Integer.toBinaryString(val);

        return bin;
    }
    
    public String UltimoBit(String strBin){
        String bitFinal = strBin.substring(strBin.length() - 1);
        return bitFinal;
    }

}
