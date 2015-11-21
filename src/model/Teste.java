/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Conversor;

/**
 *
 * @author Jardiano Silva
 */
public class Teste {

    public static void inserirLRU(int[] vetNum, int num) {
        boolean emMemoria = false;

        for (int i = 0; i < vetNum.length; i++) {
            if (num == vetNum[i]) {

                System.out.println("Valor já na memória -- HIT");
                emMemoria = true;
                int aux;
                int pos = i;

                System.out.println("Posição encontrada " + pos);

                aux = vetNum[0];

                for (int j = pos; j > 0; j--) {
                    vetNum[j] = vetNum[j - 1];
                }
                vetNum[0] = num;

            }

        }

        if (emMemoria == false) {

            System.out.println("Valor  não está na memória -- Miss");

            for (int j = 3; j > 0; j--) {
                vetNum[j] = vetNum[j - 1];
            }
            vetNum[0] = num;

        }
    }

    public static void main(String[] args) {
        // MemoriaCache memoria  = new MemoriaCache();

        // memoryTrace = "0,1032,1,1033,8,9,1033,2048,2047,2046,16,1033";

        /*
         String[] vetMemory = conversor.memoryTraceEntrada(memoryTrace);
         for (int i = 0; i < vetMemory.length; i++) {       
         System.out.println(vetMemory[i]);
         }
         */
        int[] vetNum = {0, 1, 2, 3};
        int num = 6;

        for (int i = 0; i < vetNum.length; i++) {
            System.out.print("Valor " + vetNum[i] + ", ");
        }

        inserirLRU(vetNum, num);
        System.out.println("\n");

        for (int i = 0; i < vetNum.length; i++) {
            System.out.print("Valor " + vetNum[i] + ", ");
        }

    }
}
