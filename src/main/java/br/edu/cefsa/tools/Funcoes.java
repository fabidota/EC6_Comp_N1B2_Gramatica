/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.tools;

import br.edu.cefsa.model.Grafico;
import br.edu.cefsa.model.Gramatica;
import br.edu.cefsa.model.LinhaSVG;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.*;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author fabid
 */
public class Funcoes {

    private Funcoes() {

    }

    public static Grafico geraGrafico(String texto) {

        Grafico g = new Grafico();

        int linhaSize = 100;
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        for (char letra : texto.toCharArray()) {
            switch (letra) {
                case 'R': case 'r':
                    x2 = x1 + linhaSize;
                    y2 = y1 + 0;
                    break;                
                case 'L': case 'l':
                    x2 = x1 - linhaSize;
                    y2 = y1 + 0;
                    break;
                case '+':
                    x2 = x1 + 0;
                    y2 = y1 + linhaSize;
                    break;
                case '-':
                    x2 = x1 + 0;
                    y2 = y1 - linhaSize;
                    break;
                default:
                    continue;
            }
            if (letra != 'r' && letra != 'l') {
                g.getLinhas().add(new LinhaSVG(x1, x2, y1, y2));
            }
            x1 = x2;
            y1 = y2;
        }
        return g;
    }

    public static String montaSVG(Grafico g) {

        StringBuffer sb = new StringBuffer();
        sb.append("<!DOCTYPE html>\n"
                + "<html>\n"
                + "<body>\n"
                + "\n"
                + "<svg height=\"2000\" width=\"2000\">\n");

        for (LinhaSVG linha : g.getLinhas()) {
            sb.append("<line x1=\"" + linha.getX1() + "\" "
                    + "y1=\"" + linha.getY1() + "\" "
                    + "x2=\"" + linha.getX2() + "\" "
                    + "y2=\"" + linha.getY2() + "\" style=\"stroke:rgb(37, 150, 190);stroke-width:2\" />\n");
        }

        sb.append("</svg>\n"
                + "\n"
                + "</body>\n"
                + "</html>");

        return sb.toString();
    }

    public static Gramatica extraiGramatica(List<String> lista) {
        Gramatica g = new Gramatica();

        // SIGMA
        List<String> alfabeto = new ArrayList<>();
        alfabeto = Arrays.asList(lista.get(0).substring(4).split(","));
        for (String s : alfabeto) {
            for (char ch : s.trim().toCharArray()) {
                g.getSigma().add(ch);
            }
        }

        // N
        g.setN(Integer.parseInt(lista.get(1).substring(4).trim()));

        // omega
        g.setOmega(lista.get(2).substring(4).trim());

        // delta
        g.setDelta(Integer.parseInt(lista.get(3).substring(4).trim()));

        // regras
        for (int i = 4; i < lista.size(); i++) {
            String linha = lista.get(i).substring(5).trim();
            g.getRegras().put(linha.charAt(0), linha.substring(3).trim());
        }

        return g;
    }

    public static List<String> leArquivo(String arquivo) {

        List<String> dados = new ArrayList<>();

        try {
            // leitura arquivo
            FileInputStream fis = new FileInputStream(arquivo);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader dadosLidos = new BufferedReader(isr);
            String linha = "";

            while ((linha = dadosLidos.readLine()) != null) {
                dados.add(linha);
            }
            fis.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dados;

    }
    
    public static void gravaArquivo(String dados) {

        try {
            // leitura arquivo          
            FileOutputStream fos = new FileOutputStream("saida.html");
            fos.write(dados.getBytes());
            fos.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
