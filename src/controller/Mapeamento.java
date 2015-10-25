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

    private final Conversor conversor = new Conversor();
    private Memoria memoria = new Memoria();
    private int countHit = 0, countMiss = 0;

    public Mapeamento() {
    }

    public int getCountHit() {
        return countHit;
    }

    public void setCountHit(int countHit) {
        this.countHit = countHit;
    }

    public int getCountMiss() {
        return countMiss;
    }

    public void setCountMiss(int countMiss) {
        this.countMiss = countMiss;
    }

    public void setValorMapeamento(String vetor, int i, JTable tabela) {
        memoria.setBitValidade('1');
        memoria.setTag(vetor.substring(0, vetor.length() - 2));
        memoria.setValor(vetor);

        tabela.setValueAt(memoria.getBitValidade(), 0, i);
        tabela.setValueAt(memoria.getTag(), 1, i);
        tabela.setValueAt(memoria.getValor(), 2, i);
    }

    public String[] setValorVetor(TelaPrincipal tela) {
        String[] vetor = conversor.memoryTraceBinario(tela.getMemoryTrace().getText());
        return vetor;
    }

    public String[] setValorVetorEntrada(TelaPrincipal tela) {
        String[] vetor = conversor.memoryTraceEntrada(tela.getMemoryTrace().getText());
        return vetor;
    }

    public JTable setValorTabela(TelaPrincipal tela) {
        TableModel modelo = tela.getjTable1().getModel();
        JTable tabela = tela.getjTable1();
        tabela.setModel(modelo);
        return tabela;
    }

    public void countMissHit(JTable tabela, String valor, int linha, int coluna) {
        String comparador = tabela.getValueAt(linha, coluna).toString();
        if (comparador.equals(valor)) {
            System.out.println("Valor:" + tabela.getValueAt(linha, coluna)
                    + "\nHit:" + valor);
            countHit += 1;
        } else {
            System.out.println("Valor:" + tabela.getValueAt(linha, coluna)
                    + " \nMiss:" + valor);

            countMiss += 1;
        }
    }

    public void mapeamentoDireto(TelaPrincipal tela) {
        JTable tabela = setValorTabela(tela);
        String[] vetor = setValorVetor(tela);
        String[] vetorEntrada = setValorVetorEntrada(tela);

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = conversor.alteraTamanhoPalavra(vetor[i]);

            if (vetor[i].endsWith("00")) {

                countMissHit(tabela, vetorEntrada[i], 3, 4);
                setValorMapeamento(vetor[i], 4, tabela);
                tabela.setValueAt(vetorEntrada[i], 3, 4);

            } else if (vetor[i].endsWith("01")) {
                countMissHit(tabela, vetorEntrada[i], 3, 3);
                setValorMapeamento(vetor[i], 3, tabela);
                tabela.setValueAt(vetorEntrada[i], 3, 3);

            } else if (vetor[i].endsWith("10")) {
                countMissHit(tabela, vetorEntrada[i], 3, 2);
                setValorMapeamento(vetor[i], 2, tabela);
                tabela.setValueAt(vetorEntrada[i], 3, 2);

            } else if (vetor[i].endsWith("11")) {
                countMissHit(tabela, vetorEntrada[i], 3, 1);
                setValorMapeamento(vetor[i], 1, tabela);
                tabela.setValueAt(vetorEntrada[i], 3, 1);

            }

        }
        tela.setjTable1(tabela);
    }

    public void mapeamentoTotalmenteAssociativa(TelaPrincipal tela) {
        JTable tabela = setValorTabela(tela);
        String[] vetor = setValorVetor(tela);
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
            tela.setjTable1(tabela);
        }

    }

    public void mapeamentoAssociativaConjunto(TelaPrincipal tela) {
        JTable tabela = setValorTabela(tela);
        String[] vetor = setValorVetor(tela);
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
