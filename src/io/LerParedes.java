/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import javax.swing.JOptionPane;

/**
 *
 * @author oziel
 */
public class LerParedes {

    public double width;
    public double length;
    public double[][] paredes;
    public double[] valorTipoParedes;

    public void lerParedes(String file) {
        IOImpl io = new IOImpl();
        try {
            String texto = io.read(file);
            texto = texto.replaceAll("\r", "");
            String[] linha = texto.split("\n");
            paredes = new double[linha.length - 1][4];
            valorTipoParedes = new double[linha.length - 1];
            String[] size = linha[0].split(",");
            width = Double.parseDouble(size[0].trim());
            length = Double.parseDouble(size[1].trim());
            for (int i = 0; i < linha.length - 1; i++) {
                String[] coluna = linha[i + 1].split(",");
                for (int j = 0; j < 4; j++) {
                    paredes[i][j] = Double.parseDouble(coluna[j].trim());
                }
                if (coluna[4].trim().startsWith("D")) {
                    valorTipoParedes[i] = 0.43;
                } else if (coluna[4].trim().startsWith("T")) {
                    valorTipoParedes[i] = 3.66;
                } else if (coluna[4].trim().startsWith("E")) {
                    valorTipoParedes[i] = 0.4;
                } else {
                    valorTipoParedes[i] = 3.66;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo!");
        }

    }
}
