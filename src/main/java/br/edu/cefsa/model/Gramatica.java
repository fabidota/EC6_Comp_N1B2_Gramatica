/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fabid
 */
public class Gramatica {

    /*
    Gramática da linguagem:

    Σ   ☞ Alfabeto da linguagem
    n   ☞ Passos, etapas
    ω   ☞ Axioma, condição inicial
    δ   ☞ Angulo
    pX  ☞ Regras de produção   
     */
    private List<Character> sigma = new ArrayList<Character>();
    private int n;
    private String omega;
    private int delta;
    private Map<Character, String> regras = new HashMap<Character, String>();

    public Gramatica() {
    }

    public Gramatica(List<Character> sigma, int n, String omega, int delta, HashMap<Character, String> regras) {
        this.sigma = sigma;
        this.n = n;
        this.omega = omega;
        this.delta = delta;
        this.regras = regras;
    }

    public List<Character> getSigma() {
        return sigma;
    }

    public void setSigma(List<Character> sigma) {
        this.sigma = sigma;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getOmega() {
        return omega;
    }

    public void setOmega(String omega) {
        this.omega = omega;
    }

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }

    public Map<Character, String> getRegras() {
        return regras;
    }

    public void setRegras(HashMap<Character, String> regras) {
        this.regras = regras;
    }

    public String aplicaRegras(String entrada) {

        StringBuffer aux = new StringBuffer();
        StringBuffer saida = new StringBuffer();

        aux.append(entrada);

        for (int i = 0; i < this.n; i++) {
            saida.delete(0, saida.length());
            for (int j = 0; j < aux.length(); j++) {
                if (regras.get(aux.charAt(j)) != null) {
                    saida.append(regras.get(aux.charAt(j)));
                } else {
                    saida.append(aux.charAt(j));
                }
            }
            aux.delete(0, aux.length());
            aux.append(saida);
        }

        return saida.toString();
    }

    public String aplicaRegras() {

        StringBuffer aux = new StringBuffer();
        StringBuffer saida = new StringBuffer();

        aux.append(this.omega);
        
        if (this.n==0){
            return this.omega;
        }

        for (int i = 0; i < this.n; i++) {
            saida.delete(0, saida.length());
            for (int j = 0; j < aux.length(); j++) {
                if (regras.get(aux.charAt(j)) != null) {
                    saida.append(regras.get(aux.charAt(j)));
                } else {
                    saida.append(aux.charAt(j));
                }
            }
            aux.delete(0, aux.length());
            aux.append(saida);

        }
        return saida.toString();
    }

}
