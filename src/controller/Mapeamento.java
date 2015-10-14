/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JTable;
import model.Memoria;
import view.TelaPrincipal;

/**
 *
 * @author Administrator
 */
public class Mapeamento {

    Conversor conversor = new Conversor();
    Memoria memoria = new Memoria();

    public Mapeamento() {
    }

    public void teste(TelaPrincipal tela) {
        JTable tabela = tela.getjTable1();
        String[] vetor = conversor.MemoryTraceBinario(tela.getMemoryTrace().getText());

        /*System.out.println(memoria.getBitValidade() + "\n"
                + memoria.getTag() + "\n"
                + memoria.getValor());*/
        
        int count = 0;
        for (int i = 4; i > 0; i--) {
            memoria.setBitValidade('1');
            memoria.setTag(vetor[count].substring(0, vetor[count].length() - 2));
            memoria.setValor(vetor[count]);

            tabela.setValueAt(memoria.getBitValidade(), 0, i);
            tabela.setValueAt(memoria.getTag(), 1, i);
            tabela.setValueAt(memoria.getValor(), 2, i);
            count++;
        }
        
        tela.setjTable1(tabela);

    }

    public void MapeamentoDireto(String memoryTrace) {

    }
}
