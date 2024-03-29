/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Aplicativo.java
 *
 * Created on 11/11/2011, 08:41:40
 */
package gui;

import entity.AccessPoint;
import io.LerParedes;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import pade.Padenizador;

/**
 *
 * @author oziel
 */
public class Aplicativo extends javax.swing.JFrame {

    /** Creates new form Aplicativo */
    public Aplicativo() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelParedes = new javax.swing.JLabel();
        fieldParedes = new javax.swing.JTextField();
        buttonParedes = new javax.swing.JButton();
        labelMetodo = new javax.swing.JLabel();
        listaMetodo = new javax.swing.JComboBox();
        labelMedidos = new javax.swing.JLabel();
        fieldMedidos = new javax.swing.JTextField();
        buttonMedidos = new javax.swing.JButton();
        labelAP = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaAP = new javax.swing.JList();
        buttonAddAP = new javax.swing.JButton();
        buttonRemoveAP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rede Sem Fio");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);

        labelParedes.setText("Arquivo Paredes:");

        fieldParedes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldParedesActionPerformed(evt);
            }
        });
        fieldParedes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fieldParedesPropertyChange(evt);
            }
        });

        buttonParedes.setText("Buscar");
        buttonParedes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonParedesActionPerformed(evt);
            }
        });

        labelMetodo.setText("Modelo:");

        listaMetodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Padé", "Interpolação RBF", " " }));
        listaMetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaMetodoActionPerformed(evt);
            }
        });

        labelMedidos.setText("Arquivo dados medidos:");
        labelMedidos.setEnabled(false);

        fieldMedidos.setEnabled(false);
        fieldMedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldMedidosActionPerformed(evt);
            }
        });

        buttonMedidos.setText("Buscar");
        buttonMedidos.setEnabled(false);

        labelAP.setText("Pontos de Acesso:");

        jScrollPane1.setViewportView(listaAP);

        buttonAddAP.setText("Adicionar");
        buttonAddAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddAPActionPerformed(evt);
            }
        });

        buttonRemoveAP.setText("Remover");
        buttonRemoveAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveAPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(labelParedes, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelMetodo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(listaMetodo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelMedidos, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fieldParedes)
                                .addComponent(fieldMedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(buttonMedidos)
                                .addComponent(buttonParedes))))
                    .addComponent(labelAP)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(buttonAddAP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonRemoveAP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelParedes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldParedes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonParedes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMetodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMedidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldMedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMedidos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAddAP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonRemoveAP))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonParedesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonParedesActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(this);
        chooser.setMultiSelectionEnabled(false);
        try{
        String text = chooser.getSelectedFile().getAbsolutePath();
        fieldParedes.setText(text);
        fieldParedes.postActionEvent();
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_buttonParedesActionPerformed

    private void listaMetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaMetodoActionPerformed
        // TODO add your handling code here:
        if (listaMetodo.getSelectedIndex() == 0) {
            labelAP.setEnabled(true);
            listaAP.setEnabled(true);
            buttonAddAP.setEnabled(true);
            buttonRemoveAP.setEnabled(true);
            labelMedidos.setEnabled(false);
            fieldMedidos.setEnabled(false);
            buttonMedidos.setEnabled(false);
        } else if (listaMetodo.getSelectedIndex() == 1) {
            labelAP.setEnabled(false);
            listaAP.setEnabled(false);
            buttonAddAP.setEnabled(false);
            buttonRemoveAP.setEnabled(false);
            labelMedidos.setEnabled(true);
            fieldMedidos.setEnabled(true);
            buttonMedidos.setEnabled(true);
        }
    }//GEN-LAST:event_listaMetodoActionPerformed

    private void fieldMedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldMedidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldMedidosActionPerformed

    private void buttonAddAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddAPActionPerformed
        // TODO add your handling code here:

        if (lp.paredes!=null) {
            AccessPoint ap = new AccessPoint();
            String input = JOptionPane.showInputDialog("Entre com as coordenadas do AP (formato x,y,z):");
            String[] coord = input.split(",");
            ap.x = Double.parseDouble(coord[0].trim());
            ap.y = Double.parseDouble(coord[1].trim());
            ap.z = Double.parseDouble(coord[2].trim());
            input = JOptionPane.showInputDialog("Entre com a potência do AP:");
            ap.pot = Double.parseDouble(input.trim());
            input = JOptionPane.showInputDialog("Entre com os ganhos do AP:");
            ap.ganhos = Double.parseDouble(input.trim());
            aps.add(ap);
            listaAP.setListData(aps.toArray());
            double[][] apLoc = new double[aps.size()][3];
            double[] apPot = new double[aps.size()];
            double[] ganhos = new double[aps.size()];
            for (int i = 0; i < apLoc.length; i++) {
                apLoc[i][0] = aps.get(i).x;
                apLoc[i][1] = aps.get(i).y;
                apLoc[i][2] = aps.get(i).z;
                apPot[i] = aps.get(i).pot;
                ganhos[i] = aps.get(i).ganhos;
            }
            Padenizador pade = new Padenizador(lp.width, lp.length, lp.paredes, lp.valorTipoParedes, apLoc, apPot, ganhos);
            pade.padeniza();
            contorno.setAPS(aps);
            contorno.setCampo(pade.fnp);
            contorno.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "A selecao do arquivo de paredes deve ser feita anterior a adicao de pontos de acesso!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonAddAPActionPerformed

    private void buttonRemoveAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveAPActionPerformed
        // TODO add your handling code here:
        int selected = listaAP.getSelectedIndex();
        if (selected != -1) {
            aps.remove(selected);
            listaAP.setListData(aps.toArray());
            if (!aps.isEmpty()) {
                double[][] apLoc = new double[aps.size()][3];
                double[] apPot = new double[aps.size()];
                double[] ganhos = new double[aps.size()];
                for (int i = 0; i < apLoc.length; i++) {
                    apLoc[i][0] = aps.get(i).x;
                    apLoc[i][1] = aps.get(i).y;
                    apLoc[i][2] = aps.get(i).z;
                    apPot[i] = aps.get(i).pot;
                    ganhos[i] = aps.get(i).ganhos;
                }
                Padenizador pade = new Padenizador(lp.width, lp.length, lp.paredes, lp.valorTipoParedes, apLoc, apPot, ganhos);
                pade.padeniza();
                contorno.setAPS(aps);
                contorno.setCampo(pade.fnp);
                contorno.repaint();
            }else{
                contorno.setAPS(null);
                contorno.setCampo(null);
                contorno.repaint();
            }
        }
    }//GEN-LAST:event_buttonRemoveAPActionPerformed

    private void fieldParedesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldParedesActionPerformed
        // TODO add your handling code here:
        System.out.println(fieldParedes.getText());
        lp.lerParedes(fieldParedes.getText());
        contorno.setParedes(lp.width, lp.length, lp.paredes, lp.valorTipoParedes);
        contorno.setVisible(true);
    }//GEN-LAST:event_fieldParedesActionPerformed

    private void fieldParedesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fieldParedesPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldParedesPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Aplicativo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddAP;
    private javax.swing.JButton buttonMedidos;
    private javax.swing.JButton buttonParedes;
    private javax.swing.JButton buttonRemoveAP;
    private javax.swing.JTextField fieldMedidos;
    private javax.swing.JTextField fieldParedes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAP;
    private javax.swing.JLabel labelMedidos;
    private javax.swing.JLabel labelMetodo;
    private javax.swing.JLabel labelParedes;
    private javax.swing.JList listaAP;
    private javax.swing.JComboBox listaMetodo;
    // End of variables declaration//GEN-END:variables
    private ArrayList<AccessPoint> aps = new ArrayList<AccessPoint>();
    private Contorno contorno = new Contorno();
    private LerParedes lp = new LerParedes();
}
