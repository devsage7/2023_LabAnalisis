package ApartadoGrafico;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class JPanelResultados extends javax.swing.JPanel {

    JPanel aux;
    
    public JPanelResultados() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCargarResultado = new javax.swing.JButton();
        jButtonResultadoDeUnaOrden = new javax.swing.JButton();
        jButtonImprimirResultado = new javax.swing.JButton();

        setBackground(new java.awt.Color(218, 243, 234));

        jButtonCargarResultado.setBackground(new java.awt.Color(247, 244, 232));
        jButtonCargarResultado.setText("Cargar Resultado");
        jButtonCargarResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarResultadoActionPerformed(evt);
            }
        });

        jButtonResultadoDeUnaOrden.setBackground(new java.awt.Color(247, 244, 232));
        jButtonResultadoDeUnaOrden.setText("Resultado de una Orden");
        jButtonResultadoDeUnaOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResultadoDeUnaOrdenActionPerformed(evt);
            }
        });

        jButtonImprimirResultado.setBackground(new java.awt.Color(247, 244, 232));
        jButtonImprimirResultado.setText("Imprimir Resultado");
        jButtonImprimirResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirResultadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCargarResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonResultadoDeUnaOrden, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jButtonImprimirResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jButtonCargarResultado)
                .addGap(50, 50, 50)
                .addComponent(jButtonImprimirResultado)
                .addGap(50, 50, 50)
                .addComponent(jButtonResultadoDeUnaOrden)
                .addContainerGap(140, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCargarResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarResultadoActionPerformed
        mensajeAviso("""
                     La funcion a la que ha intentado ingresar se encuentra en desarrollo.
                     Por favor, intente nuevamente m\u00e1s tarde.""","ERROR - FUNCION NO DISPONIBLE");
    }//GEN-LAST:event_jButtonCargarResultadoActionPerformed

    private void jButtonResultadoDeUnaOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResultadoDeUnaOrdenActionPerformed
        JPanelResultadoDeUnaOrden panel = new JPanelResultadoDeUnaOrden();
        showPanel(panel);
    }//GEN-LAST:event_jButtonResultadoDeUnaOrdenActionPerformed

    private void jButtonImprimirResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirResultadoActionPerformed
        mensajeAviso("""
                     La funcion a la que ha intentado ingresar se encuentra en desarrollo.
                     Por favor, intente nuevamente m\u00e1s tarde.""","ERROR - FUNCION NO DISPONIBLE");
    }//GEN-LAST:event_jButtonImprimirResultadoActionPerformed

    private static void mensajeAviso(String mensaje, String titulo){
        javax.swing.JOptionPane.showMessageDialog(null, mensaje, titulo, javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    private void showPanel(JPanel p){
        p.setSize(700,500);
        p.setLocation(0,0);
        aux.removeAll();
        aux.add(p, BorderLayout.CENTER);
        aux.revalidate();
        aux.repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCargarResultado;
    private javax.swing.JButton jButtonImprimirResultado;
    private javax.swing.JButton jButtonResultadoDeUnaOrden;
    // End of variables declaration//GEN-END:variables
}
