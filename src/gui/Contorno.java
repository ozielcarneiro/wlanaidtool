/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entity.AccessPoint;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import matrizes.Mat;

/**
 *
 * @author oziel
 */
public class Contorno extends JFrame {

    public double[][] z;
    double width;
    double length;
    double[][] paredes;
    double[] valorTipo;
    ArrayList<AccessPoint> aps;
    boolean tag;

    public Contorno() {
        super();
        setTitle("Grafico");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(816, 713);
        setLocation(300, 0);
    }

    public void setCampo(double[][] z) {
        this.z = z;
        if (this.z != null) {
            this.tag = true;
        } else {
            this.tag = false;
        }
    }

    public void setAPS(ArrayList<AccessPoint> aps) {
        this.aps = aps;
    }

    public void setParedes(double width, double length, double[][] paredes, double[] valorTipo) {
        this.width = width;
        this.length = length;
        this.paredes = paredes;
        this.valorTipo = valorTipo;
    }

    @Override
    public void paint(Graphics g) {
        long init = System.nanoTime();
        if (tag) {
            double xmin = 0;
            double escalax = (width - xmin) / ((double) getWidth() - 116);
            double ymin = 0;
            double escalay = (length - ymin) / ((double) getHeight() - 186);
            double zmax = Mat.matmax(z);
            double zmin = Mat.matmin(z);
            double fator = (zmax - zmin) * (360.0 / 240.0);
            double[] x = Mat.linspace(0, width, 700);
            double[] y = Mat.linspace(0, length, 525);


            Graphics2D g2d = (Graphics2D) g;

            for (int i = 0; i < 700; i++) {
                for (int j = 0; j < 525; j++) {
                    double xi = xmin + i * escalax;
                    double yi = ymin + j * escalay;
                    int i0 = 0, i1 = 1, j0 = 0, j1 = 1;
                    for (int k = 0; k < x.length - 1; k++) {
                        if (x[k] <= xi && x[k + 1] >= xi) {
                            i0 = k;
                            i1 = k + 1;
                            break;
                        }
                    }
                    for (int k = 0; k < y.length - 1; k++) {
                        if (y[k] <= yi && y[k + 1] >= yi) {
                            j0 = k;
                            j1 = k + 1;
                            break;
                        }
                    }
                    double x0 = x[i0], x1 = x[i1], y0 = y[j0], y1 = y[j1];
                    double zp = (z[j0][i0] * (x1 - xi) * (y1 - yi) + z[j0][i1] * (xi - x0) * (y1 - yi) + z[j1][i0] * (x1 - xi) * (yi - y0) + z[j1][i1] * (xi - x0) * (yi - y0)) / ((x1 - x0) * (y1 - y0));
                    zp = (-zp + zmax) / fator;
                    g2d.setColor(Color.getHSBColor((float) zp, 1, 1));
                    g2d.fillRect(i + 58, (525 - j) + 80, 1, 1);
                }
            }

            g2d.setColor(this.getBackground());
            g2d.fillRect(58, 615, 800, 630);

            for (int i = 0; i < 700; i++) {
                float c = (float) (((700 - i) / 700.0) * (240.0 / 360.0));
                g2d.setColor(Color.getHSBColor(c, 1, 1));
                g2d.drawLine(i + 58, 600 + 30, i + 58, 655);
                if (i == 350) {
                    double cscale = -(c * fator - zmax);
                    g2d.setColor(Color.black);
                    g2d.drawLine(i + 58, 600 + 30, i + 58, 640);

                    g2d.drawString("" + Mat.round(cscale, 3), i + 58, 600 + 30);
                }
            }

            g2d.setColor(Color.black);
            g2d.drawLine(58, 600 + 30, 58, 640);
            g2d.drawString("" + Mat.round(zmin, 3), 58, 600 + 30);
            g2d.drawLine(699 + 58, 600 + 30, 699 + 58, 640);
            g2d.drawString("" + Mat.round(zmax, 3), 699 + 58, 600 + 30);
        } else {
            Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(this.getBackground());
            g2d.fillRect(58, 615, 800, 630);

            for (int i = 0; i < 700; i++) {
                for (int j = 0; j < 525; j++) {
                    g2d.setColor(Color.white);
                    g2d.fillRect(i + 58, j + 80, 1, 1);
                }
            }
            for (int i = 0; i < 700; i++) {
                g2d.setColor(Color.white);
                g2d.drawLine(i + 58, 600 + 30, i + 58, 655);

            }
        }

        paintParedes(g);
        paintAPS(g);
        long end = System.nanoTime();
        System.out.println("G" + (end - init));

    }

    public void paintAPS(Graphics g) {
        double escalaX = 700.0 / width;
        double escalaY = 525.0 / length;

        if (aps != null) {
            if (!aps.isEmpty()) {
                for (int i = 0; i < aps.size(); i++) {
                    int x = ((int) Math.round(aps.get(i).x * escalaX)) + 58;
                    int y = 525 - ((int) Math.round(aps.get(i).y * escalaY)) + 80;
                    int[] xPoints = new int[16];
                    int[] yPoints = new int[16];
                    for (int j = 0; j < 16; j += 2) {
                        xPoints[j] = x;
                        yPoints[j] = y;
                        if (j == 0) {
                            xPoints[j + 1] = x;
                            yPoints[j + 1] = y - 5;
                        } else if (j == 2) {
                            xPoints[j + 1] = x + 5;
                            yPoints[j + 1] = y - 5;
                        } else if (j == 4) {
                            xPoints[j + 1] = x + 5;
                            yPoints[j + 1] = y;
                        } else if (j == 6) {
                            xPoints[j + 1] = x + 5;
                            yPoints[j + 1] = y + 5;
                        } else if (j == 8) {
                            xPoints[j + 1] = x;
                            yPoints[j + 1] = y + 5;
                        } else if (j == 10) {
                            xPoints[j + 1] = x - 5;
                            yPoints[j + 1] = y + 5;
                        } else if (j == 12) {
                            xPoints[j + 1] = x - 5;
                            yPoints[j + 1] = y;
                        } else if (j == 14) {
                            xPoints[j + 1] = x - 5;
                            yPoints[j + 1] = y - 5;
                        }
                    }
                    g.setColor(Color.white);
                    g.drawPolyline(xPoints, yPoints, 16);
                    g.fillRect(x - 2, y - 2, 5, 5);
                }
            }
        }
    }

    public void paintParedes(Graphics g) {

        double escalaX = 700.0 / width;
        double escalaY = 525.0 / length;

        g.setColor(Color.black);
        for (int i = 0; i < paredes.length; i++) {
            double paredeLength = paredes[i][3] - paredes[i][1];
            double paredeWidth = paredes[i][2] - paredes[i][0];
            int x1, x2, y1, y2;
            if (paredeLength >= 0 && paredeWidth >= 0) {
                x1 = (int) Math.round(paredes[i][0] * escalaX) + 58;
                x2 = (int) Math.round(paredes[i][2] * escalaX) + 58;
                y1 = 525 - (int) Math.round(paredes[i][1] * escalaY) + 80;
                y2 = 525 - (int) Math.round(paredes[i][3] * escalaY) + 80;
            } else if (paredeLength >= 0 && paredeWidth < 0) {
                x1 = (int) Math.round(paredes[i][2] * escalaX) + 58;
                x2 = (int) Math.round(paredes[i][0] * escalaX) + 58;
                y1 = 525 - (int) Math.round(paredes[i][1] * escalaY) + 80;
                y2 = 525 - (int) Math.round(paredes[i][3] * escalaY) + 80;
            } else if (paredeWidth >= 0 && paredeLength < 0) {
                x1 = (int) Math.round(paredes[i][0] * escalaX) + 58;
                x2 = (int) Math.round(paredes[i][2] * escalaX) + 58;
                y1 = 525 - (int) Math.round(paredes[i][3] * escalaY) + 80;
                y2 = 525 - (int) Math.round(paredes[i][1] * escalaY) + 80;
            } else {
                x1 = (int) Math.round(paredes[i][2] * escalaX) + 58;
                x2 = (int) Math.round(paredes[i][0] * escalaX) + 58;
                y1 = 525 - (int) Math.round(paredes[i][3] * escalaY) + 80;
                y2 = 525 - (int) Math.round(paredes[i][1] * escalaY) + 80;
            }
            if (valorTipo[i] == 0.43) {
                g.drawLine(x1, y1, x2, y2);
                if (paredeWidth == 0) {
                    g.drawLine(x1 - 1, y1, x2 - 1, y2);
                    g.drawLine(x1 + 1, y1, x2 + 1, y2);
                } else if (paredeLength == 0) {
                    g.drawLine(x1, y1 - 1, x2, y2 - 1);
                    g.drawLine(x1, y1 + 1, x2, y2 + 1);
                } else {
                    g.drawLine(x1 - 1, y1 - 1, x2 - 1, y2 - 1);
                    g.drawLine(x1 + 1, y1 + 1, x2 + 1, y2 + 1);
                }
            } else if (valorTipo[i] == 3.66) {
                g.drawLine(x1, y1, x2, y2);
                if (paredeWidth == 0) {
                    g.drawLine(x1 - 1, y1, x2 - 1, y2);
                    g.drawLine(x1 + 1, y1, x2 + 1, y2);
                    g.drawLine(x1 - 2, y1, x2 - 2, y2);
                    g.drawLine(x1 + 2, y1, x2 + 2, y2);
                } else if (paredeLength == 0) {
                    g.drawLine(x1, y1 - 1, x2, y2 - 1);
                    g.drawLine(x1, y1 + 1, x2, y2 + 1);
                    g.drawLine(x1, y1 - 2, x2, y2 - 2);
                    g.drawLine(x1, y1 + 2, x2, y2 + 2);
                } else {
                    g.drawLine(x1 - 1, y1 - 1, x2 - 1, y2 - 1);
                    g.drawLine(x1 + 1, y1 + 1, x2 + 1, y2 + 1);
                    g.drawLine(x1 - 2, y1 - 2, x2 - 2, y2 - 2);
                    g.drawLine(x1 + 2, y1 + 2, x2 + 2, y2 + 2);
                    g.drawLine(x1 - 3, y1 - 3, x2 - 3, y2 - 3);
                    g.drawLine(x1 + 3, y1 + 3, x2 + 3, y2 + 3);
                    g.drawLine(x1 - 4, y1 - 4, x2 - 4, y2 - 4);
                    g.drawLine(x1 + 4, y1 + 4, x2 + 4, y2 + 4);
                }
            } else if (valorTipo[i] == 0.4) {
                g.drawLine(x1, y1, x2, y2);
                if (paredeWidth == 0) {
                    g.drawLine(x1 - 1, y1, x2 - 1, y2);
                    g.drawLine(x1 + 1, y1, x2 + 1, y2);
                } else if (paredeLength == 0) {
                    g.drawLine(x1, y1 - 1, x2, y2 - 1);
                    g.drawLine(x1, y1 + 1, x2, y2 + 1);
                } else {
                    g.drawLine(x1 - 1, y1 - 1, x2 - 1, y2 - 1);
                    g.drawLine(x1 + 1, y1 + 1, x2 + 1, y2 + 1);
                }
            }
        }
    }
}
