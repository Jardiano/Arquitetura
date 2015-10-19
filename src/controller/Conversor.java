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

    public Conversor() {

    }

    public String alteraTamanhoPalavra(String palavra) {
        if (palavra.length() < 8) {
            while (palavra.length() < 8) {
                palavra = "0".concat(palavra);
            }
        }
        return palavra;
    }

    public String[] memoryTraceBinario(String memoryTrace) {
        String[] vetorMemoria;
        vetorMemoria = memoryTrace.split(",");

        for (int i = 0; i < vetorMemoria.length; i++) {
            vetorMemoria[i] = stringBinaria(vetorMemoria[i]);
        }

        return vetorMemoria;
    }

    public String[] memoryTraceEntrada(String memoryTrace) {
        String[] vetorMemoria;
        vetorMemoria = memoryTrace.split(",");
        
        return vetorMemoria;
    }

    public String stringBinaria(String strNumero) {
        int val = Integer.parseInt(strNumero);
        String bin = Integer.toBinaryString(val);

        return bin;
    }

    public String ultimoBit(String strBin) {
        String bitFinal = strBin.substring(strBin.length() - 1);
        return bitFinal;
    }

}
