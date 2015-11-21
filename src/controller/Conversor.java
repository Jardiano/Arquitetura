/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Jardiano Silva
 */
public class Conversor {

    public Conversor() {

    }

    /**
     * Esté método recebe como parametro do tipo String com valor binário e
     * retorna esse valor acrescido da quantidade de 0(zero)(s) necessário para
     * o valor possui 8 bits.
     *
     * @param palavra String
     * @return String - valor binário com 8 bits.
     */
    public String alteraTamanhoPalavra(String palavra) {
        if (palavra.length() < 8) {
            while (palavra.length() < 8) {
                palavra = "0".concat(palavra);
            }
        }
        return palavra;
    }

    /**
     * Este método recebe uma série de valores inteiros separados por vírgula
     * todos agrupados em uma String e retorna um vetor com os valores
     * convertidos em binário.
     *
     * @param memoryTrace String
     * @return String[] - vetor de String com valores binários
     */
    public String[] memoryTraceBinario(String memoryTrace) {
        String[] vetorMemoria;
        vetorMemoria = memoryTrace.split(",");

        for (int i = 0; i < vetorMemoria.length; i++) {
            vetorMemoria[i] = stringBinaria(vetorMemoria[i]);
        }

        return vetorMemoria;
    }

    /**
     * Este método recebe uma série de valores inteiros separados por vírgula
     * todos agrupados em uma String e retorna um vetor com os valores dividos
     * por index.
     * @param memoryTrace - String
     * @return String[] - Valores dividos em cada index;
     */
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

    public String binarioToString(String valorBinario) {
        int valorInteiro = 0;
        String valor;
        // soma ao valor final o dígito binário da posição * 2 elevado ao contador da posição (começa em 0)
        for (int i = valorBinario.length(); i > 0; i--) {
            valorInteiro += Integer.parseInt(valorBinario.charAt(i - 1) + "") * Math.pow(2, (valorBinario.length() - i));
        }
        valor = Integer.toString(valorInteiro);
        return valor;
    }

    public String ultimoBit(String strBin) {
        String bitFinal = strBin.substring(strBin.length() - 1);
        return bitFinal;
    }

}
