/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.model;

import br.edu.cefsa.tools.Funcoes;
import java.util.List;


/**
 *
 * @author fabid
 */
public class Principal {
    
    
    public static void main(String[] args) {
        List<String> dados = Funcoes.leArquivo("Gramatica.txt");
        Gramatica g = Funcoes.extraiGramatica(dados);
        String saida = g.aplicaRegras();
        
        String xml = Funcoes.montaSVG(Funcoes.geraGrafico(saida));
        
        Funcoes.gravaArquivo(xml);
        
        System.out.println(saida);
        //System.out.println(xml);
        
        
    }
    
    public void lixo(){
         Gramatica g = new Gramatica();
        
        g.getRegras().put('F', "FF");
        g.getRegras().put('B', "BB");
        g.getRegras().put('+', "-");
        g.getRegras().put('-', "+");
        g.setN(3);
        g.setOmega("FB=-");
        
        String saida = g.aplicaRegras("FB=-");
        System.out.println(saida);
        System.out.println("---------");
    }
}
