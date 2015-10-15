/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JTable;
import javax.swing.table.TableModel;
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

    public void setValorMapeamentoDireto(String vetor, int i, JTable tabela) {
        memoria.setBitValidade('1');
        memoria.setTag(vetor.substring(0, vetor.length() - 2));
        memoria.setValor(vetor);

        tabela.setValueAt(memoria.getBitValidade(), 0, i);
        tabela.setValueAt(memoria.getTag(), 1, i);
        tabela.setValueAt(memoria.getValor(), 2, i);
    }

    public void MapeamentoDireto(TelaPrincipal tela) {
        TableModel modelo = tela.getjTable1().getModel();
        JTable tabela = tela.getjTable1();
        tabela.setModel(modelo);
        String[] vetor = conversor.MemoryTraceBinario(tela.getMemoryTrace().getText());

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = conversor.AlteraTamanhoPalavra(vetor[i]);
            
            if (vetor[i].endsWith("00")) {
                setValorMapeamentoDireto(vetor[i], 4, tabela);
            } else if (vetor[i].endsWith("01")) {
                setValorMapeamentoDireto(vetor[i], 3, tabela);
            } else if (vetor[i].endsWith("10")) {
                setValorMapeamentoDireto(vetor[i], 2, tabela);
            } else if (vetor[i].endsWith("11")) {
                setValorMapeamentoDireto(vetor[i], 1, tabela);
            }
        }

        tela.setjTable1(tabela);

    }

    public void MapeamentoDireto(String memoryTrace) {

    }
}
