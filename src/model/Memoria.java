/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrator
 */
public class Memoria {

    private char bitValidade;
    private String tag;
    private String valor;

    public Memoria(char bitValidade, String tag, String valor) {
        this.bitValidade = bitValidade;
        this.tag = tag;
        this.valor = valor;
    }
    public Memoria(){
        
    }

    public char getBitValidade() {
        return bitValidade;
    }

    public void setBitValidade(char bitValidade) {
        this.bitValidade = bitValidade;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}
