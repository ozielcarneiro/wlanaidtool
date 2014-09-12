/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rbf;

import io.IOImpl;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import matrizes.Mat;

/**
 *
 * @author oziel
 */
public class Rede_rbf {

    No[] oculta;
    double[] peso;
    double[][] pesoIn;
    int size;

    public Rede_rbf(String nomeArq) {
        lerRede(nomeArq);
    }

    public Rede_rbf(int size, double[][] entrada, double[] desejado) {
        this.size = size;
        oculta = new No[size];
        peso = new double[size];//With BIAS size+1
        pesoIn = new double[size][entrada[0].length];
        double[] variance = new double[entrada[0].length];
        double[][] entradaT = Mat.transp(entrada);
        for (int i = 0; i < entradaT.length; i++) {
            variance[i] = Mat.variance(entradaT[i]);
        }
        if (size == entrada.length) {
            for (int i = 0; i < size; i++) {
                oculta[i] = new No(entrada[i], variance);
            }
        } else {
            ArrayList<Integer> d = new ArrayList<Integer>();
            while (d.size() < size) {
                int s = (int) (Math.random() * entrada.length);
                if (!d.contains(s)) {
                    d.add(s);
                }
            }
            for (int i = 0; i < size; i++) {
                oculta[i] = new No(entrada[d.get(i)], variance);
            }
//            double[] x = {0,0};
//            oculta[0] = new No(x);
//            x = new double[2];
//            x[0] = 1;x[1] = 1;
//            oculta[1] = new No(x);
        }
        double[][] g = new double[entrada.length][size];//BIAS size+1
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < entrada.length; j++) {
                g[j][i] = oculta[i].getSaida(entrada[j]);
            }
        }

        //BIAS
        //for (int i = 0; i < g.length; i++) {
        //    g[i][size] = 1;
        //
        //}


        //Non-Linear System Weight Calculation
        for (int i= 0; i < pesoIn.length; i++) {
            for (int j = 0; j < pesoIn[i].length; j++) {
                pesoIn[i][j] = 1;
            }
        }
        peso = Mat.prod(Mat.prod(Mat.inv(Mat.prod(Mat.transp(g), g)), Mat.transp(g)), desejado);


        
        //double[] des = new double[desejado.length];
        //for (int i = 0; i < des.length; i++) {
        //    des[i] = desejado[i];
        //}
        //peso = Mat.givens(g,des);
        Mat.print(peso, null);
    }


    public double sim(double[] entrada) {
        double saida = 0;
        for (int i = 0; i < oculta.length; i++) {
            double[] entPeso = new double[entrada.length];
            for (int j = 0; j < entrada.length; j++) {
                entPeso[j] = pesoIn[i][j] * entrada[j];
            }
            saida += oculta[i].getSaida(entPeso) * peso[i];
        }
        //saida += peso[peso.length - 1];
        return saida;
    }

    public double[] sim(double[][] entrada) {
        double[] saida = new double[entrada.length];
        for (int i = 0; i < saida.length; i++) {
            saida[i] = sim(entrada[i]);
        }
        return saida;
    }

    /**
     * Salva a rede em um arquivo texto no formato:
     * 1 linha: Tamanho da rede
     * 2...tam+1 linhas: coordenadas do centro do no (separados por ,);variancias do no (separados por ,)
     * ultima linha: pesos (separados por ,)
     */
    public void salvarRede(String nomeArq) {
        String rede = "";
        rede += size;
        for (int i = 0; i < oculta.length; i++) {
            rede += "\n";
            for (int j = 0; j < oculta[i].centro.length; j++) {
                if (j != 0) {
                    rede += ",";
                }
                rede += oculta[i].centro[j];
            }
            rede += ";";
            for (int j = 0; j < oculta[i].variance.length; j++) {
                if (j != 0) {
                    rede += ",";
                }
                rede += oculta[i].variance[j];
            }
        }
        rede += "\n";
        for (int i = 0; i < peso.length; i++) {
            if (i != 0) {
                rede += ",";
            }
            rede += peso[i];
        }
        IOImpl io = new IOImpl();
        try {
            io.save(nomeArq, rede);
        } catch (Exception ex) {
            Logger.getLogger(Rede_rbf.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo!", "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void lerRede(String nomeArq) {
        IOImpl io = new IOImpl();
        try {
            String rede = io.read(nomeArq);
            String[] linha = rede.split("\n");
            size = Integer.parseInt(linha[0]);
            oculta = new No[size];
            peso = new double[size + 1];
            for (int i = 1; i < linha.length - 1; i++) {
                String[] dados = linha[i].split(";");
                String[] coord = dados[0].split(",");
                String[] vari = dados[1].split(",");
                double[] centro = new double[coord.length];
                double[] variance = new double[vari.length];
                for (int j = 0; j < coord.length; j++) {
                    centro[j] = Double.parseDouble(coord[j]);
                }
                for (int j = 0; j < variance.length; j++) {
                    variance[j] = Double.parseDouble(vari[j]);
                }
                oculta[i - 1] = new No(centro, variance);
            }
            String[] p = linha[linha.length - 1].split(",");
            for (int i = 0; i < peso.length; i++) {
                peso[i] = Double.parseDouble(p[i]);
            }
        } catch (Exception ex) {
            Logger.getLogger(Rede_rbf.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo!", "Erro", JOptionPane.WARNING_MESSAGE);
        }

    }

    public class No {

        double[] centro;
        double[] variance;

        public No(double[] centro, double[] variance) {
            this.centro = centro;
            this.variance = variance;
        }

        public No(double[] centro) {
            this.centro = centro;
            for (int i = 0; i < centro.length; i++) {
                variance[i] = 1;
            }
        }

        public double getDerivadaX(double[] entrada) {
            double saida = 0;
            saida = -getSaida(entrada)*(1/ variance[0]);
            return saida;
        }

        public double getDerivadaY(double[] entrada) {
            double saida = 0;
            saida = -getSaida(entrada)*(1/ variance[1]);
            return saida;
        }

//        public double getDivergente(double[] entrada) {
//            return (getDerivadaX(entrada) + getDerivadaY(entrada));
//        }

        public double getSaida(double[] entrada) {
            double saida = 0;
            double x = 0;
            for (int i = 0; i < entrada.length; i++) {
                x += Math.pow(entrada[i] - centro[i], 2) / (2 * variance[i]);
            }
            saida = Math.exp(-x);
            return saida;
        }
    }
}
