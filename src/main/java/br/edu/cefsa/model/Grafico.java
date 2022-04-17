/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabid
 */
public class Grafico {

    // x1="0" y1="0" x2="200" y2="200"
    private List<LinhaSVG> linhas = new ArrayList<>();

    public Grafico() {
    }

    public List<LinhaSVG> getLinhas() {
        return linhas;
    }

    public void setLinhas(List<LinhaSVG> linhas) {
        this.linhas = linhas;
    }

}
