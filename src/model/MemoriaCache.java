/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jardiano Silva
 */
public class MemoriaCache {

    private String memoryTrace;
    private int tamanhoPalavra;

    public MemoriaCache(String memoryTrace, int tamanhoPalavra, int tamanhoBloco, String modeloMemoria, String tipoMapeamento) {
        this.memoryTrace = memoryTrace;
        this.tamanhoPalavra = tamanhoPalavra;
        this.tamanhoBloco = tamanhoBloco;
        this.modeloMemoria = modeloMemoria;
        this.tipoMapeamento = tipoMapeamento;

    }

    public MemoriaCache() {

    }
    private int tamanhoBloco;
    private String modeloMemoria;
    private String tipoMapeamento;

    public String getMemoryTrace() {
        return memoryTrace;
    }

    public void setMemoryTrace(String memoryTrace) {
        if (memoryTrace != null) {
            this.memoryTrace = memoryTrace;
        } else {
            JOptionPane.showMessageDialog(null, "Preencha o memory trace");
        }
    }

    public int getTamanhoPalavra() {
        return tamanhoPalavra;
    }

    public void setTamanhoPalavra(int tamanhoPalavra) {
        this.tamanhoPalavra = tamanhoPalavra;
    }

    public int getTamanhoBloco() {
        return tamanhoBloco;
    }

    public void setTamanhoBloco(int tamanhoBloco) {
        this.tamanhoBloco = tamanhoBloco;
    }

    public String getModeloMemoria() {
        return modeloMemoria;
    }

    public void setModeloMemoria(String modeloMemoria) {
        this.modeloMemoria = modeloMemoria;
    }

    public String getTipoMapeamento() {
        return tipoMapeamento;
    }

    public void setTipoMapeamento(String tipoMapeamento) {
        this.tipoMapeamento = tipoMapeamento;
    }

}
