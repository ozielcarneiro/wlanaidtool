/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pade;

import matrizes.Mat;

/**
 *
 * @author oziel
 */
public class Padenizador {

    double width;
    double length;
    double[][] paredes;
    double[] valorTipo;
    double[][] apLoc;
    double[] apPot;
    double[] ganhos;
    public double[][] fnp;

    public Padenizador(double width, double length,double[][] paredes, double[] valorTipo, double[][] apLoc,double[] apPot,double[] ganhos){
        this.width = width;
        this.length = length;
        this.paredes = paredes;
        this.valorTipo = valorTipo;
        this.apLoc = apLoc;
        this.apPot = apPot;
        this.ganhos = ganhos;
    }


    public void padeniza() {
        long init = System.nanoTime();
        double[] x = Mat.linspace(0, width, 700);
        double[] y = Mat.linspace(0, length, 525);
        double[][] teste = Mat.meshgrid(x, y);
        double[] xx = new double[teste.length];
        double[] yy = new double[teste.length];
        for (int i = 0; i < teste.length; i++) {
            xx[i] = teste[i][0];
            yy[i] = teste[i][1];
        }
        double z = 0.54;

        double[][] distm = new double[apLoc.length][teste.length];
        double[] d0 = new double[apLoc.length];
        double[] plzero = new double[apLoc.length];
        double lambda = 0.125;
        for (int i = 0; i < distm.length; i++) {

            for (int j = 0; j < distm[i].length; j++) {
                distm[i][j] = Math.sqrt(Math.pow(apLoc[i][0] - xx[j], 2) + Math.pow(apLoc[i][1] - yy[j], 2) + Math.pow(apLoc[i][2] - z, 2));
            }
            d0[i] = Mat.min(distm[i]);
            plzero[i] = 20 * Math.log10(4 * Math.PI * d0[i] / lambda);
        }




        double dezgama = 26.79;//sem interferencia com interferencia = 27.491

        //Linha 147 do arquivo no MATLAB

        double[][][] npp = new double[apLoc.length][y.length][x.length];
        double[][] np = new double[apLoc.length][teste.length];
        double[][] intercept = new double[y.length][x.length];
        for (int i = 0; i < npp.length; i++) {

            for (int j = 0; j < y.length; j++) {
                for (int k = 0; k < x.length; k++) {
                    double nsoma = 0;
                    for (int l = 0; l < paredes.length; l++) {
                        double xs1 = paredes[l][0], ys1 = paredes[l][1], xs2 = paredes[l][2], ys2 = paredes[l][3];
                        boolean inter = intersect(apLoc[i][0], apLoc[i][1], x[k], y[j], xs1, ys1, xs2, ys2);
                        if (inter) {
                            nsoma += valorTipo[l];
                            intercept[j][k]+=1;
                        }
                    }
                    npp[i][j][k] = nsoma;
                }
            }
            np[i] = Mat.toColumVector(npp[i]);
        }



        double[] parameters = {1.380435640743863, 1.451279367175611};

        double[] f = new double[teste.length];
        for (int i = 0; i < apLoc.length; i++) {

            for (int j = 0; j < f.length; j++) {
                double bnp = parameters[1] * np[i][j];
                double bnpsq = Math.pow(bnp, 2);
                double den = 1 - bnp / 2 + bnpsq / 12;
                double dbm= apPot[i] + ganhos[i] - (plzero[i] + dezgama * Math.log10(distm[i][j] / d0[i]) + (parameters[0] * (1 + bnp / 2 + bnpsq / 12) / den));
                double mW = Math.pow(10, dbm/10.0);
                f[j] += mW;
            }
        }
        for (int i = 0; i < f.length; i++) {
            double dbm = 10*Math.log10(f[i]);
            if(dbm<-76){
                f[i] = 0;
            }else{
                f[i] = 100*(1-Math.exp(-(1/11.5)*(dbm+76)));
            }
        }
        fnp = Mat.reshape(f, y.length, x.length);
        long end = System.nanoTime();
        System.out.println("P"+(end-init));
    }


    private boolean intersect(double x1, double y1, double x2, double y2, double xs1, double ys1, double xs2, double ys2) {
       if(x1!=x2&&xs1!=xs2){
           double mx = (y2-y1)/(x2-x1);
           double y0 = y1-mx*x1;
           double ms = (ys2-ys1)/(xs2-xs1);
           double ys0 = ys1-ms*xs1;
           double xint = (ys0-y0)/(mx-ms);
           if(((x1<=xint&&x2>=xint)||(x1>=xint&&x2<=xint))&&((xs1<=xint&&xs2>=xint)||(xs1>=xint&&xs2<=xint))){
               return true;
           }else{
               return false;
           }
       }else if(x1!=x2){
           double mx = (y2-y1)/(x2-x1);
           double y0 = y1-mx*x1;
           double yint = mx*xs1+y0;
           if(((y1<=yint&&y2>=yint)||(y1>=yint&&y2<=yint))&&((ys1<=yint&&ys2>=yint)||(ys1>=yint&&ys2<=yint))){
               return true;
           }else{
               return false;
           }
       }else if(xs1!=xs2){
           double ms = (ys2-ys1)/(xs2-xs1);
           double ys0 = ys1-ms*xs1;
           double yint = ms*x1-ys0;
           if(((y1<=yint&&y2>=yint)||(y1>=yint&&y2<=yint))&&((ys1<=yint&&ys2>=yint)||(ys1>=yint&&ys2<=yint))){
               return true;
           }else{
               return false;
           }
       }else if(x1==xs1){
           if(((y1<=ys1&&y2>=ys1)||(y1>=ys1&&y2<=ys1))||((y1<=ys2&&y2>=ys2)||(y1>=ys2&&y2<=ys2))){
               return true;
           }else{
               return false;
           }
       } else {
           return false;
       }
    }

}
