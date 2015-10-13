/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jardiano Silva
 */
public interface AppBase {
    
    public void inserir(String[] vetor);
    
    public void inserir(int[] vetor);
    
    public void alterar(int[] vetor);
        
    public void alterar(String[] vetor);
    
    public void remover();
    
    
}
