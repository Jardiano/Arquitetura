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

    public void setValorMapeamento(String vetor, int i, JTable tabela) {
        memoria.setBitValidade('1');
        memoria.setTag(vetor.substring(0, vetor.length() - 2));
        memoria.setValor(vetor);

        tabela.setValueAt(memoria.getBitValidade(), 0, i);
        tabela.setValueAt(memoria.getTag(), 1, i);
        tabela.setValueAt(memoria.getValor(), 2, i);
    }

    public void mapeamentoDireto(TelaPrincipal tela) {
        TableModel modelo = tela.getjTable1().getModel();
        JTable tabela = tela.getjTable1();
        tabela.setModel(modelo);
        String[] vetor = conversor.memoryTraceBinario(tela.getMemoryTrace().getText());

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = conversor.alteraTamanhoPalavra(vetor[i]);

            if (vetor[i].endsWith("00")) {
                setValorMapeamento(vetor[i], 4, tabela);
            } else if (vetor[i].endsWith("01")) {
                setValorMapeamento(vetor[i], 3, tabela);
            } else if (vetor[i].endsWith("10")) {
                setValorMapeamento(vetor[i], 2, tabela);
            } else if (vetor[i].endsWith("11")) {
                setValorMapeamento(vetor[i], 1, tabela);
            }
        }
        //tela.setjTable1(tabela);
    }

    public void mapeamentoTotalmenteAssociativa(TelaPrincipal tela) {
        TableModel modelo = tela.getjTable1().getModel();
        JTable tabela = tela.getjTable1();
        tabela.setModel(modelo);
        String[] vetor = conversor.memoryTraceBinario(tela.getMemoryTrace().getText());
        int j = 4;
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = conversor.alteraTamanhoPalavra(vetor[i]);
            if (j >= 0) {
                setValorMapeamento(vetor[i], j, tabela);
                j--;
            }
            if (j == 0) {
                j = 4;
            }
            //tela.setjTable1(tabela);
        }

    }

    public void mapeamentoAssociativaConjunto(TelaPrincipal tela) {
        TableModel modelo = tela.getjTable1().getModel();
        JTable tabela = tela.getjTable1();
        tabela.setModel(modelo);
        String[] vetor = conversor.memoryTraceBinario(tela.getMemoryTrace().getText());
        int map0 = 4;
        int map1 = 2;
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = conversor.alteraTamanhoPalavra(vetor[i]);

            if (vetor[i].endsWith("0")) {
                if (map0 == 4) {
                    setValorMapeamento(vetor[i], map0, tabela);
                    map0 = 3;
                } else {
                    setValorMapeamento(vetor[i], map0, tabela);
                    map0 = 4;
                }
            } else if (vetor[i].endsWith("1")) {
                if (map1 == 2) {
                    setValorMapeamento(vetor[i], map1, tabela);
                    map1 = 1;
                } else {
                    setValorMapeamento(vetor[i], map1, tabela);
                    map1 = 2;
                }
            }
            tela.setjTable1(tabela);
        }
    }
}
